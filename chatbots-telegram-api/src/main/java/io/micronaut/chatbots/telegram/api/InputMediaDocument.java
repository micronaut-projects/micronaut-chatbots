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
 * Represents a general file to be sent.
 */
@Serdeable
public class InputMediaDocument extends InputMedia {
    private static final String TYPE_DOCUMENT = "document";

    /**
     * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>.
     * @see <a href="https://core.telegram.org/bots/api#sending-files">More info on Sending Files</a>
     */
    @Nullable
    private String thumb;

    /**
     * Disables automatic server-side content type detection for files uploaded using multipart/form-data. Always True, if the document is sent as part of an album.
     */
    @JsonProperty("disable_content_type_detection")
    @Nullable
    private Boolean disableContentTypeDetection;

    public InputMediaDocument() {
        super(TYPE_DOCUMENT);
    }

    public InputMediaDocument(String type) {
        super(type);
    }

    /**
     *
     * @return Thumbnail of the file sent
     */
    @Nullable
    public String getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb Thumbnail of the file sent
     */
    public void setThumb(@Nullable String thumb) {
        this.thumb = thumb;
    }

    /**
     *
     * @return Disables automatic server-side content type detection for files uploaded using multipart/form-data. Always True, if the document is sent as part of an album.
     */
    @Nullable
    public Boolean getDisableContentTypeDetection() {
        return disableContentTypeDetection;
    }

    /**
     *
     * @param disableContentTypeDetection Disables automatic server-side content type detection for files uploaded using multipart/form-data. Always True, if the document is sent as part of an album.
     */
    public void setDisableContentTypeDetection(@Nullable Boolean disableContentTypeDetection) {
        this.disableContentTypeDetection = disableContentTypeDetection;
    }

    @Override
    public String toString() {
        return "InputMediaDocument{" +
                "thumb='" + thumb + '\'' +
                super.toString() +
                '}';
    }
}
