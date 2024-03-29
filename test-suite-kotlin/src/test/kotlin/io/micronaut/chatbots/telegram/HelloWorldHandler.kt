package io.micronaut.chatbots.telegram

import io.micronaut.chatbots.core.SpaceParser
import io.micronaut.chatbots.telegram.api.Chat
import io.micronaut.chatbots.telegram.api.Update
import io.micronaut.chatbots.telegram.api.send.SendMessage
import io.micronaut.chatbots.telegram.core.SendMessageUtils
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration
import io.micronaut.chatbots.telegram.core.TelegramHandler
import io.micronaut.context.annotation.Requires
import jakarta.inject.Singleton
import java.util.*

@Requires(property = "spec.name", value = "telegram")
// tag::class[]
@Singleton
class HelloWorldHandler(private val spaceParser: SpaceParser<Update, Chat>) : TelegramHandler<SendMessage> {

    override fun canHandle(bot: TelegramBotConfiguration?, input: Update): Boolean = input.message.text.contains("hello")

    override fun handle(bot: TelegramBotConfiguration?, input: Update): Optional<SendMessage> =
        SendMessageUtils.compose(spaceParser, input, "Hello World")
}
// end::class[]
