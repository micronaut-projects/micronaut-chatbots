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
import javax.validation.constraints.NotNull;

/**
 * This object represents a voice note.
 * @see <a href="https://core.telegram.org/bots/api#voice">Voice</a>
 */
@Serdeable
public class Voice extends AbstractFile {
    /**
     * Duration of the audio in seconds as defined by sender.
     */
    @NonNull
    @NotNull
    private Integer duration;

    /**
     * MIME type of the file as defined by sender.
     */
    @JsonProperty("mime_type")
    @Nullable
    private String mimeType;

    /**
     * File size.
     */
    @Nullable
    @JsonProperty("file_size")
    private Integer fileSize;

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
        return "Voice{" +
                "fileId='" + getFileId() + '\'' +
                ", fileUniqueId='" + getFileUniqueId() + '\'' +
                ", duration=" + duration +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
