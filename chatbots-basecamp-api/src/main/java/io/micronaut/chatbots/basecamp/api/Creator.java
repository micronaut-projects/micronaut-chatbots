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


import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Message Creator.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class Creator {
    @NonNull
    @NotNull
    Long id;

    @JsonProperty("attachable_sgid")
    @Nullable
    private String attachableSgid;

    @Nullable
    private String name;

    @JsonProperty("email_address")
    @Nullable
    private String emailAddress;

    @JsonProperty("personable_type")
    @Nullable
    private String personableType;

    @Nullable
    private String title;

    @Nullable
    private String bio;

    @Nullable
    private String location;

    @JsonProperty("created_at")
    @Nullable
    private String createdAt;

    @JsonProperty("updated_at")
    @Nullable
    private String updatedAt;

    @Nullable
    private Boolean admin;

    @Nullable
    private Boolean owner;

    @Nullable
    private Boolean client;

    @JsonProperty("time_zone")
    @Nullable
    private String timeZone;

    @JsonProperty("avatar_url")
    @Nullable
    private String avatarUrl;

    @JsonProperty("avatar_kind")
    @Nullable
    private String avatarKind;

    @Valid
    @Nullable
    private Company company;

    /**
     *
     * @return Creator Unique Identifier
     */
    @NonNull
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id Creator unique identifier
     */
    public void setId(@NonNull Long id) {
        this.id = id;
    }

    /**
     *
     * @return Creator Attachable SgID
     */
    @Nullable
    public String getAttachableSgid() {
        return attachableSgid;
    }

    /**
     *
     * @param attachableSgid  Creator Attachable SgID
     */
    public void setAttachableSgid(@Nullable String attachableSgid) {
        this.attachableSgid = attachableSgid;
    }

    /**
     *
     * @return Name
     */
    @Nullable
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Name
     */
    public void setName(@Nullable String name) {
        this.name = name;
    }

    /**
     *
     * @return Email address
     */
    @Nullable
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     *
     * @param emailAddress Email address
     */
    public void setEmailAddress(@Nullable String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     *  @return Personable Type E.g. User
     */
    @Nullable
    public String getPersonableType() {
        return personableType;
    }

    /**
     *
     * @param personableType Personable Type E.g. User
     */
    public void setPersonableType(@Nullable String personableType) {
        this.personableType = personableType;
    }

    /**
     *
     * @return Creator's title
     */
    @Nullable
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title Creator's title
     */
    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    /**
     *
     * @return Creator's bio
     */
    @Nullable
    public String getBio() {
        return bio;
    }

    /**
     *
     * @param bio Creator's bio
     */
    public void setBio(@Nullable String bio) {
        this.bio = bio;
    }

    /**
     *
     * @return Creator's location
     */
    @Nullable
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location Creator's location
     */
    public void setLocation(@Nullable String location) {
        this.location = location;
    }

    /**
     *
     * @return Date when the creator was created. e.g. 2022-06-16T10:53:51.826+02:00
     */
    @Nullable
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt Date when the creator was created. e.g. 2022-06-16T10:53:51.826+02:00
     */
    public void setCreatedAt(@Nullable String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *  @return Date when the creator was updated. e.g. 2022-06-16T10:53:51.826+02:00.
     */
    @Nullable
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt Date when the creator was updated. e.g. 2022-06-16T10:53:51.826+02:00
     */
    public void setUpdatedAt(@Nullable String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return Whether the creator is an admin of the baescamp account.
     */
    @Nullable
    public Boolean getAdmin() {
        return admin;
    }

    /**
     *
     * @param admin Whether the creator is an admin of the basecamp account.
     */
    public void setAdmin(@Nullable Boolean admin) {
        this.admin = admin;
    }

    /**
     *
     * @return Whether the creator is the basecamp acount owner.
     */
    @Nullable
    public Boolean getOwner() {
        return owner;
    }

    /**
     *
     * @param owner Whether the creator is the basecamp acount owner.
     */
    public void setOwner(@Nullable Boolean owner) {
        this.owner = owner;
    }

    /**
     * @see <a href="https://basecamp.com/features/clients">Clients</a>.
     * @return Whether the creator is a client.
     */
    @Nullable
    public Boolean getClient() {
        return client;
    }

    /**
     *
     * @param client Whether the creator is a client.
     */
    public void setClient(@Nullable Boolean client) {
        this.client = client;
    }

    /**
     *
     * @return  Time Zone. E.g. Europe/Madrid
     */
    @Nullable
    public String getTimeZone() {
        return timeZone;
    }

    /**
     *
     * @param timeZone Time Zone. E.g. Europe/Madrid
     */
    public void setTimeZone(@Nullable String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     *
     * @return Avatar URL
     */
    @Nullable
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     *
     * @param avatarUrl  Avatar URL
     */
    public void setAvatarUrl(@Nullable String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     *
     * @return Avatar Kind. e.g. custom
     */
    @Nullable
    public String getAvatarKind() {
        return avatarKind;
    }

    /**
     *
     * @param avatarKind Avatar Kinde e.g. custom
     */
    public void setAvatarKind(@Nullable String avatarKind) {
        this.avatarKind = avatarKind;
    }

    /**
     *
     * @return company associated to the message creator
     */
    @Nullable
    public Company getCompany() {
        return company;
    }

    /**
     *
     * @param company company associated to the message creator
     */
    public void setCompany(@Nullable Company company) {
        this.company = company;
    }
}
