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

import javax.validation.constraints.NotNull;

/**
 * This object describes the position on faces where a mask should be placed by default.
 * @see <a href="https://core.telegram.org/bots/api#maskposition">Mask Position</a>.
 */
@Serdeable
public class MaskPosition {

    /**
     * The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
     */
    @NonNull
    @NotNull
    private MaskPositionPoint point;

    /**
     * Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
     */
    @NonNull
    @NotNull
    @JsonProperty("x_shift")
    private Float xshift;

    /**
     * Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position.
     */
    @NonNull
    @NotNull
    @JsonProperty("y_shift")
    private Float yshift;

    /**
     * Mask scaling coefficient. For example, 2.0 means double size.
     */
    @NonNull
    @NotNull
    private Float scale;

    /**
     *
     * @return The part of the face relative to which the mask should be placed.
     */
    @NonNull
    public MaskPositionPoint getPoint() {
        return point;
    }

    /**
     *
     * @param point The part of the face relative to which the mask should be placed.
     */
    public void setPoint(@NonNull MaskPositionPoint point) {
        this.point = point;
    }

    /**
     *
     * @return Shift by X-axis measured in widths of the mask scaled to the face size, from left to right.
     */
    @NonNull
    public Float getXshift() {
        return xshift;
    }

    /**
     *
     * @param xshift Shift by X-axis measured in widths of the mask scaled to the face size, from left to right.
     */
    public void setXshift(@NonNull Float xshift) {
        this.xshift = xshift;
    }

    /**
     *
     * @return Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom.
     */
    @NonNull
    public Float getYshift() {
        return yshift;
    }

    /**
     *
     * @param yshift Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom.
     */
    public void setYshift(@NonNull Float yshift) {
        this.yshift = yshift;
    }

    /**
     *
     * @return Mask scaling coefficient. For example, 2.0 means double size.
     */
    @NonNull
    public Float getScale() {
        return scale;
    }

    /**
     *
     * @param scale Mask scaling coefficient. For example, 2.0 means double size.
     */
    public void setScale(@NonNull Float scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "MaskPosition{" +
                "point='" + point + '\'' +
                ", xshift=" + xshift +
                ", yshift=" + yshift +
                ", scale=" + scale +
                '}';
    }
}
