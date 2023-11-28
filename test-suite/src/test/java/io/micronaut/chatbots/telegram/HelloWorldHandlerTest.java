package io.micronaut.chatbots.telegram;

import io.micronaut.chatbots.core.Dispatcher;
import io.micronaut.chatbots.telegram.api.Update;
import io.micronaut.chatbots.telegram.api.send.Send;
import io.micronaut.chatbots.telegram.api.send.SendMessage;
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.BeanContext;
import io.micronaut.context.annotation.Property;
import io.micronaut.json.JsonMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest(startApplication = false)
@Property(name = "spec.name", value = "telegram")
class HelloWorldHandlerTest {

    @Inject
    BeanContext ctx;

    @Inject
    Dispatcher<TelegramBotConfiguration, Update, Send> dispatcher;

    @Inject
    JsonMapper jsonMapper;

    @Test
    void beanOfTypeHelloWorldHandlerExists() {
        assertTrue(ctx.containsBean(HelloWorldHandler.class));
    }

    @Test
    void aboutCommandHandlerExists() throws Exception {
        Send send = dispatcher.dispatch(null, jsonMapper.readValue(getClass().getResourceAsStream("/about.json"), Update.class)).get();
        assertTrue(send instanceof SendMessage);
        assertEquals("Bot developed with 💙 using [Micronaut](https://micronaut.io)", ((SendMessage) send).getText().trim());
    }

    @Test
    void helloCommandHandlerExists() throws Exception {
        Send send = dispatcher.dispatch(null, jsonMapper.readValue(getClass().getResourceAsStream("/hello.json"), Update.class)).get();
        assertTrue(send instanceof SendMessage);
        assertEquals("Hello World", ((SendMessage) send).getText());
    }

    @Test
    void unknownCommandHandlerExists() throws Exception {
        Send send = dispatcher.dispatch(null, jsonMapper.readValue(getClass().getResourceAsStream("/text.json"), Update.class)).get();
        assertTrue(send instanceof SendMessage);
        assertEquals("I don't how to handle your query: some text", ((SendMessage) send).getText());
    }
}
