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
import jakarta.validation.constraints.NotNull;

/**
 * @see <a href="https://core.telegram.org/bots/api#sticker">Sticker</a>
 * This object represents a sticker.
 */
@Serdeable
public class Sticker extends AbstractFileWithDimensions {
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
    private String name;

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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name setName of the sticker set to which the sticker belongs.
     */
    public void setName(@Nullable String name) {
        this.name = name;
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
                "fileId='" + getFileId() + '\'' +
                ", fileUniqueId='" + getFileUniqueId() + '\'' +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", isAnimated=" + animated +
                ", thumb=" + (thumb != null ? thumb.toString() : "") +
                ", emoji='" + emoji  + '\'' +
                ", setName='" + name + '\'' +
                ", maskPosition=" + (maskPosition != null ? maskPosition.toString() : "") +
                ", fileSize=" + fileSize +
                '}';
    }
}
