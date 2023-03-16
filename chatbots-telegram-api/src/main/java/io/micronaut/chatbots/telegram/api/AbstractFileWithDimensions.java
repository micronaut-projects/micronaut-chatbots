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

import io.micronaut.core.annotation.NonNull;

import jakarta.validation.constraints.NotNull;

/**
 * File with width and height.
 * @author Sergio del Amo
 * @since 1.0.0
 */
public abstract class AbstractFileWithDimensions extends AbstractFile {
    /**
     * Photo width.
     */
    @NonNull
    @NotNull
    private Integer width;

    /**
     * Photo height.
     */
    @NonNull
    @NotNull
    private Integer height;

    /**
     *
     * @return Photo width.
     */
    @NonNull
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width Photo width.
     */
    public void setWidth(@NonNull Integer width) {
        this.width = width;
    }

    /**
     *
     * @return Photo height.
     */
    @NonNull
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height Photo height.
     */
    public void setHeight(@NonNull Integer height) {
        this.height = height;
    }
}
