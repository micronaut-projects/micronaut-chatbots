package io.micronaut.chatbots.docs.basecamp

import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.basecamp.core.BasecampHandler
import io.micronaut.context.annotation.Requires
import jakarta.inject.Singleton

import jakarta.validation.constraints.NotNull

@Requires(property = "spec.name", value = "basecamp")
// tag::class[]
@Singleton
class HelloWorldHandler implements BasecampHandler {

    @Override
    boolean canHandle(BasecampBotConfiguration bot, @NotNull Query input) {
        input.command.contains("hello")
    }

    @Override
    Optional<String> handle(BasecampBotConfiguration bot, @NotNull Query input) {
        Optional.of("Hello World")
    }
}
// end::class[]
