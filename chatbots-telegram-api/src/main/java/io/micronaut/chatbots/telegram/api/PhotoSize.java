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
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

/**
 * This object represents one size of a photo or a file / sticker thumbnail.
 * @see <a href="https://core.telegram.org/bots/api#photosize">PhotoSize</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class PhotoSize extends AbstractFileWithDimensions {

    /**
     * File size.
     */
    @JsonProperty("file_size")
    @Nullable
    private Integer fileSize;

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
        return "PhotoSize{" +
                "fileId='" + getFileId() + '\'' +
                ", fileUniqueId='" + getFileUniqueId() + '\'' +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", fileSize=" + fileSize +
                '}';
    }
}
