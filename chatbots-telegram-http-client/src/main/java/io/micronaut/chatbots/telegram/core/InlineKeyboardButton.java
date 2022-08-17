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
package io.micronaut.chatbots.telegram.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * This object represents one button of an inline keyboard. You must use exactly one of the optional fields.
 * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardbutton">InlineKeyboardButton</a>
 */
@Serdeable
public class InlineKeyboardButton {

    /**
     * Label text on the button.
     */
    @NonNull
    @NotBlank
    private String text;

    /**
     * HTTP or tg:// url to be opened when button is pressed.
     */
    @Nullable
    private String url;

    /**
     * Data to be sent in a callback query to the bot when button is pressed, 1-64 bytes.
     */
    @Nullable
    @JsonProperty("callback_data")
    private String callbackData;

    /**
     * Description of the Web App that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method answerWebAppQuery. Available only in private chats between a user and the bot.
     */
    @JsonProperty("web_app")
    @Nullable
    @Valid
    private WebAppInfo webApp;

    /**
     *  An HTTP URL used to automatically authorize the user. Can be used as a replacement for the Telegram Login Widget.
     */
    @Nullable
    @JsonProperty("login_url")
    private LoginUrl loginUrl;

    /**
     * If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot‘s username and the specified inline query in the input field. Can be empty, in which case just the bot’s username will be inserted.
     * Note: This offers an easy way for users to start using your bot in inline mode when they are currently in a private chat with it. Especially useful when combined with switch_pm… actions – in this case the user will be automatically returned to the chat they switched from, skipping the chat selection screen.
     */
    @Nullable
    @JsonProperty("switch_inline_query")
    private String switchInlineQuery;

    /**
     * If set, pressing the button will insert the bot‘s username and the specified inline query in the current chat's input field. Can be empty, in which case only the bot’s username will be inserted.
     * This offers a quick way for the user to open your bot in inline mode in the same chat – good for selecting something from multiple options.
     */
    @Nullable
    @JsonProperty("switch_inline_query_current_chat")
    private String switchInlineQueryCurrentChat;

    /**
     * Description of the game that will be launched when the user presses the button.
     *
     * NOTE: This type of button must always be the first button in the first row.
     *
     */
    @Nullable
    @JsonProperty("callback_game")
    private CallbackGame callbackGame;

    /**
     * Specify True, to send a Pay button.
     * NOTE: This type of button must always be the first button in the first row.
     */
    @Nullable
    private Boolean pay;

    public InlineKeyboardButton() {
    }

    /**
     *
     * @return Label text on the button.
     */
    @NonNull
    public String getText() {
        return text;
    }

    /**
     *
     * @param text Label text on the button.
     */
    public void setText(@NonNull String text) {
        this.text = text;
    }

    /**
     *
     * @return HTTP or tg:// url to be opened when button is pressed
     */
    @Nullable
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url HTTP or tg:// url to be opened when button is pressed
     */
    public void setUrl(@Nullable String url) {
        this.url = url;
    }

    /**
     *
     * @return An HTTP URL used to automatically authorize the user. Can be used as a replacement for the Telegram Login Widget.
     */
    @Nullable
    public LoginUrl getLoginUrl() {
        return loginUrl;
    }

    /**
     *
     * @param loginUrl An HTTP URL used to automatically authorize the user. Can be used as a replacement for the Telegram Login Widget.
     */
    public void setLoginUrl(@Nullable LoginUrl loginUrl) {
        this.loginUrl = loginUrl;
    }

    /**
     *
     * @return Data to be sent in a callback query to the bot when button is pressed, 1-64 bytes.
     */
    @Nullable
    public String getCallbackData() {
        return callbackData;
    }

    /**
     *
     * @param callbackData Data to be sent in a callback query to the bot when button is pressed, 1-64 bytes.
     */
    public void setCallbackData(@Nullable String callbackData) {
        this.callbackData = callbackData;
    }

    /**
     *
     * @return If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot‘s username and the specified inline query in the input field. Can be empty, in which case just the bot’s username will be inserted.
     */
    @Nullable
    public String getSwitchInlineQuery() {
        return switchInlineQuery;
    }

    /**
     *
     * @param switchInlineQuery If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot‘s username and the specified inline query in the input field. Can be empty, in which case just the bot’s username will be inserted.
     */
    public void setSwitchInlineQuery(@Nullable String switchInlineQuery) {
        this.switchInlineQuery = switchInlineQuery;
    }

    /**
     *
     * @return If set, pressing the button will insert the bot‘s username and the specified inline query in the current chat's input field. Can be empty, in which case only the bot’s username will be inserted.
     */
    @Nullable
    public String getSwitchInlineQueryCurrentChat() {
        return switchInlineQueryCurrentChat;
    }

    /**
     *
     * @param switchInlineQueryCurrentChat If set, pressing the button will insert the bot‘s username and the specified inline query in the current chat's input field. Can be empty, in which case only the bot’s username will be inserted.
     */
    public void setSwitchInlineQueryCurrentChat(@Nullable String switchInlineQueryCurrentChat) {
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat;
    }

    /**
     *
     * @return Description of the game that will be launched when the user presses the button.
     */
    @Nullable
    public CallbackGame getCallbackGame() {
        return callbackGame;
    }

    /**
     *
     * @param callbackGame Description of the game that will be launched when the user presses the button.
     */
    public void setCallbackGame(@Nullable CallbackGame callbackGame) {
        this.callbackGame = callbackGame;
    }

    /**
     *
     * @return Specify True, to send a Pay button.
     */
    @Nullable
    public Boolean getPay() {
        return pay;
    }

    /**
     *
     * @param pay Specify True, to send a Pay button.
     */
    public void setPay(@Nullable Boolean pay) {
        this.pay = pay;
    }

    /**
     *
     * @return Description of the Web App that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method answerWebAppQuery. Available only in private chats between a user and the bot.
     */
    @Nullable
    public WebAppInfo getWebApp() {
        return webApp;
    }

    /**
     *
     * @param webApp Description of the Web App that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method answerWebAppQuery. Available only in private chats between a user and the bot.
     */
    public void setWebApp(@Nullable WebAppInfo webApp) {
        this.webApp = webApp;
    }

    @Override
    public String toString() {
        return "InlineKeyboardButton{" +
                "text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", loginUrl=" + (loginUrl != null ? loginUrl.toString() : "") +
                ", callbackData='" + callbackData + '\'' +
                ", switchInlineQuery='" + switchInlineQuery + '\'' +
                ", switchInlineQueryCurrentChat='" + switchInlineQueryCurrentChat + '\'' +
                ", callbackGame=" + callbackGame +
                ", pay=" + pay +
                '}';
    }
}
