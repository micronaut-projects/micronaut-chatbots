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

import io.micronaut.context.annotation.DefaultImplementation;
import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

/**
 * Composes a static command response for a given command.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@DefaultImplementation(DefaultTextResourceLoader.class)
@FunctionalInterface
public interface TextResourceLoader {

    /**
     * Composes a static command response for a given command.
     * @param command Command
     * @return static command response.
     */
    @NonNull
    Optional<CommandResponse> composeCommandResponse(@NonNull @NotBlank String command);
}
