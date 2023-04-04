package io.micronaut.chatbots.telegram;

import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HelloWorldHandlerTest {

    @Test
    void beanOfTypeHelloWorldHandlerExists() {
        ApplicationContext ctx = ApplicationContext.run();
        assertTrue(ctx.containsBean(HelloWorldHandler.class));
        ctx.close();
    }
}
