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
 * This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).
 * @see <a href="https://core.telegram.org/bots/api#animation">Animation</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class Animation {

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
     * Video width as defined by sender.
     */
    @NonNull
    @NotNull
    private Integer width;

    /**
     * Video height as defined by sender.
     */
    @NonNull
    @NotNull
    private Integer height;

    /**
     * Duration of the video in seconds as defined by sender.
     */
    @NonNull
    @NotNull
    private Integer duration;

    /**
     * Animation thumbnail as defined by sender.
     */
    @Nullable
    @Valid
    private PhotoSize thumb;

    /**
     * Original animation filename as defined by sender.
     */
    @Nullable
    @JsonProperty("file_name")
    private String fileName;

    /**
     * MIME type of the file as defined by sender.
     */
    @Nullable
    @JsonProperty("mime_type")
    private String mimeType;

    /**
     * File size.
     */
    @Nullable
    @JsonProperty("file_size")
    private Integer fileSize;

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
     * @return Video width as defined by sender.
     */
    @NonNull
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width Video width as defined by sender.
     */
    public void setWidth(@NonNull Integer width) {
        this.width = width;
    }

    /**
     *
     * @return Video height as defined by sender.
     */
    @NonNull
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height Video height as defined by sender.
     */
    public void setHeight(@NonNull Integer height) {
        this.height = height;
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
     * @return Animation thumbnail as defined by sender.
     */
    @Nullable
    public PhotoSize getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb Animation thumbnail as defined by sender.
     */
    public void setThumb(@Nullable PhotoSize thumb) {
        this.thumb = thumb;
    }

    /**
     *
     * @return Original animation filename as defined by sender.
     */
    @Nullable
    public String getFileName() {
        return fileName;
    }

    /**
     *
     * @param fileName Original animation filename as defined by sender.
     */
    public void setFileName(@Nullable String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return MIME type of the file as defined by sender.
     */
    @Nullable
    public String getMimeType() {
        return mimeType;
    }

    /**
     *
     * @param mimeType MIME type of the file as defined by sender.
     */
    public void setMimeType(@Nullable String mimeType) {
        this.mimeType = mimeType;
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
        return "Animation{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", thumb=" + (thumb != null ? thumb.toString() : "") +
                ", fileName='" + fileName + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
