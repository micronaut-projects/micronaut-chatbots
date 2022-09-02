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
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import javax.validation.Valid;

/**
 * This object represents a general file (as opposed to photos, voice messages and audio files).
 * @see <a href="https://core.telegram.org/bots/api#document">Document</a>
 */
@Serdeable
public class Document extends AbstractFile {
    /**
     * Document thumbnail as defined by sender.
     */
    @Nullable
    @Valid
    private PhotoSize thumb;

    /**
     * Original filename as defined by sender.
     */
    @JsonProperty("file_name")
    @Nullable
    private String fileName;

    /**
     * MIME type of the file as defined by sender.
     */
    @JsonProperty("mime_type")
    @Nullable
    private String mimeType;

    /**
     * File size.
     */
    @JsonProperty("file_size")
    @Nullable
    private Integer fileSize;

    /**
     *
     * @return Document thumbnail as defined by sender.
     */
    @Nullable
    public PhotoSize getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb Document thumbnail as defined by sender.
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
        return "Document{" +
                "fileId='" + getFileId() + '\'' +
                ", fileUniqueId='" + getFileUniqueId() + '\'' +
                ", thumb=" + (thumb != null ? thumb.toString() : "") +
                ", fileName='" + fileName + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
