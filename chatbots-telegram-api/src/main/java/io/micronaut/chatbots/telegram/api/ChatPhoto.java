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
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;

/**
 * This object represents a chat photo.
 * @see <a href="https://core.telegram.org/bots/api#chatphoto">ChatPhoto</a>
 */
@Serdeable
public class ChatPhoto {
    /**
     * File identifier of small (160x160) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed.
     */
    @NonNull
    @NotBlank
    @JsonProperty("small_file_id")
    private String smallFileId;

    /**
     * Unique file identifier of small (160x160) chat photo, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    @NonNull
    @NotBlank
    @JsonProperty("small_file_unique_id")
    private String smallFileUniqueId;

    /**
     * File identifier of big (640x640) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed.
     */
    @NonNull
    @NotBlank
    @JsonProperty("big_file_id")
    private String bigFileId;

    /**
     * Unique file identifier of big (640x640) chat photo, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    @NonNull
    @NotBlank
    @JsonProperty("big_file_unique_id")
    private String bigFileUniqueId;

    /**
     *
     * @return File identifier of small (160x160) chat photo.
     */
    @NonNull
    public String getSmallFileId() {
        return smallFileId;
    }

    /**
     *
     * @param smallFileId File identifier of small (160x160) chat photo.
     */
    public void setSmallFileId(@NonNull String smallFileId) {
        this.smallFileId = smallFileId;
    }

    /**
     *
     * @return File identifier of big (640x640) chat photo.
     */
    @NonNull
    public String getBigFileId() {
        return bigFileId;
    }

    /**
     *
     * @param bigFileId File identifier of big (640x640) chat photo.
     */
    public void setBigFileId(@NonNull String bigFileId) {
        this.bigFileId = bigFileId;
    }

    /**
     *
     * @return Unique file identifier of small (160x160) chat photo
     */
    @NonNull
    public String getSmallFileUniqueId() {
        return smallFileUniqueId;
    }

    /**
     *
     * @param smallFileUniqueId Unique file identifier of small (160x160) chat photo
     */
    public void setSmallFileUniqueId(@NonNull String smallFileUniqueId) {
        this.smallFileUniqueId = smallFileUniqueId;
    }

    /**
     *
     * @return Unique file identifier of big (640x640) chat photo
     */
    @NonNull
    public String getBigFileUniqueId() {
        return bigFileUniqueId;
    }

    /**
     *
     * @param bigFileUniqueId Unique file identifier of big (640x640) chat photo
     */
    public void setBigFileUniqueId(@NonNull String bigFileUniqueId) {
        this.bigFileUniqueId = bigFileUniqueId;
    }

    @Override
    public String toString() {
        return "ChatPhoto{" +
                "smallFileId='" + smallFileId + '\'' +
                ", smallFileUniqueId='" + smallFileUniqueId + '\'' +
                ", bigFileId='" + bigFileId + '\'' +
                ", bigFileUniqueId='" + bigFileUniqueId + '\'' +
                '}';
    }
}
