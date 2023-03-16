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
package io.micronaut.chatbots.google.api;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import jakarta.validation.constraints.NotBlank;

/**
 * A slash command in Google Chat.
 * @see <a href="https://developers.google.com/chat/api/reference/rest/v1/spaces.messages#SlashCommand">SlashCommand</a>
 * @see <a href="https://developers.google.com/chat/how-tos/slash-commands">SlashCommand</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class SlashCommand {
    /**
     * The id of the slash command invoked.
     */
    @NonNull
    @NotBlank
    private String commandId;

    /**
     *
     * @return The id of the slash command invoked.
     */
    @NonNull
    public String getCommandId() {
        return commandId;
    }

    /**
     *
     * @param commandId The id of the slash command invoked.
     */
    public void setCommandId(@NonNull String commandId) {
        this.commandId = commandId;
    }
}
