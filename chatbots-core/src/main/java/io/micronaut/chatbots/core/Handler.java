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
import io.micronaut.core.order.Ordered;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Request handlers are responsible for handling one or more types of incoming requests.
 * @param <B> The Bot configuration
 * @param <I> input type.
 * @param <O> output type.
 * @author Sergio del Amo
 * @since 1.0.0
 */
public interface Handler<B extends BotConfiguration, I, O> extends Ordered {
    /**
     * Returns true if the handler can dispatch the current request.
     * @param bot bot being asked to handle this command
     * @param input input to the request handler
     * @return true if the handler is capable of handling the current request
     */
    boolean canHandle(@Nullable B bot,
                      @NonNull @NotNull I input);

    /**
     * Handles the request.
     * @param bot bot being asked to handle this command
     * @param input input to the request handler
     * @return output from the handler. Empty if you want to respond asynchronously.
     */
    @NonNull
    Optional<O> handle(@Nullable B bot,
                       @NonNull @NotNull I input);
}
