package io.micronaut.chatbots.basecamp

import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.basecamp.core.BasecampHandler
import io.micronaut.context.annotation.Requires
import io.micronaut.core.order.Ordered
import jakarta.inject.Singleton
import java.util.Optional

@Requires(property = "spec.name", value = "basecamp")
// tag::class[]
@Singleton
class UnknownCommandHandler : BasecampHandler {

    override fun canHandle(bot: BasecampBotConfiguration?, input: Query) = true // <1>

    override fun handle(bot: BasecampBotConfiguration?, input: Query) =
        Optional.of("I don't know how to handle your query: ${input.command}")

    override fun getOrder() = Ordered.LOWEST_PRECEDENCE // <2>
} // end::class[]
