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

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;

/**
 * A user in Google Chat.
 * @see <a href="https://developers.google.com/chat/api/reference/rest/v1/User">User</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class User {
    /**
     * Resource name for a Google Chat user. Represents a person in the People API or a user in the Admin SDK Directory API. Formatted as: users/{user}
     */
    @NonNull
    @NotBlank
    private String name;
    /**
     * Output only. The user's display name.
     */
    @Nullable
    private String displayName;

    /**
     * Unique identifier of the user's Google Workspace domain.
     */
    @Nullable
    private String domainId;

    /**
     * User type.
     */
    @Nullable
    private UserType type;

    /**
     * Output only. When true, the user is deleted or their profile is not visible.
     */
    @JsonProperty("isAnonymous")
    @Nullable private Boolean anonymous;

    /**
     *
     * @return Resource name for a Google Chat user.
     */
    @NonNull
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Resource name for a Google Chat user.
     */
    public void setName(@NonNull String name) {
        this.name = name;
    }

    /**
     *
     * @return The user's display name.
     */
    @Nullable
    public String getDisplayName() {
        return displayName;
    }

    /**
     *
     * @param displayName The user's display name.
     */
    public void setDisplayName(@Nullable String displayName) {
        this.displayName = displayName;
    }

    /**
     *
     * @return Unique identifier of the user's Google Workspace domain.
     */
    @Nullable
    public String getDomainId() {
        return domainId;
    }

    /**
     *
     * @param domainId Unique identifier of the user's Google Workspace domain.
     */
    public void setDomainId(@Nullable String domainId) {
        this.domainId = domainId;
    }

    /**
     *
     * @return User type.
     */
    @Nullable
    public UserType getType() {
        return type;
    }

    /**
     *
     * @param type User type.
     */
    public void setType(@Nullable UserType type) {
        this.type = type;
    }

    /**
     *
     * @return When true, the user is deleted or their profile is not visible.
     */
    @Nullable
    public Boolean getAnonymous() {
        return anonymous;
    }

    /**
     *
     * @param anonymous  When true, the user is deleted or their profile is not visible.
     */
    public void setAnonymous(@Nullable Boolean anonymous) {
        this.anonymous = anonymous;
    }
}
