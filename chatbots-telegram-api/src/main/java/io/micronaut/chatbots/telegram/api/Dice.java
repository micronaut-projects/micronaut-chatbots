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

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * This object represents an animated emoji that displays a random value.
 * <a href="https://core.telegram.org/bots/api#dice">Dice</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class Dice {

    /**
     * Emoji on which the dice throw animation is based.
     */
    @NonNull
    @NotBlank
    private String emoji;

    /**
     * Value of the dice, 1-6 for “🎲”, “🎯” and “🎳” base emoji, 1-5 for “🏀” and “⚽” base emoji, 1-64 for “🎰” base emoji.
     */
    @NonNull
    @NotNull
    private Integer value;

    /**
     *
     * @return Emoji on which the dice throw animation is based.
     */
    @NonNull
    public String getEmoji() {
        return emoji;
    }

    /**
     *
     * @param emoji Emoji on which the dice throw animation is based.
     */
    public void setEmoji(@NonNull String emoji) {
        this.emoji = emoji;
    }

    /**
     *
     * @return Value of the dice, 1-6 for “🎲”, “🎯” and “🎳” base emoji, 1-5 for “🏀” and “⚽” base emoji, 1-64 for “🎰” base emoji.
     */
    @NonNull
    public Integer getValue() {
        return value;
    }

    /**
     *
     * @param value Value of the dice, 1-6 for “🎲”, “🎯” and “🎳” base emoji, 1-5 for “🏀” and “⚽” base emoji, 1-64 for “🎰” base emoji.
     */
    public void setValue(@NonNull Integer value) {
        this.value = value;
    }
}
