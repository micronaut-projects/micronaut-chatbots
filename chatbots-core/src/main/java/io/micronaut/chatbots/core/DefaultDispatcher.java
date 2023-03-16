/*
 * Copyright 2017-2022 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.chatbots.core;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import jakarta.inject.Singleton;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Iterates through every {@link Handler} in odered and dispatch the message to the first which can handle the request.
 * @param <B> The Bot configuration
 * @param <I> input type.
 * @param <O> output type.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Singleton
public class DefaultDispatcher<B extends BotConfiguration, I, O> implements Dispatcher<B, I, O> {

    private final List<Handler<B, I, O>> handlers;

    public DefaultDispatcher(List<Handler<B, I, O>> handlers) {
        this.handlers = handlers;
    }

    @Override
    @NonNull
    public Optional<O> dispatch(@Nullable B bot,
                                @NonNull @NotNull I input) {
        return handlers.stream()
            .filter(handler -> handler.canHandle(bot, input))
            .findFirst()
            .flatMap(bioHandler -> bioHandler.handle(bot, input));
    }
}
