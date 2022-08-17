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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @see <a href="https://core.telegram.org/bots/api#sticker">Sticker</a>
 * This object represents a sticker.
 */
@Serdeable
public class Sticker {
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
     * Sticker width.
     */
    @NonNull
    @NotNull
    private Integer width;

    /**
     * Sticker height.
     */
    @NonNull
    @NotNull
    private Integer height;

    /**
     * True, if the sticker is animated.
     */
    @JsonProperty("is_animated")
    @NonNull
    @NotNull
    private Boolean animated;

    /**
     * Sticker thumbnail in the .webp or .jpg format.
     */
    @Nullable
    private PhotoSize thumb;

    /**
     * Emoji associated with the sticker.
     */
    @Nullable
    private String emoji;

    /**
     * Name of the sticker set to which the sticker belongs.
     */
    @Nullable
    @JsonProperty("set_name")
    private String setName;

    /**
     * For mask stickers, the position where the mask should be placed.
     */
    @Nullable
    @JsonProperty("mask_position")
    private MaskPosition maskPosition;

    /**
     * File size.
     */
    @JsonProperty("file_size")
    @Nullable
    private Integer fileSize;

    public Sticker() {
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
     * @return Sticker width.
     */
    @NonNull
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width Sticker width.
     */
    public void setWidth(@NonNull Integer width) {
        this.width = width;
    }

    /**
     *
     * @return Sticker height.
     */
    @NonNull
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height Sticker height.
     */
    public void setHeight(@NonNull Integer height) {
        this.height = height;
    }

    /**
     *
     * @return True, if the sticker is animated.
     */
    @NonNull
    public Boolean isAnimated() {
        return animated;
    }

    /**
     *
     * @param animated True, if the sticker is animated.
     */
    public void setAnimated(@NonNull Boolean animated) {
        this.animated = animated;
    }

    /**
     *
     * @return Sticker thumbnail in the .webp or .jpg format.
     */
    @Nullable
    public PhotoSize getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb Sticker thumbnail in the .webp or .jpg format.
     */
    public void setThumb(@Nullable PhotoSize thumb) {
        this.thumb = thumb;
    }

    /**
     *
     * @return Emoji associated with the sticker.
     */
    @Nullable
    public String getEmoji() {
        return emoji;
    }

    /**
     *
     * @param emoji Emoji associated with the sticker.
     */
    public void setEmoji(@Nullable String emoji) {
        this.emoji = emoji;
    }

    /**
     *
     * @return Name of the sticker set to which the sticker belongs.
     */
    @Nullable
    public String getSetName() {
        return setName;
    }

    /**
     *
     * @param setName Name of the sticker set to which the sticker belongs.
     */
    public void setSetName(@Nullable String setName) {
        this.setName = setName;
    }

    /**
     *
     * @return For mask stickers, the position where the mask should be placed.
     */
    @Nullable
    public MaskPosition getMaskPosition() {
        return maskPosition;
    }

    /**
     *
     * @param maskPosition For mask stickers, the position where the mask should be placed.
     */
    public void setMaskPosition(@Nullable MaskPosition maskPosition) {
        this.maskPosition = maskPosition;
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
        return "Sticker{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", isAnimated=" + animated +
                ", thumb=" + (thumb != null ? thumb.toString() : "") +
                ", emoji='" + emoji  + '\'' +
                ", setName='" + setName + '\'' +
                ", maskPosition=" + (maskPosition != null ? maskPosition.toString() : "") +
                ", fileSize=" + fileSize +
                '}';
    }
}
