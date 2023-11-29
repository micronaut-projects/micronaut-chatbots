package io.micronaut.chatbots.basecamp

import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.basecamp.core.BasecampHandler
import io.micronaut.context.annotation.Requires
import jakarta.inject.Singleton
import java.util.Optional

@Requires(property = "spec.name", value = "basecamp")
// tag::class[]
@Singleton
class HelloWorldHandler : BasecampHandler {

    override fun canHandle(bot: BasecampBotConfiguration, input: Query): Boolean = true
    override fun handle(bot: BasecampBotConfiguration, input: Query): Optional<String> = Optional.of("Hello World")
}
// end::class[]

