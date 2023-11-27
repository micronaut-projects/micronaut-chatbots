package io.micronaut.chatbots.telegram.azurefunction

import com.microsoft.azure.functions.HttpMethod
import com.microsoft.azure.functions.HttpRequestMessage
import com.microsoft.azure.functions.HttpResponseMessage
import com.microsoft.azure.functions.HttpStatus
import com.microsoft.azure.functions.HttpStatusType
import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.basecamp.core.BasecampHandler
import io.micronaut.chatbots.basecamp.azurefunction.Handler
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.annotation.Nullable
import io.micronaut.http.HttpHeaders
import io.micronaut.http.MediaType
import io.micronaut.serde.ObjectMapper
import jakarta.inject.Singleton
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll
import jakarta.validation.constraints.NotNull

class HandlerSpec extends Specification {
    @AutoCleanup
    @Shared
    Handler handler = new Handler()

    @Unroll
    void "Handler responds 200 and message is not present"() {
        given:
        def body = HandlerSpec.getResourceAsStream('/test.json').text

        when:
        ObjectMapper objectMapper = handler.applicationContext.getBean(ObjectMapper)
        Query input = objectMapper.readValue(body, Query)

        HttpRequestMessage request = createRequest(input)
        HttpResponseMessage response = handler.handle(request, null)

        then:
        200  == response.statusCode
        'John Snow: HELLO <b>WORLD</b>' ==  response.body
        MediaType.TEXT_HTML == response.getHeader(HttpHeaders.CONTENT_TYPE)
    }

    private static HttpRequestMessage createRequest(Query input) {
        new HttpRequestMessage<Query>() {
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
                [:]
            }

            @Override
            Map<String, String> getQueryParameters() {
                return null
            }

            @Override
            Query getBody() {
                input
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
