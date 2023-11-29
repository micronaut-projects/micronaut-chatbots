package io.micronaut.chatbots.telegram.azurefunction

import com.microsoft.azure.functions.HttpMethod
import com.microsoft.azure.functions.HttpRequestMessage
import com.microsoft.azure.functions.HttpResponseMessage
import com.microsoft.azure.functions.HttpStatus
import com.microsoft.azure.functions.HttpStatusType
import groovy.json.JsonSlurper
import io.micronaut.chatbots.core.SpaceParser
import io.micronaut.chatbots.telegram.api.Chat
import io.micronaut.chatbots.telegram.api.Update
import io.micronaut.chatbots.telegram.api.send.SendMessage
import io.micronaut.chatbots.telegram.core.SendMessageUtils
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration
import io.micronaut.chatbots.telegram.core.TelegramHandler
import io.micronaut.chatbots.telegram.core.TokenValidator
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.ObjectMapper
import jakarta.inject.Singleton
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull

class HandlerSpec extends Specification {

    @AutoCleanup
    @Shared
    Handler handler = new Handler()

    void "Handler responds 401 if header does not match not present"() {
        given:
        File f = new File('src/test/resources/text.json')

        expect:
        f.exists()

        when:
        ObjectMapper objectMapper = handler.applicationContext.getBean(ObjectMapper)
        Update update = objectMapper.readValue(f.text, Update)
        HttpRequestMessage request = createRequest(Collections.singletonMap(TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN, "yyy"), update)
        HttpResponseMessage response = handler.handle(request, null)

        then:
        401  == response.statusCode
    }

    void "Handler responds 401 if header not present"() {
        given:
        File f = new File('src/test/resources/text.json')

        expect:
        f.exists()

        when:
        ObjectMapper objectMapper = handler.applicationContext.getBean(ObjectMapper)
        Update update = objectMapper.readValue(f.text, Update)
        HttpRequestMessage request = createRequest(Collections.emptyMap(), update)
        HttpResponseMessage response = handler.handle(request, null)

        then:
        401  == response.statusCode
    }


    void "Handler responds 200 and message is not present"(String header, String value) {
        given:
        File f = new File('src/test/resources/text.json')

        expect:
        f.exists()

        when:
        ObjectMapper objectMapper = handler.applicationContext.getBean(ObjectMapper)
        Update update = objectMapper.readValue(f.text, Update)

        HttpRequestMessage request = createRequest(Collections.singletonMap(TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN, "xxx"), update)
        HttpResponseMessage response = handler.handle(request, null)

        then:
        response.statusCode == 200
        with(new JsonSlurper().parseText(response.body)) {
            method == 'sendMessage'
            chat_id == 718265379
            text == 'Hello World'
        }

        where:
        header                             | value
        'X-Telegram-Bot-Api-Secret-Token'  | 'xxx'
        'x-telegram-bot-api-secret-token'  | 'xxx'
    }

    private static HttpRequestMessage createRequest(Map<String, String> headersParam, Update update) {
        new HttpRequestMessage<Update>() {
            @Override
            URI getUri() {
                return null
            }

            @Override
            HttpMethod getHttpMethod() {
                return HttpMethod.POST
            }

            @Override
            Map<String, String> getHeaders() {
                headersParam
            }

            @Override
            Map<String, String> getQueryParameters() {
                return null
            }

            @Override
            Update getBody() {
                update
            }

            @Override
            HttpResponseMessage.Builder createResponseBuilder(HttpStatus status) {
                new HttpResponseMessageBuilderMock().status(status)
            }

            @Override
            HttpResponseMessage.Builder createResponseBuilder(HttpStatusType status) {
                createResponseBuilder(HttpStatus.valueOf(status.value()))
            }
        }
    }

    @Singleton
    static class HelloWorld implements TelegramHandler<SendMessage> {

        private final SpaceParser<Update, Chat> spaceParser

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

    static class HttpResponseMessageMock implements HttpResponseMessage {
        HttpStatusType status
        Object body
        Map<String, String> headers

        HttpResponseMessageMock(HttpStatusType status,
                                Object body,
                                Map<String, String> headers) {
            this.status = status
            this.body = body
            this.headers = headers
        }

        @Override
        HttpStatusType getStatus() {
            status
        }

        @Override
        String getHeader(String key) {
            headers[key]
        }

        @Override
        Object getBody() {
            body
        }
    }

    static class HttpResponseMessageBuilderMock implements HttpResponseMessage.Builder {
        HttpStatusType status
        Object body
        Map<String, String> headers = new HashMap<>()

        @Override
        HttpResponseMessage.Builder status(HttpStatusType status) {
            this.status = status
            this
        }

        @Override
        HttpResponseMessage.Builder header(String key, String value) {
            this.headers.put(key, value)
            this
        }

        @Override
        HttpResponseMessage.Builder body(Object body) {
            this.body = body
            this
        }

        @Override
        HttpResponseMessage build() {
            return new HttpResponseMessageMock(status, body, headers)
        }
    }
}
