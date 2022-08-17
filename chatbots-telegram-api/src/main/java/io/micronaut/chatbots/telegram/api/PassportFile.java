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
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;

/**
 * This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.
 * @see <a href="https://core.telegram.org/bots/api#passportfile">PassportFile</a>
 */
@Serdeable
public class PassportFile {
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
     * File size.
     */
    @JsonProperty("file_size;")
    private Integer fileSize;

    /**
     * Unix time when the file was uploaded.
     */
    @JsonProperty("file_date;")
    private Integer fileDate;

    public PassportFile() {
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
     * @return File size.
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     *
     * @param fileSize File size.
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     *
     * @return Unix time when the file was uploaded.
     */
    public Integer getFileDate() {
        return fileDate;
    }

    /**
     *
     * @param fileDate Unix time when the file was uploaded.
     */
    public void setFileDate(Integer fileDate) {
        this.fileDate = fileDate;
    }

    @Override
    public String toString() {
        return "PassportFile{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", fileSize=" + fileSize +
                ", fileDate=" + fileDate +
                '}';
    }
}
