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
package io.micronaut.chatbots.google.api;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;

/**
 * A space in Google Chat. Spaces are conversations between two or more users or 1:1 messages between a user and a Chat app.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class Space {
    /**
     * Resource name of the space. Format: spaces/{space}
     */
    @NonNull
    @NotBlank
    private String name;

    /**
     *  Output only. Whether the space is a DM between a Chat app and a single human.
     */
    @Nullable
    private Boolean singleUserBotDm;

    /**
     *  Output only. Whether messages are threaded in this space.
     */
    @Nullable
    private Boolean threaded;

    /**
     * The space's display name. For direct messages between humans, this field might be empty.
     */
    @Nullable
    private String displayName;

    /**
     * The type of space. Required when creating a space. Output only for other usage.
     */
    @Nullable
    private SpaceType spaceType;

    /**
     * Details about the space including description and rules.
     */
    @Nullable
    private SpaceDetails spaceDetails;

    /**
     *
     * @return Resource name of the space. Format: spaces/{space}
     */
    @NonNull
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Resource name of the space. Format: spaces/{space}
     */
    public void setName(@NonNull String name) {
        this.name = name;
    }

    /**
     *
     * @return Whether the space is a DM between a Chat app and a single human.
     */
    @Nullable
    public Boolean getSingleUserBotDm() {
        return singleUserBotDm;
    }

    /**
     *
     * @param singleUserBotDm Whether the space is a DM between a Chat app and a single human.
     */
    public void setSingleUserBotDm(@Nullable Boolean singleUserBotDm) {
        this.singleUserBotDm = singleUserBotDm;
    }

    /**
     *
     * @return Whether messages are threaded in this space.
     */
    @Nullable
    public Boolean getThreaded() {
        return threaded;
    }

    /**
     *
     * @param threaded Whether messages are threaded in this space.
     */
    public void setThreaded(@Nullable Boolean threaded) {
        this.threaded = threaded;
    }

    /**
     *
     * @return The space's display name.
     */
    @Nullable
    public String getDisplayName() {
        return displayName;
    }

    /**
     *
     * @param displayName The space's display name.
     */
    public void setDisplayName(@Nullable String displayName) {
        this.displayName = displayName;
    }

    /**
     *
     * @return The type of a space.
     */
    @Nullable
    public SpaceType getSpaceType() {
        return spaceType;
    }

    /**
     *
     * @param spaceType The type of a space.
     */
    public void setSpaceType(@Nullable SpaceType spaceType) {
        this.spaceType = spaceType;
    }

    /**
     *
     * @return Details about the space including description and rules.
     */
    @Nullable
    public SpaceDetails getSpaceDetails() {
        return spaceDetails;
    }

    /**
     *
     * @param spaceDetails Details about the space including description and rules.
     */
    public void setSpaceDetails(@Nullable SpaceDetails spaceDetails) {
        this.spaceDetails = spaceDetails;
    }
}
