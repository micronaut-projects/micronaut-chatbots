package io.micronaut.chatbots.basecamp

import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.basecamp.core.BasecampHandler
import io.micronaut.context.annotation.Requires
import jakarta.inject.Singleton

import jakarta.validation.constraints.NotNull

@Singleton
@Requires(property = "spec.name", value = "basecamp")
class HelloWorldHandler implements BasecampHandler {

    @Override
    boolean canHandle(BasecampBotConfiguration bot, @NotNull Query input) {
        true
    }

    @Override
    Optional<String> handle(BasecampBotConfiguration bot, @NotNull Query input) {
        Optional.of("Hello World")
    }
}

