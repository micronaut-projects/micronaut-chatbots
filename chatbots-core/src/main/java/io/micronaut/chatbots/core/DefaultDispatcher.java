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
import jakarta.inject.Singleton;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Iterates through every {@link Handler} in odered and dispatch the message to the first which can handle the request.
 * @param <BOT> The Bot configuration
 * @param <INPUT> input type.
 * @param <OUTPUT> output type.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Singleton
public class DefaultDispatcher<BOT extends BotConfiguration, INPUT, OUTPUT> implements Dispatcher<BOT, INPUT, OUTPUT> {

    private final List<Handler<BOT, INPUT, OUTPUT>> handlers;

    public DefaultDispatcher(List<Handler<BOT, INPUT, OUTPUT>> handlers) {
        this.handlers = handlers;
    }

    @Override
    @NonNull
    public Optional<OUTPUT> dispatch(@NonNull @NotNull @Valid BOT bot,
                                     @NonNull @NotNull @Valid INPUT input) {
        Optional<Handler<BOT, INPUT, OUTPUT>> handlerOptional = handlers.stream()
            .filter(handler -> handler.canHandle(bot, input))
            .findFirst();
        return handlerOptional.isPresent() ?
            handlerOptional.get().handle(bot, input) :
            Optional.empty();
    }
}
