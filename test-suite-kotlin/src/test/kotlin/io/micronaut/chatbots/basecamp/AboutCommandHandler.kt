package io.micronaut.chatbots.basecamp

import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.basecamp.core.BasecampHandler
import io.micronaut.chatbots.core.CommandResponse
import io.micronaut.chatbots.core.TextResourceLoader
import io.micronaut.context.annotation.Requires
import jakarta.inject.Singleton

@Requires(property = "spec.name", value = "basecamp")
// tag::class[]
@Singleton
class AboutCommandHandler(
    private val textResourceLoader: TextResourceLoader
) : BasecampHandler {

    override fun canHandle(bot: BasecampBotConfiguration?, input: Query) =
        input.command.equals("/$ABOUT", ignoreCase = true)

    override fun handle(bot: BasecampBotConfiguration?, input: Query) =
        textResourceLoader.composeCommandResponse(ABOUT).map(CommandResponse::text)

    companion object {
        const val ABOUT: String = "about"
    }
}
// end::class[]
