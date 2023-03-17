/*
 * Copyright 2017-2021 original authors
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
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import jakarta.validation.constraints.NotNull;

/**
 * Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot‘s message and tapped ’Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice privacy mode.
 * @see <a href="https://core.telegram.org/bots/api#forcereply">Force Reply</a>
 */
@Serdeable
public class ForceReply {

    /**
     * Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'.
     */
    @NonNull
    @NotNull
    @JsonProperty("force_reply")
    private Boolean forceReply = Boolean.TRUE;

    /**
     * The placeholder to be shown in the input field when the reply is active; 1-64 characters.
     */
    @JsonProperty("input_field_placeholder")
    @Nullable
    private String inputFieldPlaceholder;

    /**
     * Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     */
    @Nullable
    private Boolean selective;

    /**
     *
     * @return Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'.
     */
    @NonNull
    public Boolean getForceReply() {
        return forceReply;
    }

    /**
     *
     * @param forceReply Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'.
     */
    public void setForceReply(@NonNull Boolean forceReply) {
        this.forceReply = forceReply;
    }

    /**
     *
     * @return Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     */
    @Nullable
    public Boolean getSelective() {
        return selective;
    }

    /**
     *
     * @param selective Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     */
    public void setSelective(@Nullable Boolean selective) {
        this.selective = selective;
    }

    /**
     *
     * @return The placeholder to be shown in the input field when the reply is active; 1-64 characters
     */
    @Nullable
    public String getInputFieldPlaceholder() {
        return inputFieldPlaceholder;
    }

    /**
     *
     * @param inputFieldPlaceholder The placeholder to be shown in the input field when the reply is active; 1-64 characters
     */
    public void setInputFieldPlaceholder(@Nullable String inputFieldPlaceholder) {
        this.inputFieldPlaceholder = inputFieldPlaceholder;
    }

    @Override
    public String toString() {
        return "ForceReply{" +
                "forceReply=" + forceReply +
                ", selective=" + selective +
                '}';
    }
}
