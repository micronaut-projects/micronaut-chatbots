package io.micronaut.chatbots.telegram.lambda

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import io.micronaut.chatbots.core.SpaceParser
import io.micronaut.chatbots.telegram.api.Chat
import io.micronaut.chatbots.telegram.api.Update
import io.micronaut.chatbots.telegram.api.send.SendMessage
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration
import io.micronaut.chatbots.telegram.core.TelegramHandler
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Requires
import io.micronaut.core.annotation.NonNull
import jakarta.inject.Singleton
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Valid
import javax.validation.constraints.NotNull

class HandlerSpec extends Specification {

    private static Map<String, String> PROPS = [
    "micronaut.chatbots.telegram.bots.mn-bot.token": "xxx",
    "micronaut.chatbots.telegram.bots.mn-bot.at-username": "@MnBot",
    ]

    void "Handler has empty constructor"() {
        when:
        new Handler()

        then:
        noExceptionThrown()
    }

    void "Handler responds 401 if HTTP Header X-Telegram-Bot-Api-Secret-Token is not present"() {
        given:
        Handler handler = new Handler(ApplicationContext.builder().properties(PROPS))

        File f = new File('src/test/resources/text.json')

        expect:
        f.exists()

        when:
        APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent()
        request.body = f.text
        APIGatewayProxyResponseEvent response = handler.handleRequest(request, null)

        then:
        401  == response.statusCode

        cleanup:
        handler.close()
    }

    @Unroll
    void "Handler responds 200 and message is not present"(String header, String value) {
        given:
        Map<String, Object> properties = new HashMap<>(PROPS)
        properties.put("spec.name", "Handler200Spec")
        Handler handler = new Handler(ApplicationContext.builder().properties(properties))
        File f = new File('src/test/resources/text.json')

        expect:
        f.exists()

        when:
        APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent()
        request.body = f.text
        request.headers = Collections.singletonMap(header, value)
        APIGatewayProxyResponseEvent response = handler.handleRequest(request, null)

        then:
        200  == response.statusCode
        '{"text":"Hello World","method":"sendMessage","chat_id":718265379}' == response.body

        cleanup:
        handler.close()

        where:
        header                             | value
        'X-Telegram-Bot-Api-Secret-Token'  | 'xxx'
        'x-telegram-bot-api-secret-token'  | 'xxx'
    }

    @Requires(property = "spec.name", value = "Handler200Spec")
    @Singleton
    static class HelloWorld implements TelegramHandler<SendMessage> {

        private final SpaceParser<Update, Chat> spaceParser;

        HelloWorld(SpaceParser<Update, Chat> spaceParser) {
            this.spaceParser = spaceParser
        }

        @Override
        boolean canHandle(@NonNull @NotNull @Valid TelegramBotConfiguration telegramBotConfiguration,
                          @NonNull @NotNull @Valid Update update) {
            true
        }

        @Override
        Optional<SendMessage> handle(@NonNull @NotNull @Valid TelegramBotConfiguration telegramBotConfiguration, @NonNull @NotNull @Valid Update update) {
            spaceParser.parse(update)
                    .map(space -> {
                        SendMessage message = new SendMessage()
                        message.setText("Hello World")
                        message.chatId = space.id
                        message
                    })
        }
    }
}
