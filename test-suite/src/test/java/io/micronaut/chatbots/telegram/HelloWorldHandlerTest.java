package io.micronaut.chatbots.telegram;

import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Test;

class HelloWorldHandlerTest {

    @Test
    void beanOfTypeHelloWorldHandlerExists() {
        ApplicationContext ctx = ApplicationContext.run();
        ctx.containsBean(HelloWorldHandler.class);
        ctx.close();
    }
}
