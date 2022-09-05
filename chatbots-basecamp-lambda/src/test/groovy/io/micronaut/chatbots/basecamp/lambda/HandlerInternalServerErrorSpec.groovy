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
import jakarta.inject.Singleton
import spock.lang.Specification
import spock.lang.Unroll
import javax.validation.Valid
import javax.validation.constraints.NotNull

class HandlerInternalServerErrorSpec extends Specification {

    private static Map<String, String> PROPS = [:]

    @Unroll
    void "Handler responds 500 and no exception message is leaked"(String header, String value) {
        given:
        Map<String, Object> properties = new HashMap<>(PROPS)
        properties.put("spec.name", "HandlerInternalServerErrorSpec")
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
        500  == response.statusCode
        !response.body

        cleanup:
        handler.close()

        where:
        header                             | value
        'user-agent'                       | 'Basecamp 3 Integration Command'
    }

    @Requires(property = "spec.name", value = "HandlerInternalServerErrorSpec")
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
            throw new RuntimeException("foo")
        }
    }
}
