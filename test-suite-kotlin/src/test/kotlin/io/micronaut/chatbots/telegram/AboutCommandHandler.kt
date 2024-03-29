package io.micronaut.chatbots.telegram

import io.micronaut.chatbots.core.SpaceParser
import io.micronaut.chatbots.core.TextResourceLoader
import io.micronaut.chatbots.telegram.api.Chat
import io.micronaut.chatbots.telegram.api.Update
import io.micronaut.chatbots.telegram.core.CommandHandler
import io.micronaut.chatbots.telegram.core.TelegramSlashCommandParser
import io.micronaut.context.annotation.Requires
import jakarta.inject.Singleton

@Requires(property = "spec.name", value = "telegram")
// tag::class[]
@Singleton
class AboutCommandHandler(
    slashCommandParser: TelegramSlashCommandParser,
    textResourceLoader: TextResourceLoader,
    spaceParser: SpaceParser<Update, Chat>
) : CommandHandler(slashCommandParser, textResourceLoader, spaceParser) {

    override fun getCommand() = COMMAND_ABOUT

    companion object {
        private const val COMMAND_ABOUT = "/about"
    }
}
// end::class[]
