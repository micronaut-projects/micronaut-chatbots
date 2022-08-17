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

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * This object represents the content of a media message to be sent. It should be one of:
 * - {@link InputMediaAnimation}
 * - {@link InputMediaDocument}
 * - {@link InputMediaPhoto}
 * - {@link InputMediaVideo}
 */
@Serdeable
public abstract class InputMedia {
    /**
     * Type of the result, must be photo.
     */
    @NonNull
    @NotBlank
    private String type;

    /**
     * File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://<file_attach_name>” to upload a new one using multipart/form-data under <file_attach_name> name.
     * @see <a href="https://core.telegram.org/bots/api#sending-files">More info on Sending Files</a>
     */
    @NonNull
    @NotBlank
    private String media;

    /**
     * Caption of the audio to be sent, 0-1024 characters.
     */
    @Nullable
    private String caption;

    /**
     * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
     */
    @Nullable
    @JsonProperty("parse_mode")
    private String parseMode;

    /**
     * List of special entities that appear in the caption, which can be specified instead of parse_mode.
     */
    @Nullable
    @JsonProperty("caption_entities")
    private List<MessageEntity> captionEntities;

    public InputMedia(@NonNull String type) {
        this.type = type;
    }

    /**
     *
     * @return Type of the result, must be photo.
     */
    @NonNull
    public String getType() {
        return type;
    }

    /**
     *
     * @param type Type of the result, must be photo.
     */
    public void setType(@NonNull String type) {
        this.type = type;
    }

    /**
     *
     * @return File to send.
     */
    @NonNull
    public String getMedia() {
        return media;
    }

    /**
     *
     * @param media File to send.
     */
    public void setMedia(@NonNull String media) {
        this.media = media;
    }

    /**
     *
     * @return Caption of the audio to be sent, 0-1024 characters
     */
    @Nullable
    public String getCaption() {
        return caption;
    }

    /**
     *
     * @param caption Caption of the audio to be sent, 0-1024 characters
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

    /**
     *
     * @return List of special entities that appear in the caption, which can be specified instead of parse_mode.
     */
    @Nullable
    public List<MessageEntity> getCaptionEntities() {
        return captionEntities;
    }

    /**
     *
     * @param captionEntities List of special entities that appear in the caption, which can be specified instead of parse_mode.
     */
    public void setCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
    }

    @Override
    public String toString() {
        return "" +
                ", type='" + type + '\'' +
                ", media='" + media + '\'' +
                ", caption='" + caption + '\'' +
                ", parseMode='" + parseMode + '\'';
    }
}
