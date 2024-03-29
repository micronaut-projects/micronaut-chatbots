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

import jakarta.validation.constraints.NotBlank;

/**
 * <a href="https://core.telegram.org/bots/api#sendanimation">SendAnimation</a>.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class SendAnimation extends Send {

    public static final String SEND_ANIMATION = "sendAnimation";
    /**
     * Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data.
     */
    @NonNull
    @NotBlank
    private String animation;

    /**
     * Duration of sent video in seconds.
     */
    @Nullable
    private Integer duration;

    /**
     * Video width.
     */
    @Nullable
    private Integer width;

    /**
     * Video height.
     */
    @Nullable
    private Integer height;

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

    public SendAnimation() {
        super(SEND_ANIMATION);
    }

    /**
     *
     * @return Animation to send.
     */
    @NonNull
    public String getAnimation() {
        return animation;
    }

    /**
     *
     * @param animation Animation to send.
     */
    public void setAnimation(@NonNull String animation) {
        this.animation = animation;
    }

    /**
     *
     * @return Duration of sent video in seconds
     */
    @Nullable
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration Duration of sent video in seconds
     */
    public void setDuration(@Nullable Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return Video width.
     */
    @Nullable
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width Video width.
     */
    public void setWidth(@Nullable Integer width) {
        this.width = width;
    }

    /**
     *
     * @return Video height.
     */
    @Nullable
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height Video height.
     */
    public void setHeight(@Nullable Integer height) {
        this.height = height;
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
