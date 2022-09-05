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
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class SendDocument extends Send {

    /**
     * File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data.
     */
    @NonNull
    @NotBlank
    private String document;

    /**
     * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>.
     * @see <a href="https://core.telegram.org/bots/api#sending-files">More info on Sending Files</a>
     */
    @Nullable
    private String thumb;

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

    public SendDocument() {
        super("sendDocument");
    }

    /**
     *
     * @return File to send.
     */
    @NonNull
    public String getDocument() {
        return document;
    }

    /**
     *
     * @param document File to send.
     */
    public void setDocument(@NonNull String document) {
        this.document = document;
    }

    /**
     *
     * @return Thumbnail of the file sent
     */
    @Nullable
    public String getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb Thumbnail of the file sent
     */
    public void setThumb(@Nullable String thumb) {
        this.thumb = thumb;
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
