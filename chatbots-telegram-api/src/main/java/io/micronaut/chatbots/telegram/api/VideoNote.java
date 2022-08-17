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
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents a video message (available in Telegram apps as of v.4.0).
 * @see <a href="https://core.telegram.org/bots/api#videonote">VideoNote</a>
 */
@Serdeable
public class VideoNote {

    /**
     * Identifier for this file.
     */
    @JsonProperty("file_id")
    @NonNull
    @NotBlank
    private String fileId;

    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    @JsonProperty("file_unique_id")
    @NonNull
    @NotBlank
    private String fileUniqueId;

    /**
     * Video width and height (diameter of the video message) as defined by sender.
     */
    @NonNull
    @NotNull
    private Integer length;

    /**
     * Duration of the video in seconds as defined by sender.
     */
    @NonNull
    @NotNull
    private Integer duration;

    /**
     * Video thumbnail.
     */
    @Nullable
    @Valid
    private PhotoSize thumb;

    /**
     * File size.
     */
    @Nullable
    @JsonProperty("file_size")
    private Integer fileSize;

    public VideoNote() {

    }

    /**
     *
     * @return Identifier for this file.
     */
    @NonNull
    public String getFileId() {
        return fileId;
    }

    /**
     *
     * @param fileId Identifier for this file.
     */
    public void setFileId(@NonNull String fileId) {
        this.fileId = fileId;
    }

    /**
     *
     * @return Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    @NonNull
    public String getFileUniqueId() {
        return fileUniqueId;
    }

    /**
     *
     * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    public void setFileUniqueId(@NonNull String fileUniqueId) {
        this.fileUniqueId = fileUniqueId;
    }

    /**
     *
     * @return Video width and height (diameter of the video message) as defined by sender.
     */
    @NonNull
    public Integer getLength() {
        return length;
    }

    /**
     *
     * @param length Video width and height (diameter of the video message) as defined by sender.
     */
    public void setLength(@NonNull Integer length) {
        this.length = length;
    }

    /**
     *
     * @return Duration of the video in seconds as defined by sender.
     */
    @NonNull
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration Duration of the video in seconds as defined by sender.
     */
    public void setDuration(@NonNull Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return Video thumbnail.
     */
    @Nullable
    public PhotoSize getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb Video thumbnail.
     */
    public void setThumb(@Nullable PhotoSize thumb) {
        this.thumb = thumb;
    }

    /**
     *
     * @return File size.
     */
    @Nullable
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     *
     * @param fileSize File size.
     */
    public void setFileSize(@Nullable Integer fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "VideoNote{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", length=" + length +
                ", duration=" + duration +
                ", thumb=" + (thumb != null ? thumb.toString() : "") +
                ", fileSize=" + fileSize +
                '}';
    }
}
