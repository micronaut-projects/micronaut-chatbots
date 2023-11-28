package io.micronaut.chatbots.basecamp;

import io.micronaut.context.BeanContext;
import io.micronaut.context.annotation.Property;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest(startApplication = false)
@Property(name = "spec.name", value = "basecamp")
class HelloWorldHandlerTest {

    @Inject
    BeanContext ctx;

    @Test
    void beanOfTypeHelloWorldHandlerExists() {
        assertTrue(ctx.containsBean(HelloWorldHandler.class));
    }
}
