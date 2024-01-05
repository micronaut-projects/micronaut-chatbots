package io.micronaut.chatbots.basecamp

import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.core.Dispatcher
import io.micronaut.context.BeanContext
import io.micronaut.context.annotation.Property
import io.micronaut.json.JsonMapper
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

@MicronautTest(startApplication = false)
@Property(name = "spec.name", value = "basecamp")
class HelloWorldHandlerTest {

    @Inject
    lateinit var ctx: BeanContext

    @Inject
    lateinit var dispatcher: Dispatcher<BasecampBotConfiguration, Query, String>

    @Inject
    lateinit var jsonMapper: JsonMapper

    @Test
    fun beanOfTypeHelloWorldHandlerExists() {
        assertTrue(ctx.containsBean(HelloWorldHandler::class.java))
    }

    @Test
    fun aboutCommandHandlerExists() {
        val send = dispatcher.dispatch(null, jsonMapper.readValue(javaClass.getResourceAsStream("/basecampAbout.json"), Query::class.java)).get()
        assertEquals("Bot developed with 💙 using [Micronaut](https://micronaut.io)", send.trim())
    }

    @Test
    fun helloCommandHandlerExists() {
        val send = dispatcher.dispatch(null, jsonMapper.readValue(javaClass.getResourceAsStream("/basecampHello.json"), Query::class.java)).get()
        assertEquals("Hello World", send)
    }

    @Test
    fun unknownCommandHandlerExists() {
        val send = dispatcher.dispatch(null, jsonMapper.readValue(javaClass.getResourceAsStream("/basecampText.json"), Query::class.java)).get()
        assertEquals("I don't know how to handle your query: some text", send)
    }
}
