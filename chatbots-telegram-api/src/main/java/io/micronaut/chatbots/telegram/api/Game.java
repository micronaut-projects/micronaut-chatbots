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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This object represents a game. Use BotFather to create and edit games, their short names will act as unique identifiers.
 * @see <a href="https://core.telegram.org/bots/api#game">Game</a>
 */
@Serdeable
public class Game {

    /**
     * Title of the game.
     */
    @NonNull
    @NotBlank
    private String title;

    /**
     * Description of the game.
     */
    @NonNull
    @NotBlank
    private String description;

    /**
     * Photo that will be displayed in the game message in chats.
     */
    @NonNull
    @NotNull
    private List<PhotoSize> photo;

    /**
     * Brief description of the game or high scores included in the game message. Can be automatically edited to include current high scores for the game when the bot calls setGameScore, or manually edited using editMessageText. 0-4096 characters.
     */
    @Nullable
    private String text;

    /**
     * Special entities that appear in text, such as usernames, URLs, bot commands, etc.
     */
    @Nullable
    @JsonProperty("text_entities")
    private List<MessageEntity> textEntities;

    /**
     * Animation that will be displayed in the game message in chats. Upload via BotFather.
     */
    @Nullable
    private Animation animation;

    public Game() {
    }

    /**
     *
     * @return Title of the game.
     */
    @NonNull
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title Title of the game.
     */
    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    /**
     *
     * @return Description of the game.
     */
    @NonNull
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description Description of the game.
     */
    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    /**
     *
     * @return Photo that will be displayed in the game message in chats.
     */
    @NonNull
    public List<PhotoSize> getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo Photo that will be displayed in the game message in chats.
     */
    public void setPhoto(@NonNull List<PhotoSize> photo) {
        this.photo = photo;
    }

    /**
     *
     * @return Brief description of the game or high scores included in the game message.
     */
    @Nullable
    public String getText() {
        return text;
    }

    /**
     *
     * @param text Brief description of the game or high scores included in the game message.
     */
    public void setText(@Nullable String text) {
        this.text = text;
    }

    /**
     *
     * @return Special entities that appear in text, such as usernames, URLs, bot commands, etc.
     */
    @Nullable
    public List<MessageEntity> getTextEntities() {
        return textEntities;
    }

    /**
     *
     * @param textEntities Special entities that appear in text, such as usernames, URLs, bot commands, etc.
     */
    public void setTextEntities(@Nullable List<MessageEntity> textEntities) {
        this.textEntities = textEntities;
    }

    /**
     *
     * @return Animation that will be displayed in the game message in chats. Upload via BotFather.
     */
    @Nullable
    public Animation getAnimation() {
        return animation;
    }

    /**
     *
     * @param animation Animation that will be displayed in the game message in chats. Upload via BotFather.
     */
    public void setAnimation(@Nullable Animation animation) {
        this.animation = animation;
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", photo=" + (photo != null ? photo.stream().map(PhotoSize::toString).collect(Collectors.joining(",")) : "") +
                ", text='" + text +
                ", textEntities=" + (textEntities != null ? textEntities.stream().map(MessageEntity::toString).collect(Collectors.joining(",")) : "") +
                ", animation=" + animation +
                '}';
    }
}
