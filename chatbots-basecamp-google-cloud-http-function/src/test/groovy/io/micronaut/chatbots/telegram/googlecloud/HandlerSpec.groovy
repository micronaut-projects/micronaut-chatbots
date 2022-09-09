package io.micronaut.chatbots.telegram.googlecloud

import com.google.cloud.functions.HttpRequest
import com.google.cloud.functions.HttpResponse
import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.basecamp.core.BasecampHandler
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.annotation.Nullable
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import jakarta.inject.Singleton
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import javax.validation.constraints.NotNull
import java.nio.charset.StandardCharsets

class HandlerSpec extends Specification {

    @Shared
    @AutoCleanup
    Handler function = new Handler()

    void "test function"() {
        given:
        File f = new File('src/test/resources/test.json')
        HttpRequest request = createRequest(f.text)
        HttpResponse response = createResponse()

        when:
        function.service(request, response)
        String result = ((ByteArrayOutputStream) response.outputStream).toString(StandardCharsets.UTF_8)

        then:
        HttpStatus.OK.code  == response.status
        'John Snow: HELLO <b>WORLD</b>' == result
        MediaType.TEXT_HTML == response.contentType
    }

    @NonNull
    private static HttpResponse createResponse() {
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

    private static HttpRequest createRequest(String body) {
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
                [:]
            }
        }
    }

    @Singleton
    static class HelloWorld implements BasecampHandler {

        @Override
        boolean canHandle(@Nullable BasecampBotConfiguration bot,
                          @NonNull @NotNull Query query) {
            true
        }

        @Override
        Optional<String> handle(@Nullable BasecampBotConfiguration bot,
                                @NonNull @NotNull Query query) {
            Optional.of("${query.creator.name}: ${query.command.toUpperCase()} <b>WORLD</b>".toString())
        }
    }
}
