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
package io.micronaut.chatbots.telegram.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotNull;

/**
 * This object represents a service message about a change in auto-delete timer settings.
 * <a href="https://core.telegram.org/bots/api#messageautodeletetimerchanged">MessageAutoDeleteTimerChanged</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class MessageAutoDeleteTimerChanged {
    /**
     * New auto-delete time for messages in the chat; in seconds.
     */
    @JsonProperty("message_auto_delete_time")
    @NonNull
    @NotNull
    private Integer messageAutoDeleteTime;

    /**
     *
     * @return New auto-delete time for messages in the chat; in seconds
     */
    @NonNull
    public Integer getMessageAutoDeleteTime() {
        return messageAutoDeleteTime;
    }

    /**
     *
     * @param messageAutoDeleteTime New auto-delete time for messages in the chat; in seconds
     */
    public void setMessageAutoDeleteTime(@NonNull Integer messageAutoDeleteTime) {
        this.messageAutoDeleteTime = messageAutoDeleteTime;
    }
}
