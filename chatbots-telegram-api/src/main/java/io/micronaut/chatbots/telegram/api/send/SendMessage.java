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
package io.micronaut.chatbots.telegram.api.send;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;

/**
 * @see <a href="https://core.telegram.org/bots/api#sendmessage">sendMessage</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class SendMessage extends Send {

    public static final String METHOD_SENDMESSAGE = "sendMessage";

    /**
     * Text of the message to be sent.
     */
    @NonNull
    @NotBlank
    private String text;

    /**
     * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
     */
    @JsonProperty("parse_mode")
    @Nullable
    private String parseMode;

    /**
     * Disables link previews for links in this message.
     */
    @Nullable
    @JsonProperty("disable_web_page_preview")
    private Boolean disableWebPagePreview;

    public SendMessage() {
        super(METHOD_SENDMESSAGE);
    }

    /**
     *
     * @return Text of the message to be sent.
     */
    @NonNull
    public String getText() {
        return text;
    }

    /**
     *
     * @param text Text of the message to be sent.
     */
    public void setText(@NonNull String text) {
        this.text = text;
    }

    /**
     *
     * @return Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
     */
    @Nullable
    public String getParseMode() {
        return parseMode;
    }

    /**
     *
     * @param parseMode Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
     */
    public void setParseMode(@Nullable String parseMode) {
        this.parseMode = parseMode;
    }

    /**
     *
     * @return Disables link previews for links in this message.
     */
    @Nullable
    public Boolean getDisableWebPagePreview() {
        return disableWebPagePreview;
    }

    /**
     *
     * @param disableWebPagePreview Disables link previews for links in this message.
     */
    public void setDisableWebPagePreview(@Nullable Boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
    }

    @Override
    public String toString() {
        return "SendMessage{" +
                "method='" + method + '\'' +
                ", text='" + text + '\'' +
                ", parseMode='" + parseMode + '\'' +
                ", disableWebPagePreview=" + disableWebPagePreview +
                '}';
    }
}
