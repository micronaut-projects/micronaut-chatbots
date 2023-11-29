package io.micronaut.chatbots.basecamp;

import io.micronaut.chatbots.basecamp.api.Query;
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration;
import io.micronaut.chatbots.basecamp.core.BasecampHandler;
import io.micronaut.context.annotation.Requires;
import jakarta.inject.Singleton;
import io.micronaut.core.annotation.NonNull;
import jakarta.validation.constraints.NotNull;
import java.util.Optional;

@Requires(property = "spec.name", value = "basecamp")
// tag::class[]
@Singleton
class HelloWorldHandler implements BasecampHandler {

    @Override
    public boolean canHandle(BasecampBotConfiguration bot, @NonNull @NotNull Query input) {
        return true;
    }

    @NonNull
    @Override
    public Optional<String> handle(BasecampBotConfiguration bot, @NonNull @NotNull Query input) {
        return Optional.of("Hello World");
    }
}
// end::class[]
