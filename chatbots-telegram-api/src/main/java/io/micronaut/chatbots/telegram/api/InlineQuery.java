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
import javax.validation.constraints.Pattern;

/**
 * This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results.
 * @see <a href="https://core.telegram.org/bots/api#inlinequery">InlineQuery</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class InlineQuery {

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
     * Text of the query (up to 512 characters).
     */
    @NonNull
    @NotBlank
    private String query;

    /**
     * Offset of the results to be returned, can be controlled by the bot.
     */
    @NonNull
    @NotBlank
    private String offset;

    /**
     * Type of the chat from which the inline query was sent. Can be either “sender” for a private chat with the inline query sender, “private”, “group”, “supergroup”, or “channel”. The chat type should be always known for requests sent from official clients and most third-party clients, unless the request was sent from a secret chat.
     */
    @Nullable
    @Pattern(regexp = "sender|private|group|supergroup|channel")
    @JsonProperty("chat_type")
    private String chatType;

    /**
     * Sender location, only for bots that request user location.
     */
    @Nullable
    @Valid
    private Location location;

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
     * @return Sender location, only for bots that request user location.
     */
    @Nullable
    public Location getLocation() {
        return location;
    }

    /**
     *
     * @param location Sender location, only for bots that request user location.
     */
    public void setLocation(@Nullable Location location) {
        this.location = location;
    }

    /**
     *
     * @return Text of the query (up to 512 characters).
     */
    @NonNull
    public String getQuery() {
        return query;
    }

    /**
     *
     * @param query Text of the query (up to 512 characters).
     */
    public void setQuery(@NonNull String query) {
        this.query = query;
    }

    /**
     *
     * @return Offset of the results to be returned, can be controlled by the bot.
     */
    @NonNull
    public String getOffset() {
        return offset;
    }

    /**
     *
     * @param offset Offset of the results to be returned, can be controlled by the bot.
     */
    public void setOffset(@NonNull String offset) {
        this.offset = offset;
    }

    /**
     *
     * @return Type of the chat from which the inline query was sent
     */
    @Nullable
    public String getChatType() {
        return chatType;
    }

    /**
     *
     * @param chatType Type of the chat from which the inline query was sent
     */
    public void setChatType(@Nullable String chatType) {
        this.chatType = chatType;
    }

    @Override
    public String toString() {
        return "InlineQuery{" +
                "id='" + id + '\'' +
                ", from=" + (from != null ? from.toString() : "") +
                ", location=" + (location != null ? location.toString() : "") +
                ", query='" + query + '\'' +
                ", offset='" + offset + '\'' +
                '}';
    }
}
