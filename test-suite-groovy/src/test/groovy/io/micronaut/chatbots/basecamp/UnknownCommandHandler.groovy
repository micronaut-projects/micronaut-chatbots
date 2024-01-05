package io.micronaut.chatbots.basecamp

import io.micronaut.chatbots.basecamp.api.Query
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration
import io.micronaut.chatbots.basecamp.core.BasecampHandler
import io.micronaut.context.annotation.Requires
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.annotation.Nullable
import io.micronaut.core.order.Ordered
import jakarta.inject.Singleton
import jakarta.validation.constraints.NotNull

import java.util.Optional

@Requires(property = "spec.name", value = "basecamp")
// tag::class[]
@Singleton
class UnknownCommandHandler implements BasecampHandler {

    @Override
    boolean canHandle(@Nullable BasecampBotConfiguration bot, @NonNull @NotNull Query input) {
        true // <1>
    }

    @Override
    @NonNull Optional<String> handle(@Nullable BasecampBotConfiguration bot, @NonNull @NotNull Query input) {
        Optional.of("I don't know how to handle your query: $input.command".toString())
    }

    @Override
    public int getOrder() {
        Ordered.LOWEST_PRECEDENCE // <2>
    }
}
// end::class[]
