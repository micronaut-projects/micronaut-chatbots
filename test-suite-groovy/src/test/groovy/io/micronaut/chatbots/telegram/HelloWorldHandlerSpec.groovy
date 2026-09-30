package io.micronaut.chatbots.telegram

import io.micronaut.chatbots.core.Dispatcher
import io.micronaut.chatbots.telegram.api.Update
import io.micronaut.chatbots.telegram.api.send.Send
import io.micronaut.chatbots.telegram.api.send.SendMessage
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration
import io.micronaut.context.BeanContext
import io.micronaut.context.annotation.Property
import io.micronaut.json.JsonMapper
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest(startApplication = false)
@Property(name = "spec.name", value = "telegram")
class HelloWorldHandlerSpec extends Specification {

    @Inject
    BeanContext ctx

    @Inject
    Dispatcher<TelegramBotConfiguration, Update, Send> dispatcher

    @Inject
    JsonMapper jsonMapper

    void "bean of type HelloWorldHandler exists"() {
        expect:
        ctx.containsBean(HelloWorldHandler.class)
    }

    void "about command handler exists"() {
        when:
        def result = dispatcher.dispatch(null, jsonMapper.readValue(this.class.getResource("/about.json").text, Update)).get()

        then:
        result instanceof SendMessage
        result.text.trim() == 'Bot developed with 💙 using [Micronaut](https://micronaut.io)'
    }

    void "hello command handler exists"() {
        when:
        def result = dispatcher.dispatch(null, jsonMapper.readValue(this.class.getResource("/hello.json").text, Update)).get()

        then:
        result instanceof SendMessage
        result.text.trim() == 'Hello World'
    }

    void "unknown command handler exists"() {
        when:
        def result = dispatcher.dispatch(null, jsonMapper.readValue(this.class.getResource("/text.json").text, Update)).get()

        then:
        result instanceof SendMessage
        result.text.trim() == "I don't how to handle your query: some text"
    }
}
