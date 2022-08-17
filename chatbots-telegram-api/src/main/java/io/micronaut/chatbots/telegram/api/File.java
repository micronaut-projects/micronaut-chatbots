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
package io.micronaut.chatbots.telegram.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;

/**
 * This object represents a file ready to be downloaded. The file can be downloaded via the link {@code https://api.telegram.org/file/bot<token>/<file_path>}. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling getFile.
 * @see <a href="https://core.telegram.org/bots/api#file">File</a>
 */
@Serdeable
public class File {
    /**
     * Identifier for this file, which can be used to download or reuse the file.
     */
    @NonNull
    @NotBlank
    @JsonProperty("file_id")
    private String fileId;

    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    @NonNull
    @NotBlank
    @JsonProperty("file_unique_id")
    private String fileUniqueId;

    /**
     * File size, if known.
     */
    @JsonProperty("file_size")
    @Nullable
    private Integer fileSize;

    /**
     * File path. Use https://api.telegram.org/file/bot<token>/<file_path> to get the file.
     */
    @Nullable
    @JsonProperty("file_path")
    private String filePath;

    public File() {
    }

    /**
     *
     * @return Identifier for this file, which can be used to download or reuse the file.
     */
    @NonNull
    public String getFileId() {
        return fileId;
    }

    /**
     *
     * @param fileId Identifier for this file, which can be used to download or reuse the file.
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
     * @return File size, if known.
     */
    @Nullable
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     *
     * @param fileSize File size, if known.
     */
    public void setFileSize(@Nullable Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     *
     * @return File path. Use {@code https://api.telegram.org/file/bot<token>/<file_path>} to get the file.
     */
    @Nullable
    public String getFilePath() {
        return filePath;
    }

    /**
     *
     * @param filePath File path. Use {@code https://api.telegram.org/file/bot<token>/<file_path>} to get the file.
     */
    public void setFilePath(@Nullable String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", fileSize=" + fileSize +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
