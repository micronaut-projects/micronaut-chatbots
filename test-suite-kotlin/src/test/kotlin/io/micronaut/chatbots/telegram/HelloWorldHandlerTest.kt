package io.micronaut.chatbots.telegram

import io.micronaut.chatbots.core.Dispatcher
import io.micronaut.chatbots.telegram.api.Update
import io.micronaut.chatbots.telegram.api.send.Send
import io.micronaut.chatbots.telegram.api.send.SendMessage
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration
import io.micronaut.context.BeanContext
import io.micronaut.context.annotation.Property
import io.micronaut.json.JsonMapper
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

@MicronautTest(startApplication = false)
@Property(name = "spec.name", value = "telegram")
class HelloWorldHandlerTest {

    @Inject
    lateinit var ctx: BeanContext

    @Inject
    lateinit var dispatcher: Dispatcher<TelegramBotConfiguration, Update, Send>

    @Inject
    lateinit var jsonMapper: JsonMapper

    @Test
    fun beanOfTypeHelloWorldHandlerExists() {
        assertTrue(ctx.containsBean(HelloWorldHandler::class.java))
    }

    @Test
    @Throws(Exception::class)
    fun aboutCommandHandlerExists() {
        val send = dispatcher.dispatch(null, jsonMapper.readValue(javaClass.getResourceAsStream("/about.json"), Update::class.java)).get()

        assertTrue(send is SendMessage)
        Assertions.assertEquals(
            "Bot developed with 💙 using [Micronaut](https://micronaut.io)",
            (send as SendMessage).text.trim { it <= ' ' })
    }

    @Test
    @Throws(Exception::class)
    fun helloCommandHandlerExists() {
        val send = dispatcher.dispatch(null, jsonMapper.readValue(javaClass.getResourceAsStream("/hello.json"), Update::class.java)).get()

        assertTrue(send is SendMessage)
        Assertions.assertEquals("Hello World", (send as SendMessage).text)
    }

    @Test
    @Throws(Exception::class)
    fun unknownCommandHandlerExists() {
        val send = dispatcher.dispatch(null, jsonMapper.readValue(javaClass.getResourceAsStream("/text.json"), Update::class.java)).get()

        assertTrue(send is SendMessage)
        Assertions.assertEquals("I don't how to handle your query: some text", (send as SendMessage).text)
    }
}
