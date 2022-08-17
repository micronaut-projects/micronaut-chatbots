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
 * @see <a href="https://core.telegram.org/bots/api#sendphoto">SendPhoto</a>
 */
@Serdeable
public class SendPhoto extends Send {

    public static final String SEND_PHOTO = "sendPhoto";
    /**
     * Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. More info on Sending Files »
     */
    @NonNull
    @NotBlank
    private String photo;

    /**
     * Photo caption (may also be used when resending photos by file_id), 0-1024 characters.
     */
    @Nullable
    private String caption;

    /**
     * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
     */
    @JsonProperty("parse_mode")
    @Nullable
    private String parseMode;

    public SendPhoto() {
        super(SEND_PHOTO);
    }

    /**
     *
     * @return Photo to send.
     */
    @NonNull
    public String getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo Photo to send.
     */
    public void setPhoto(@NonNull String photo) {
        this.photo = photo;
    }

    /**
     *
     * @return Photo caption (may also be used when resending photos by file_id), 0-1024 characters.
     */
    @Nullable
    public String getCaption() {
        return caption;
    }

    /**
     *
     * @param caption Photo caption (may also be used when resending photos by file_id), 0-1024 characters.
     */
    public void setCaption(@Nullable String caption) {
        this.caption = caption;
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
}
