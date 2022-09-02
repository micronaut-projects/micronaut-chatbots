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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents a Telegram user or bot.
 * <a href="https://core.telegram.org/bots/api#user">User</a>
 *
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class User {
    /**
     * Unique identifier for this user or bot.
     */
    @NonNull
    @NotNull
    private Integer id;

    /**
     * True, if this user is a bot.
     */
    @JsonProperty("is_bot")
    @NonNull
    @NotNull
    private Boolean bot;

    /**
     * User‘s or bot’s first name.
     */
    @JsonProperty("first_name")
    @NonNull
    @NotBlank
    private String firstName;

    /**
     * User‘s or bot’s last name.
     */
    @JsonProperty("last_name")
    @Nullable
    private String lastName;

    /**
     * User‘s or bot’s username.
     */
    @Nullable
    private String username;

    /**
     * IETF language tag of the user's language.
     * <a href="https://en.wikipedia.org/wiki/IETF_language_tag">IETF language tag</a>
     */
    @Nullable
    @JsonProperty("language_code")
    private String languageCode;

    /**
     * True, if this user is a Telegram Premium user.
     */
    @Nullable
    @JsonProperty("is_premium")
    private Boolean premium;

    /**
     * True, if this user added the bot to the attachment menu.
     */
    @Nullable
    @JsonProperty("added_to_attachment_menu")
    private Boolean addedToAttachmentMenu;

    /**
     * True, if the bot can be invited to groups. Returned only in getMe.
     */
    @Nullable
    @JsonProperty("can_join_groups")
    private Boolean canJoinGroups;

    /**
     * True, if privacy mode is disabled for the bot. Returned only in getMe.
     */
    @Nullable
    @JsonProperty("can_read_all_group_messages")
    private Boolean canReadAllGroupMessages;

    /*
     * True, if the bot supports inline queries. Returned only in getMe.
     */
    @Nullable
    @JsonProperty("supports_inline_queries")
    private Boolean supportsInlineQueries;
    
    /**
     *
     * @return Unique identifier for this user or bot.
     */
    @NonNull
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id Unique identifier for this user or bot.
     */
    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    /**
     *
     * @return True, if this user is a bot.
     */
    @NonNull
    public Boolean getBot() {
        return bot;
    }

    /**
     *
     * @param bot True, if this user is a bot.
     */
    public void setBot(@NonNull Boolean bot) {
        this.bot = bot;
    }

    /**
     *
     * @return User‘s or bot’s first name.
     */
    @NonNull
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName User‘s or bot’s first name.
     */
    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return User‘s or bot’s last name.
     */
    @Nullable
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName User‘s or bot’s last name.
     */
    public void setLastName(@Nullable String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return User‘s or bot’s username.
     */
    @Nullable
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username User‘s or bot’s username.
     */
    public void setUsername(@Nullable String username) {
        this.username = username;
    }

    /**
     *
     * @return IETF language tag of the user's language.
     */
    @Nullable
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     *
     * @param languageCode IETF language tag of the user's language.
     */
    public void setLanguageCode(@Nullable String languageCode) {
        this.languageCode = languageCode;
    }

    /**
     *
     * @return True, if the bot can be invited to groups. Returned only in getMe.
     */
    @Nullable
    public Boolean getCanJoinGroups() {
        return canJoinGroups;
    }

    /**
     *
     * @param canJoinGroups True, if the bot can be invited to groups. Returned only in getMe.
     */
    public void setCanJoinGroups(@Nullable Boolean canJoinGroups) {
        this.canJoinGroups = canJoinGroups;
    }

    /**
     *
     * @return True, if privacy mode is disabled for the bot. Returned only in getMe.
     */
    @Nullable
    public Boolean getCanReadAllGroupMessages() {
        return canReadAllGroupMessages;
    }

    /**
     *
     * @param canReadAllGroupMessages True, if privacy mode is disabled for the bot. Returned only in getMe.
     */
    public void setCanReadAllGroupMessages(@Nullable Boolean canReadAllGroupMessages) {
        this.canReadAllGroupMessages = canReadAllGroupMessages;
    }

    /**
     *
     * @return True, if the bot supports inline queries. Returned only in getMe.
     */
    @Nullable
    public Boolean getSupportsInlineQueries() {
        return supportsInlineQueries;
    }

    /**
     *
     * @param supportsInlineQueries True, if the bot supports inline queries. Returned only in getMe.
     */
    public void setSupportsInlineQueries(@Nullable Boolean supportsInlineQueries) {
        this.supportsInlineQueries = supportsInlineQueries;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", bot=" + bot +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", languageCode='" + languageCode + '\'' +
                ", canJoinGroups=" + canJoinGroups +
                ", canReadAllGroupMessages=" + canReadAllGroupMessages +
                ", supportsInlineQueries=" + supportsInlineQueries +
                '}';
    }

    /**
     *
     * @return True, if this user is a Telegram Premium user
     */
    @Nullable
    public Boolean isPremium() {
        return premium;
    }

    /**
     *
     * @param premium True, if this user is a Telegram Premium user
     */
    public void setPremium(@Nullable Boolean premium) {
        this.premium = premium;
    }

    /**
     *
     * @return True, if this user added the bot to the attachment menu
     */
    @Nullable
    public Boolean getAddedToAttachmentMenu() {
        return addedToAttachmentMenu;
    }

    /**
     *
     * @param addedToAttachmentMenu True, if this user added the bot to the attachment menu
     */
    public void setAddedToAttachmentMenu(@Nullable Boolean addedToAttachmentMenu) {
        this.addedToAttachmentMenu = addedToAttachmentMenu;
    }
}
