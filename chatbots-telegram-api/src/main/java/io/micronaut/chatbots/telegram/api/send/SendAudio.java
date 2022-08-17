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
 * @see <a href="https://core.telegram.org/bots/api#sendaudio">SendAudio</a>.
 */
@Serdeable
public class SendAudio extends Send {

    public static final String SEND_AUDIO = "sendAudio";
    /**
     * Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data.
     */
    @NonNull
    @NotBlank
    private String audio;

    /**
     * Audio caption, 0-1024 characters.
     */
    @Nullable
    private String caption;

    /**
     * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
     */
    @JsonProperty("parse_mode")
    @Nullable
    private String parseMode;

    /**
     * Duration of the audio in seconds.
     */
    @Nullable
    private Integer duration;

    /**
     * Performer.
     */
    @Nullable
    private String performer;

    /**
     * Track name.
     */
    @Nullable
    private String title;

    /**
     * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>.
     */
    @Nullable
    private String thumb;

    public SendAudio() {
        super(SEND_AUDIO);
    }

    /**
     *
     * @return Audio file to send.
     */
    @NonNull
    public String getAudio() {
        return audio;
    }

    /**
     *
     * @param audio Audio file to send.
     */
    public void setAudio(@NonNull String audio) {
        this.audio = audio;
    }

    /**
     *
     * @return Audio caption, 0-1024 characters.
     */
    @Nullable
    public String getCaption() {
        return caption;
    }

    /**
     *
     * @param caption Audio caption, 0-1024 characters.
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
     * @return Duration of the audio in seconds.
     */
    @Nullable
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration Duration of the audio in seconds.
     */
    public void setDuration(@Nullable Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return Performer.
     */
    @Nullable
    public String getPerformer() {
        return performer;
    }

    /**
     *
     * @param performer Performer.
     */
    public void setPerformer(@Nullable String performer) {
        this.performer = performer;
    }

    /**
     *
     * @return Track name.
     */
    @Nullable
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title Track name.
     */
    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    /**
     *
     * @return Thumbnail of the file sent.
     */
    @Nullable
    public String getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb Thumbnail of the file sent.
     */
    public void setThumb(@Nullable String thumb) {
        this.thumb = thumb;
    }
}
