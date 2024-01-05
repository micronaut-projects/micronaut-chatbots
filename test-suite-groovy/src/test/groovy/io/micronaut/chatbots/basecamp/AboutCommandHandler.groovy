package io.micronaut.chatbots.basecamp

import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.basecamp.core.BasecampHandler
import io.micronaut.chatbots.core.CommandResponse
import io.micronaut.chatbots.core.TextResourceLoader
import io.micronaut.context.annotation.Requires
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.annotation.Nullable
import jakarta.inject.Singleton
import jakarta.validation.constraints.NotNull

@Requires(property = "spec.name", value = "basecamp")
// tag::class[]
@Singleton
class AboutCommandHandler implements BasecampHandler {

    static final String ABOUT = "about"
    private final TextResourceLoader textResourceLoader

    AboutCommandHandler(TextResourceLoader textResourceLoader) {
        this.textResourceLoader = textResourceLoader
    }

    @Override
    boolean canHandle(@Nullable BasecampBotConfiguration bot, @NonNull @NotNull Query input) {
        input.command.equalsIgnoreCase("/$ABOUT")
    }

    @Override
    @NonNull Optional<String> handle(@Nullable BasecampBotConfiguration bot, @NonNull @NotNull Query input) {
        textResourceLoader
            .composeCommandResponse(ABOUT)
            .map(CommandResponse::text)
    }
}
// end::class[]
