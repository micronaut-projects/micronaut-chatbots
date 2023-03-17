package io.micronaut.chatbots.basecamp.http

import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.basecamp.core.BasecampHandler
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Requires
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.annotation.Nullable
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import jakarta.inject.Singleton
import jakarta.validation.constraints.NotNull
import spock.lang.Specification

class BasecampControllerSpec extends Specification {
    void "Verify BasecampController success payload"(String path, Map<String, String> props) {
        given:
        Map<String, String> properties = new HashMap<>(props)
        properties.put("spec.name", "BasecampControllerSpec")
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer, properties)
        HttpClient httpClient = server.applicationContext.createBean(HttpClient.class, server.URL)
        BlockingHttpClient client = httpClient.toBlocking()
        File f = new File('src/test/resources/test.json')

        expect:
        f.exists()

        when:
        HttpResponse<String> response = client.exchange(HttpRequest.POST(path, f.text).accept(MediaType.TEXT_HTML), String.class)

        then:
        noExceptionThrown()
        HttpStatus.OK  == response.status()
        'John Snow: HELLO <b>WORLD</b>' == response.body.get()
        MediaType.TEXT_HTML == response.headers.get(HttpHeaders.CONTENT_TYPE)


        cleanup:
        httpClient.close()
        server.close()

        where:
        path        | props
        '/basecamp' | [:]
        '/foo'      | ['micronaut.chatbots.basecamp.endpoint.path': '/foo']
    }

    @Requires(property = "spec.name", value = "BasecampControllerSpec")
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

