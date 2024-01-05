package io.micronaut.chatbots.basecamp;

import io.micronaut.chatbots.basecamp.api.Query;
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration;
import io.micronaut.chatbots.basecamp.core.BasecampHandler;
import io.micronaut.chatbots.core.CommandResponse;
import io.micronaut.chatbots.core.TextResourceLoader;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import jakarta.inject.Singleton;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

@Requires(property = "spec.name", value = "basecamp")
// tag::class[]
@Singleton
class AboutCommandHandler implements BasecampHandler {

    public static final String ABOUT = "about";
    private final TextResourceLoader textResourceLoader;

    AboutCommandHandler(TextResourceLoader textResourceLoader) {
        this.textResourceLoader = textResourceLoader;
    }

    @Override
    public boolean canHandle(@Nullable BasecampBotConfiguration bot, @NonNull @NotNull Query input) {
        return input.getCommand().equalsIgnoreCase("/" + ABOUT);
    }

    @Override
    public @NonNull Optional<String> handle(@Nullable BasecampBotConfiguration bot, @NonNull @NotNull Query input) {
        return textResourceLoader
            .composeCommandResponse(ABOUT)
            .map(CommandResponse::text);
    }
}
// end::class[]
