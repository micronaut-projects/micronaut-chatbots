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

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This object represents a custom keyboard with reply options (see Introduction to bots for details and examples).
 * @see <a href="https://core.telegram.org/bots/api#replykeyboardmarkup">ReplyKeyboardMarkup</a>
 */
@Serdeable
public class ReplyKeyboardMarkup {

    /**
     * Array of button rows, each represented by an Array of KeyboardButton objects.
     */
    @NonNull
    @NotNull
    private List<KeyboardButton> keyboard;

    /**
     * Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to false, in which case the custom keyboard is always of the same height as the app's standard keyboard.
     */
    @Nullable
    @JsonProperty("resize_keyboard")
    private Boolean resizeKeyboard;

    /**
     * Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat – the user can press a special button in the input field to see the custom keyboard again. Defaults to false.
     */
    @Nullable
    @JsonProperty("one_time_keyboard")
    private Boolean oneTimeKeyboard;

    /**
     * The placeholder to be shown in the input field when the keyboard is active; 1-64 characters.
     */
    @JsonProperty("input_field_placeholder")
    @Nullable
    private String inputFieldPlaceholder;

    /**
     * Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     * Example: A user requests to change the bot‘s language, bot replies to the request with a keyboard to select the new language. Other users in the group don’t see the keyboard.
     */
    @Nullable
    private Boolean selective;

    /**
     *
     * @return Array of button rows, each represented by an Array of KeyboardButton objects.
     */
    @NonNull
    public List<KeyboardButton> getKeyboard() {
        return keyboard;
    }

    /**
     *
     * @param keyboard Array of button rows, each represented by an Array of KeyboardButton objects.
     */
    public void setKeyboard(@NonNull List<KeyboardButton> keyboard) {
        this.keyboard = keyboard;
    }

    /**
     *
     * @return Requests clients to resize the keyboard vertically for optimal fit
     */
    @Nullable
    public Boolean getResizeKeyboard() {
        return resizeKeyboard;
    }

    /**
     *
     * @param resizeKeyboard Requests clients to resize the keyboard vertically for optimal fit
     */
    public void setResizeKeyboard(@Nullable Boolean resizeKeyboard) {
        this.resizeKeyboard = resizeKeyboard;
    }

    /**
     *
     * @return Requests clients to hide the keyboard as soon as it's been used.
     */
    @Nullable
    public Boolean getOneTimeKeyboard() {
        return oneTimeKeyboard;
    }

    /**
     *
     * @param oneTimeKeyboard Requests clients to hide the keyboard as soon as it's been used.
     */
    public void setOneTimeKeyboard(@Nullable Boolean oneTimeKeyboard) {
        this.oneTimeKeyboard = oneTimeKeyboard;
    }

    /**
     *
     * @return Use this parameter if you want to show the keyboard to specific users only.
     */
    @Nullable
    public Boolean getSelective() {
        return selective;
    }

    /**
     *
     * @param selective Use this parameter if you want to show the keyboard to specific users only.
     */
    public void setSelective(@Nullable Boolean selective) {
        this.selective = selective;
    }

    /**
     *
     * @return The placeholder to be shown in the input field when the keyboard is active; 1-64 characters.
     */
    @Nullable
    public String getInputFieldPlaceholder() {
        return inputFieldPlaceholder;
    }

    /**
     *
     * @param inputFieldPlaceholder The placeholder to be shown in the input field when the keyboard is active; 1-64 characters.
     */
    public void setInputFieldPlaceholder(@Nullable String inputFieldPlaceholder) {
        this.inputFieldPlaceholder = inputFieldPlaceholder;
    }

    @Override
    public String toString() {
        return "ReplyKeyboardMarkup{" +
                "keyboard=" + (keyboard != null ? keyboard.stream().map(KeyboardButton::toString).collect(Collectors.joining(",")) : "") +
                ", resizeKeyboard=" + resizeKeyboard +
                ", oneTimeKeyboard=" + oneTimeKeyboard +
                ", selective=" + selective +
                '}';
    }
}
