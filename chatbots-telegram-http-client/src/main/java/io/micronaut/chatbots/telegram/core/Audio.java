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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents an audio file to be treated as music by the Telegram clients.
 * @see <a href="https://core.telegram.org/bots/api#audio">Audio</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Audio {

    /**
     * Identifier for this file.
     */
    @JsonProperty("file_id")
    @NotBlank
    @NonNull
    private String fileId;

    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    @JsonProperty("file_unique_id")
    @NotBlank
    @NonNull
    private String fileUniqueId;

    /**
     * Duration of the audio in seconds as defined by sender.
     */
    @NonNull
    @NotNull
    private Integer duration;

    /**
     * Performer of the audio as defined by sender or by audio tags.
     */
    @Nullable
    private String performer;

    /**
     * Title of the audio as defined by sender or by audio tags.
     */
    @Nullable
    private String title;

    /**
     * Original filename as defined by sender.
     */
    @JsonProperty("file_name")
    @Nullable
    private String fileName;

    /**
     * MIME type of the file as defined by sender.
     */
    @Nullable
    @JsonProperty("mime_type")
    private String mimeType;

    @Nullable
    @JsonProperty("file_size")
    private Integer fileSize;

    /**
     * Thumbnail of the album cover to which the music file belongs.
     */
    @Nullable
    private PhotoSize thumb;

    /**
     * Constructor.
     */
    public Audio() {
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
     * @return Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file..
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
     * @return Duration of the audio in seconds as defined by sender.
     */
    @NonNull
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration Duration of the audio in seconds as defined by sender.
     */
    public void setDuration(@NonNull Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return Performer of the audio as defined by sender or by audio tags.
     */
    @Nullable
    public String getPerformer() {
        return performer;
    }

    /**
     *
     * @param performer Performer of the audio as defined by sender or by audio tags.
     */
    public void setPerformer(@Nullable String performer) {
        this.performer = performer;
    }

    /**
     *
     * @return Title of the audio as defined by sender or by audio tags.
     */
    @Nullable
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title Title of the audio as defined by sender or by audio tags.
     */
    public void setTitle(@Nullable String title) {
        this.title = title;
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
     * @return File size
     */
    @Nullable
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     *
     * @param fileSize File size
     */
    public void setFileSize(@Nullable Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     *
     * @return Thumbnail of the album cover to which the music file belongs.
     */
    @Nullable
    public PhotoSize getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb Thumbnail of the album cover to which the music file belongs.
     */
    public void setThumb(@Nullable PhotoSize thumb) {
        this.thumb = thumb;
    }

    /**
     *
     * @return Original filename as defined by sender.
     */
    @Nullable
    public String getFileName() {
        return fileName;
    }

    /**
     *
     * @param fileName Original filename as defined by sender.
     */
    public void setFileName(@Nullable String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", duration=" + duration +
                ", performer='" + performer + '\'' +
                ", title='" + title + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                ", thumb=" + (thumb != null ? thumb.toString() : "") +
                '}';
    }
}
