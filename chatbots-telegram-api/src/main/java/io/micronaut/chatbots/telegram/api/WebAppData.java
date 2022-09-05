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

import javax.validation.constraints.NotBlank;

/**
 * Describes data sent from a Web App to the bot.
 * <a href="https://core.telegram.org/bots/api#webappdata">WebAppData</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class WebAppData {
    /**
     * The data. Be aware that a bad client can send arbitrary data in this field.
     */
    @NonNull
    @NotBlank
    private String data;

    /**
     * Text of the web_app keyboard button from which the Web App was opened. Be aware that a bad client can send arbitrary data in this field.
     */
    @JsonProperty("button_text")
    @NonNull
    @NotBlank
    private String buttonText;

    /**
     *
     * @return The data. Be aware that a bad client can send arbitrary data in this field.
     */
    @NonNull
    public String getData() {
        return data;
    }

    /**
     *
     * @param data The data. Be aware that a bad client can send arbitrary data in this field.
     */
    public void setData(@NonNull String data) {
        this.data = data;
    }

    /**
     *
     * @return Text of the web_app keyboard button from which the Web App was opened. Be aware that a bad client can send arbitrary data in this field.
     */
    @NonNull
    public String getButtonText() {
        return buttonText;
    }

    /**
     *
     * @param buttonText Text of the web_app keyboard button from which the Web App was opened. Be aware that a bad client can send arbitrary data in this field.
     */
    public void setButtonText(@NonNull String buttonText) {
        this.buttonText = buttonText;
    }
}
