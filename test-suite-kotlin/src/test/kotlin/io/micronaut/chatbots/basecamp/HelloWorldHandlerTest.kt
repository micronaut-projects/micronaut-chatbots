package io.micronaut.chatbots.basecamp

import io.micronaut.context.ApplicationContext
import org.junit.jupiter.api.Test

internal class HelloWorldHandlerTest {
    @Test
    fun beanOfTypeHelloWorldHandlerExists() {
        val ctx = ApplicationContext.run()
        ctx.containsBean(HelloWorldHandler::class.java)
        ctx.close()
    }
}
