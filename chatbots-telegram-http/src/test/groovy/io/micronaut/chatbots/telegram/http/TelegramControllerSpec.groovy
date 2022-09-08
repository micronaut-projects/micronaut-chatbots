package io.micronaut.chatbots.telegram.http

import io.micronaut.chatbots.core.SpaceParser
import io.micronaut.chatbots.telegram.api.Chat
import io.micronaut.chatbots.telegram.api.Update
import io.micronaut.chatbots.telegram.api.send.SendMessage
import io.micronaut.chatbots.telegram.core.SendMessageUtils
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration
import io.micronaut.chatbots.telegram.core.TelegramHandler
import io.micronaut.chatbots.telegram.core.TokenValidator
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Requires
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.annotation.Nullable
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.server.EmbeddedServer
import jakarta.inject.Singleton
import spock.lang.Specification

import javax.validation.Valid
import javax.validation.constraints.NotNull

class TelegramControllerSpec extends Specification {
    void "Verify TelegramController success payload"(String path, Map<String, String> props) {
        given:
        Map<String, String> properties = new HashMap<>(props)
        properties.put("spec.name", "TelegramControllerSpec")
        properties.put("micronaut.chatbots.telegram.bots.mn-bot.token", "xxx")
        properties.put("micronaut.chatbots.telegram.bots.mn-bot.at-username", "@MnBot")
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer, properties)
        HttpClient httpClient = server.applicationContext.createBean(HttpClient.class, server.URL)
        BlockingHttpClient client = httpClient.toBlocking()
        File f = new File('src/test/resources/text.json')

        expect:
        f.exists()

        when:
        Map expected = [
                "text":"Hello World",
                "method":"sendMessage",
                "chat_id":718265379
        ]
        HttpResponse<Map> response = client.exchange(HttpRequest.POST(path, f.text)
                .header(TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN, "xxx"), Map.class)

        then:
        noExceptionThrown()
        HttpStatus.OK  == response.status()

        when:
        Map result = response.body()

        then:
        result
        expected.size() == result.size()
        expected.text == result.text
        expected.method == result.method
        expected.chat_id == result.chat_id

        cleanup:
        httpClient.close()
        server.close()

        where:
        path        | props
        '/telegram' | [:]
        '/foo' | ['micronaut.chatbots.telegram.endpoint.path': '/foo']
    }

    void "Verify TelegramController unauthorized payload in no header present"() {
        given:
        Map<String, String> properties = new HashMap<>()
        properties.put("micronaut.chatbots.telegram.bots.mn-bot.token", "xxx")
        properties.put("micronaut.chatbots.telegram.bots.mn-bot.at-username", "@MnBot")
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer, properties)
        HttpClient httpClient = server.applicationContext.createBean(HttpClient.class, server.URL)
        BlockingHttpClient client = httpClient.toBlocking()
        File f = new File('src/test/resources/text.json')

        expect:
        f.exists()

        when:
        client.exchange(HttpRequest.POST("/telegram", f.text)
                .header(TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN, "yyy"), Map.class)

        then:
        HttpClientResponseException ex = thrown()
        HttpStatus.UNAUTHORIZED  == ex.status

        cleanup:
        httpClient.close()
        server.close()
    }

    @Requires(property = "spec.name", value = "TelegramControllerSpec")
    @Singleton
    static class HelloWorld implements TelegramHandler<SendMessage> {

        private final SpaceParser<Update, Chat> spaceParser;

        HelloWorld(SpaceParser<Update, Chat> spaceParser) {
            this.spaceParser = spaceParser
        }

        @Override
        boolean canHandle(@Nullable TelegramBotConfiguration telegramBotConfiguration,
                          @NonNull @NotNull @Valid Update update) {
            true
        }

        @Override
        Optional<SendMessage> handle(@Nullable TelegramBotConfiguration telegramBotConfiguration,
                                     @NonNull @NotNull @Valid Update update) {
            SendMessageUtils.compose(spaceParser, update, "Hello World")
        }
    }
}

