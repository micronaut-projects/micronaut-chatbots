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

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents an incoming callback query from a callback button in an inline keyboard. If the button that originated the query was attached to a message sent by the bot, the field message will be present. If the button was attached to a message sent via the bot (in inline mode), the field inline_message_id will be present. Exactly one of the fields data or game_short_name will be present..
 * @see <a href="https://core.telegram.org/bots/api#callbackquery">Callback Query</a>
 */
@Serdeable
public class CallbackQuery {

    /**
     * Unique identifier for this query.
     */
    @NonNull
    @NotBlank
    private String id;

    /**
     * Sender.
     */
    @NonNull
    @NotNull
    @Valid
    private User from;

    /**
     * Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old.
     */
    @Nullable
    private Message message;

    /**
     * Identifier of the message sent via the bot in inline mode, that originated the query.
     */
    @Nullable
    @JsonProperty("inline_message_id")
    private String inlineMessageId;

    /**
     * Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in games.
     */
    @NonNull
    @NotBlank
    @JsonProperty("chat_instance")
    private String chatInstance;

    /**
     * Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
     */
    @Nullable
    private String data;

    /**
     * Short name of a Game to be returned, serves as the unique identifier for the game.
     */
    @Nullable
    @JsonProperty("game_short_name")
    private String gameShortName;

    public CallbackQuery() {
    }

    /**
     *
     * @return Unique identifier for this query.
     */
    @NonNull
    public String getId() {
        return id;
    }

    /**
     *
     * @param id Unique identifier for this query.
     */
    public void setId(@NonNull String id) {
        this.id = id;
    }

    /**
     *
     * @return Sender.
     */
    @NonNull
    public User getFrom() {
        return from;
    }

    /**
     *
     * @param from Sender.
     */
    public void setFrom(@NonNull User from) {
        this.from = from;
    }

    /**
     *
     * @return Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old.
     */
    @Nullable
    public Message getMessage() {
        return message;
    }

    /**
     *
     * @param message Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old.
     */
    public void setMessage(@Nullable Message message) {
        this.message = message;
    }

    /**
     *
     * @return Identifier of the message sent via the bot in inline mode, that originated the query.
     */
    @Nullable
    public String getInlineMessageId() {
        return inlineMessageId;
    }

    /**
     *
     * @param inlineMessageId Identifier of the message sent via the bot in inline mode, that originated the query.
     */
    public void setInlineMessageId(@Nullable String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
    }

    /**
     *
     * @return Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in games.
     */
    @NonNull
    public String getChatInstance() {
        return chatInstance;
    }

    /**
     *
     * @param chatInstance Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in games.
     */
    public void setChatInstance(@NonNull String chatInstance) {
        this.chatInstance = chatInstance;
    }

    /**
     *
     * @return Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
     */
    @Nullable
    public String getData() {
        return data;
    }

    /**
     *
     * @param data Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
     */
    public void setData(@Nullable String data) {
        this.data = data;
    }

    /**
     *
     * @return Short name of a Game to be returned, serves as the unique identifier for the game.
     */
    @Nullable
    public String getGameShortName() {
        return gameShortName;
    }

    /**
     *
     * @param gameShortName Short name of a Game to be returned, serves as the unique identifier for the game.
     */
    public void setGameShortName(@Nullable String gameShortName) {
        this.gameShortName = gameShortName;
    }

    @Override
    public String toString() {
        return "CallbackQuery{" +
                "id='" + id + '\'' +
                ", from=" + (from != null ? from.toString() : "") +
                ", message=" + (message != null ? message.toString() : "") +
                ", inlineMessageId='" + inlineMessageId + '\'' +
                ", chatInstance='" + chatInstance + '\'' +
                ", data='" + data + '\'' +
                ", gameShortName='" + gameShortName + '\'' +
                '}';
    }
}
