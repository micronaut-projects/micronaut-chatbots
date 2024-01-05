package io.micronaut.chatbots.basecamp;

import io.micronaut.chatbots.basecamp.api.Query;
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration;
import io.micronaut.chatbots.core.Dispatcher;
import io.micronaut.chatbots.telegram.api.Update;
import io.micronaut.chatbots.telegram.api.send.Send;
import io.micronaut.chatbots.telegram.api.send.SendMessage;
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration;
import io.micronaut.context.BeanContext;
import io.micronaut.context.annotation.Property;
import io.micronaut.json.JsonMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest(startApplication = false)
@Property(name = "spec.name", value = "basecamp")
class HelloWorldHandlerTest {

    @Inject
    BeanContext ctx;

    @Inject
    Dispatcher<BasecampBotConfiguration, Query, String> dispatcher;

    @Inject
    JsonMapper jsonMapper;

    @Test
    void beanOfTypeHelloWorldHandlerExists() {
        assertTrue(ctx.containsBean(HelloWorldHandler.class));
    }

    @Test
    void aboutCommandHandlerExists() throws Exception {
        String send = dispatcher.dispatch(null, jsonMapper.readValue(getClass().getResourceAsStream("/basecampAbout.json"), Query.class)).get();
        assertEquals("Bot developed with 💙 using [Micronaut](https://micronaut.io)", send.trim());
    }

    @Test
    void helloCommandHandlerExists() throws Exception {
        String send = dispatcher.dispatch(null, jsonMapper.readValue(getClass().getResourceAsStream("/basecampHello.json"), Query.class)).get();
        assertEquals("Hello World", send);
    }

    @Test
    void unknownCommandHandlerExists() throws Exception {
        String send = dispatcher.dispatch(null, jsonMapper.readValue(getClass().getResourceAsStream("/basecampText.json"), Query.class)).get();
        assertEquals("I don't know how to handle your query: some text", send);
    }
}
