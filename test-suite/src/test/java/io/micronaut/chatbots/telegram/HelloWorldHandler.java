package io.micronaut.chatbots.telegram;

import io.micronaut.chatbots.core.SpaceParser;
import io.micronaut.chatbots.telegram.api.Chat;
import io.micronaut.chatbots.telegram.api.Update;
import io.micronaut.chatbots.telegram.api.send.SendMessage;
import io.micronaut.chatbots.telegram.core.SendMessageUtils;
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration;
import io.micronaut.chatbots.telegram.core.TelegramHandler;
import io.micronaut.context.annotation.Requires;
import org.jspecify.annotations.Nullable;
import jakarta.inject.Singleton;

import jakarta.validation.constraints.NotNull;
import java.util.Optional;

@Requires(property = "spec.name", value = "telegram")
// tag::class[]
@Singleton
class HelloWorldHandler implements TelegramHandler<SendMessage> {

    private final SpaceParser<Update, Chat> spaceParser;

    HelloWorldHandler(SpaceParser<Update, Chat> spaceParser) {
        this.spaceParser = spaceParser;
    }

    @Override
    public boolean canHandle(@Nullable TelegramBotConfiguration bot, @NotNull Update input) {
        return input.getMessage().getText().contains("hello");
    }

    @Override
    public Optional<SendMessage> handle(@Nullable TelegramBotConfiguration bot, @NotNull Update input) {
        return SendMessageUtils.compose(spaceParser, input, "Hello World");
    }
}
// end::class[]
