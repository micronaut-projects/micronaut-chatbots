package io.micronaut.chatbots.telegram.googlecloud

import com.google.cloud.functions.HttpRequest
import com.google.cloud.functions.HttpResponse
import io.micronaut.chatbots.core.SpaceParser
import io.micronaut.chatbots.telegram.api.Chat
import io.micronaut.chatbots.telegram.api.Update
import io.micronaut.chatbots.telegram.api.send.SendMessage
import io.micronaut.chatbots.telegram.core.SendMessageUtils
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration
import io.micronaut.chatbots.telegram.core.TelegramHandler
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.annotation.Nullable
import io.micronaut.http.HttpStatus
import jakarta.inject.Singleton
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import javax.validation.Valid
import javax.validation.constraints.NotNull
import java.nio.charset.StandardCharsets

class HandlerSpec extends Specification {

    @Shared
    @AutoCleanup
    Handler function = new Handler()

    void "Handler responds 401 if HTTP Header X-Telegram-Bot-Api-Secret-Token is #description"() {
        given:
        File f = new File('src/test/resources/text.json')
        HttpRequest request = createRequest(f.text, tokens)
        HttpResponse response = createResponse()

        when:
        function.service(request, response)

        then:
        response.status == HttpStatus.UNAUTHORIZED.code

        where:
        description   | tokens
        'not present' | [:]
        'incorrect'   | ['X-Telegram-Bot-Api-Secret-Token': ['yyy']]
    }

    void "test function"() {
        given:
        File f = new File('src/test/resources/text.json')
        HttpRequest request = createRequest(f.text, ['X-Telegram-Bot-Api-Secret-Token': ['yyy', 'xxx']])
        HttpResponse response = createResponse()

        when:
        function.service(request, response)
        String result = ((ByteArrayOutputStream) response.outputStream).toString(StandardCharsets.UTF_8)

        then:
        response.status == HttpStatus.OK.code
        result == '{"method":"sendMessage","chat_id":718265379,"text":"Hello World"}'
    }

    void "test null update is unprocessable"() {
        given:
        HttpRequest request = createRequest('null', ['X-Telegram-Bot-Api-Secret-Token': ['yyy', 'xxx']])
        HttpResponse response = createResponse()

        when:
        function.service(request, response)

        then:
        response.status == HttpStatus.UNPROCESSABLE_ENTITY.code
    }

    @NonNull
    HttpResponse createResponse() {
        new HttpResponse() {
            int status
            String contentType
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream()

            @Override
            void setStatusCode(int code) {
                this.status = code
            }

            @Override
            void setStatusCode(int code, String message) {

            }

            @Override
            void setContentType(String contentType) {
                this.contentType = contentType
            }

            @Override
            Optional<String> getContentType() {
                return Optional.ofNullable(contentType)
            }

            @Override
            void appendHeader(String header, String value) {

            }

            @Override
            Map<String, List<String>> getHeaders() {
                return null
            }

            @Override
            OutputStream getOutputStream() throws IOException {
                return outputStream
            }

            @Override
            BufferedWriter getWriter() throws IOException {
                return null
            }
        }
    }

    HttpRequest createRequest(String body, Map<String, List<String>> headers) {
        new HttpRequest() {
            @Override
            String getMethod() {
                return null
            }

            @Override
            String getUri() {
                return null
            }

            @Override
            String getPath() {
                return null
            }

            @Override
            Optional<String> getQuery() {
                return null
            }

            @Override
            Map<String, List<String>> getQueryParameters() {
                return null
            }

            @Override
            Map<String, HttpRequest.HttpPart> getParts() {
                return null
            }

            @Override
            Optional<String> getContentType() {
                return null
            }

            @Override
            long getContentLength() {
                return 0
            }

            @Override
            Optional<String> getCharacterEncoding() {
                return null
            }

            @Override
            InputStream getInputStream() throws IOException {
                new ByteArrayInputStream(body.bytes)
            }

            @Override
            BufferedReader getReader() throws IOException {
                return null
            }

            @Override
            Map<String, List<String>> getHeaders() {
                headers
            }
        }
    }

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
