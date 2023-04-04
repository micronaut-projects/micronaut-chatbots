package io.micronaut.chatbots.basecamp.lambda

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.basecamp.core.BasecampHandler
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Requires
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.annotation.Nullable
import io.micronaut.http.HttpHeaders
import io.micronaut.http.MediaType
import jakarta.inject.Singleton
import spock.lang.Specification
import spock.lang.Unroll

import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull

class HandlerSpec extends Specification {

    private static Map<String, String> PROPS = [:]

    void "Handler has empty constructor"() {
        when:
        new Handler()

        then:
        noExceptionThrown()
    }

    void "Handler responds 401 if HTTP Header User-agent does not contain Basecamp"(String header, String value) {
        given:
        Handler handler = new Handler(ApplicationContext.builder().properties(PROPS))

        File f = new File('src/test/resources/test.json')

        expect:
        f.exists()

        when:
        APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent()
        request.body = f.text
        request.headers = Collections.singletonMap(header, value)
        APIGatewayProxyResponseEvent response = handler.handleRequest(request, null)

        then:
        401  == response.statusCode

        cleanup:
        handler.close()

        where:
        header                             |  value
        'user-agent'                       | 'Hacker'
    }

    @Unroll
    void "Handler responds 200 and message is not present"(String header, String value) {
        given:
        Map<String, Object> properties = new HashMap<>(PROPS)
        properties.put("spec.name", "Handler200Spec")
        Handler handler = new Handler(ApplicationContext.builder().properties(properties))
        File f = new File('src/test/resources/test.json')

        expect:
        f.exists()

        when:
        APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent()
        request.body = f.text
        request.headers = Collections.singletonMap(header, value)
        APIGatewayProxyResponseEvent response = handler.handleRequest(request, null)

        then:
        200  == response.statusCode
        'John Snow: HELLO <b>WORLD</b>' == response.body
        MediaType.TEXT_HTML == response.headers.get(HttpHeaders.CONTENT_TYPE)

        cleanup:
        handler.close()

        where:
        header                             | value
        'user-agent'                       | 'Basecamp 3 Integration Command'
        HttpHeaders.USER_AGENT             | 'Basecamp 3 Integration Command'
    }

    @Requires(property = "spec.name", value = "Handler200Spec")
    @Singleton
    static class HelloWorld implements BasecampHandler {

        @Override
        boolean canHandle(@Nullable BasecampBotConfiguration bot,
                          @NonNull @NotNull @Valid Query query) {
            true
        }

        @Override
        Optional<String> handle(@Nullable BasecampBotConfiguration bot,
                                @NonNull @NotNull @Valid Query query) {
            Optional.of("${query.creator.name}: ${query.command.toUpperCase()} <b>WORLD</b>".toString())
        }
    }
}
