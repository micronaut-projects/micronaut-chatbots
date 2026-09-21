package io.micronaut.chatbots.docs.telegram

import io.micronaut.chatbots.core.SpaceParser
import io.micronaut.chatbots.telegram.api.Chat
import io.micronaut.chatbots.telegram.api.Update
import io.micronaut.chatbots.telegram.api.send.SendMessage
import io.micronaut.chatbots.telegram.core.SendMessageUtils
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration
import io.micronaut.chatbots.telegram.core.TelegramHandler
import io.micronaut.context.annotation.Requires
import io.micronaut.core.annotation.Nullable
import jakarta.inject.Singleton

import jakarta.validation.constraints.NotNull

@Requires(property = "spec.name", value = "telegram")
// tag::class[]
@Singleton
class HelloWorldHandler implements TelegramHandler<SendMessage> {

    private final SpaceParser<Update, Chat> spaceParser

    HelloWorldHandler(SpaceParser<Update, Chat> spaceParser) {
        this.spaceParser = spaceParser
    }

    @Override
    boolean canHandle(@Nullable TelegramBotConfiguration bot, @NotNull Update input) {
        input.message.text.contains("hello")
    }

    @Override
    Optional<SendMessage> handle(@Nullable TelegramBotConfiguration bot, @NotNull Update input) {
        SendMessageUtils.compose(spaceParser, input, "Hello World")
    }
}
// end::class[]
