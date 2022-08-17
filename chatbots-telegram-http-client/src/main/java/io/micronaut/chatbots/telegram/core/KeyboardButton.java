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
package io.micronaut.chatbots.telegram.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * This object represents one button of the reply keyboard. For simple text buttons String can be used instead of this object to specify text of the button. Optional fields request_contact, request_location, and request_poll are mutually exclusive.
 * @see <a href="https://core.telegram.org/bots/api#keyboardbutton">Keyboard Button</a>
 */
@Serdeable
public class KeyboardButton {

    /**
     * Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
     */
    @NotBlank
    @NonNull
    private String text;

    /**
     * If True, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only
     */
    @Nullable
    @JsonProperty("request_contact")
    private Boolean requestContact;

    /**
     * If True, the user's current location will be sent when the button is pressed. Available in private chats only.
     */
    @Nullable
    @JsonProperty("request_location")
    private Boolean requestLocation;

    /**
     * If specified, the user will be asked to create a poll and send it to the bot when the button is pressed. Available in private chats only
     */
    @Nullable
    @JsonProperty("request_poll")
    private KeyboardButtonPollType requestPoll;

    /**
     * If specified, the described Web App will be launched when the button is pressed. The Web App will be able to send a “web_app_data” service message. Available in private chats only.
     */
    @JsonProperty("web_app")
    @Nullable
    @Valid
    private WebAppInfo webApp;

    public KeyboardButton() {
    }

    /**
     *
     * @return Text of the button.
     */
    @NonNull
    public String getText() {
        return text;
    }

    /**
     *
     * @param text Text of the button.
     */
    public void setText(@NonNull String text) {
        this.text = text;
    }

    /**
     *
     * @return If True, the user's phone number will be sent as a contact when the button is pressed.
     */
    @Nullable
    public Boolean getRequestContact() {
        return requestContact;
    }

    /**
     *
     * @param requestContact If True, the user's phone number will be sent as a contact when the button is pressed.
     */
    public void setRequestContact(@Nullable Boolean requestContact) {
        this.requestContact = requestContact;
    }

    /**
     *
     * @return If True, the user's current location will be sent when the button is pressed.
     */
    @Nullable
    public Boolean getRequestLocation() {
        return requestLocation;
    }

    /**
     *
     * @param requestLocation If True, the user's current location will be sent when the button is pressed.
     */
    public void setRequestLocation(@Nullable Boolean requestLocation) {
        this.requestLocation = requestLocation;
    }

    /**
     *
     * @return If specified, the user will be asked to create a poll and send it to the bot when the button is pressed.
     */
    @Nullable
    public KeyboardButtonPollType getRequestPoll() {
        return requestPoll;
    }

    /**
     *
     * @param requestPoll If specified, the user will be asked to create a poll and send it to the bot when the button is pressed.
     */
    public void setRequestPoll(@Nullable KeyboardButtonPollType requestPoll) {
        this.requestPoll = requestPoll;
    }

    /**
     *
     * @return If specified, the described Web App will be launched when the button is pressed. The Web App will be able to send a “web_app_data” service message. Available in private chats only.
     */
    @Nullable
    public WebAppInfo getWebApp() {
        return webApp;
    }

    /**
     *
     * @param webApp If specified, the described Web App will be launched when the button is pressed. The Web App will be able to send a “web_app_data” service message. Available in private chats only.
     */
    public void setWebApp(@Nullable WebAppInfo webApp) {
        this.webApp = webApp;
    }

    @Override
    public String toString() {
        return "KeyboardButton{" +
                "text='" + text + '\'' +
                ", requestContact=" + requestContact +
                ", requestLocation=" + requestLocation +
                ", requestPoll=" + (requestPoll != null ? requestPoll.toString() : "") +
                '}';
    }
}
