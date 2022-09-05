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
package io.micronaut.chatbots.basecamp.api;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class Company {

    @NonNull
    @NotNull
    private Long id;

    @NonNull
    @NotBlank
    private String name;

    /**
     *
     * @return Company unique identifier
     */
    @NonNull
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id Company unique identifier
     */
    public void setId(@NonNull Long id) {
        this.id = id;
    }

    /**
     *
     * @return Company Name
     */
    @NonNull
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Company name.
     */
    public void setName(@NonNull String name) {
        this.name = name;
    }
}
