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
public class SendVideoNote extends Send {

    /**
     * Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data.
     */
    @JsonProperty("video_note")
    @NonNull
    @NotBlank
    private String videoNote;

    /**
     * Duration of sent video in seconds.
     */
    @Nullable
    private Integer duration;

    /**
     * Video width and height, i.e. diameter of the video message.
     */
    @Nullable
    private Integer length;

    /**
     * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>.
     * @see <a href="https://core.telegram.org/bots/api#sending-files">More info on Sending Files</a>
     */
    @Nullable
    private String thumb;
    /**
     * Sends the message silently. Users will receive a notification with no sound.
     */
    @JsonProperty("disable_notification")
    @Nullable
    private Boolean disableNotification;

    public SendVideoNote() {
        super("sendVideoNote");
    }

    /**
     *
     * @return Video note to send.
     */
    @NonNull
    public String getVideoNote() {
        return videoNote;
    }

    /**
     *
     * @param videoNote Video note to send.
     */
    public void setVideoNote(@NonNull String videoNote) {
        this.videoNote = videoNote;
    }

    /**
     *
     * @return Duration of sent video in seconds.
     */
    @Nullable
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration Duration of sent video in seconds.
     */
    public void setDuration(@Nullable Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return Video width and height, i.e. diameter of the video message.
     */
    @Nullable
    public Integer getLength() {
        return length;
    }

    /**
     *
     * @param length Video width and height, i.e. diameter of the video message.
     */
    public void setLength(@Nullable Integer length) {
        this.length = length;
    }

    /**
     *
     * @return Thumbnail of the file sent;
     */
    @Nullable
    public String getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb Thumbnail of the file sent;
     */
    public void setThumb(@Nullable String thumb) {
        this.thumb = thumb;
    }

    /**
     *
     * @return Sends the message silently.
     */
    @Override
    @Nullable
    public Boolean getDisableNotification() {
        return disableNotification;
    }

    /**
     *
     * @param disableNotification true to sends the message silently. Users will receive a notification with no sound.
     */
    @Override
    public void setDisableNotification(@Nullable Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }
}
