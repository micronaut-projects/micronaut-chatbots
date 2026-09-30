package io.micronaut.chatbots.basecamp

import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.core.Dispatcher
import io.micronaut.context.BeanContext
import io.micronaut.context.annotation.Property
import io.micronaut.json.JsonMapper
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest(startApplication = false)
@Property(name = "spec.name", value = "basecamp")
class HelloWorldHandlerSpec extends Specification {

    @Inject
    BeanContext ctx

    @Inject
    Dispatcher<BasecampBotConfiguration, Query, String> dispatcher;

    @Inject
    JsonMapper jsonMapper;

    void "bean of type HelloWorldHandler exists"() {
        expect:
        ctx.containsBean(HelloWorldHandler)
    }

    void "about command handler exists"() {
        when:
        String send = dispatcher.dispatch(null, jsonMapper.readValue(getClass().getResourceAsStream("/basecampAbout.json"), Query.class)).get()

        then:
        send.trim() == "Bot developed with 💙 using [Micronaut](https://micronaut.io)"
    }

    void "hello command handler exists"() throws Exception {
        when:
        String send = dispatcher.dispatch(null, jsonMapper.readValue(getClass().getResourceAsStream("/basecampHello.json"), Query.class)).get()

        then:
        send == "Hello World"
    }

    void "unknown command handler exists"() {
        when:
        String send = dispatcher.dispatch(null, jsonMapper.readValue(getClass().getResourceAsStream("/basecampText.json"), Query.class)).get()

        then:
        send == "I don't know how to handle your query: some text"
    }
}
