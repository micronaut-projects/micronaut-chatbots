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
package io.micronaut.chatbots.basecamp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;
import javax.validation.constraints.NotBlank;

/**
 * Message directed to a Basecamp 3 interactive Chatbot.
 * <a href="https://github.com/basecamp/bc3-api/blob/master/sections/chatbots.md#chatbots">Chatbots</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class Query {

    @NonNull
    @NotBlank
    private String command;

    @NonNull
    @NotBlank
    @JsonProperty("callback_url")
    private String callbackUrl;

    /**
     *
     * @return Callback URL
     */
    @NonNull
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     *
     * @param callbackUrl Callback URL
     */
    public void setCallbackUrl(@NonNull String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    /**
     *
     * @return Command directed to the Bot.
     */
    @NonNull
    public String getCommand() {
        return command;
    }

    /**
     *
     * @param command Command directed to the Bot.
     */
    public void setCommand(@NonNull String command) {
        this.command = command;
    }
}
