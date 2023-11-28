package io.micronaut.chatbots.basecamp

import io.micronaut.context.BeanContext
import io.micronaut.context.annotation.Property
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

@MicronautTest(startApplication = false)
@Property(name = "spec.name", value = "basecamp")
internal class HelloWorldHandlerTest {

    @Inject
    lateinit var ctx: BeanContext

    @Test
    fun beanOfTypeHelloWorldHandlerExists() {
        assertTrue(ctx.containsBean(HelloWorldHandler::class.java))
    }
}

