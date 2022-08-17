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

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This object represents a sticker.
 * @see <a href="https://core.telegram.org/bots/api#stickerset">StickerSet</a>
 */
@Serdeable
public class StickerSet {
    /**
     * Sticker set name.
     */
    @NonNull
    @NotBlank
    private String name;

    /**
     * Sticker set title.
     */
    @NonNull
    @NotBlank
    private String title;

    /**
     * True, if the sticker set contains animated stickers.
     */
    @JsonProperty("is_animated")
    @NonNull
    @NotNull
    private Boolean animated;

    /**
     * True, if the sticker set contains masks.
     */
    @JsonProperty("contains_masks")
    @NonNull
    @NotNull
    private Boolean containsMasks;

    /**
     * List of all set stickers.
     */
    @NonNull
    @NotNull
    private List<@Valid Sticker> stickers;

    /**
     * Sticker set thumbnail in the .WEBP or .TGS format.
     */
    @Nullable
    private PhotoSize thumb;

    public StickerSet() {
    }

    /**
     *
     * @return Sticker set name.
     */
    @NonNull
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Sticker set name.
     */
    public void setName(@NonNull String name) {
        this.name = name;
    }

    /**
     *
     * @return Sticker set title.
     */
    @NonNull
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title Sticker set title.
     */
    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    /**
     *
     * @return True, if the sticker set contains animated stickers.
     */
    @NonNull
    public Boolean getAnimated() {
        return animated;
    }

    /**
     *
     * @param animated True, if the sticker set contains animated stickers.
     */
    public void setAnimated(@NonNull Boolean animated) {
        this.animated = animated;
    }

    /**
     *
     * @return True, if the sticker set contains masks.
     */
    @NonNull
    public Boolean getContainsMasks() {
        return containsMasks;
    }

    /**
     *
     * @param containsMasks True, if the sticker set contains masks.
     */
    public void setContainsMasks(@NonNull Boolean containsMasks) {
        this.containsMasks = containsMasks;
    }

    /**
     *
     * @return List of all set stickers.
     */
    @NonNull
    public List<Sticker> getStickers() {
        return stickers;
    }

    /**
     *
     * @param stickers List of all set stickers.
     */
    public void setStickers(@NonNull List<Sticker> stickers) {
        this.stickers = stickers;
    }

    /**
     *
     * @return Sticker set thumbnail in the .WEBP or .TGS format.
     */
    @Nullable
    public PhotoSize getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb Sticker set thumbnail in the .WEBP or .TGS format.
     */
    public void setThumb(@Nullable PhotoSize thumb) {
        this.thumb = thumb;
    }

    @Override
    public String toString() {
        return "StickerSet{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", animated=" + animated +
                ", containsMasks=" + containsMasks +
                ", stickers=" + (stickers != null ? stickers.stream().map(Sticker::toString).collect(Collectors.joining(",")) : "") +
                ", thumb=" + (thumb != null ? thumb.toString() : "") +
                '}';
    }
}
