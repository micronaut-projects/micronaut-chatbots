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
import javax.validation.constraints.NotNull;

/**
 * This object contains information about one member of a chat.
 * @see <a href="https://core.telegram.org/bots/api#chatmember">Chat Member</a>
 */
@Serdeable
public class ChatMember {
    /**
     * Information about the user.
     */
    @NonNull
    @NotNull
    @Valid
    private User user;

    /**
     * The member's status in the chat. Can be “creator”, “administrator”, “member”, “restricted”, “left” or “kicked”.
     */
    private String status;

    /**
     * Owner and administrators only. Custom title for this user.
     */
    @Nullable
    @JsonProperty("custom_title")
    private String customTitle;

    /**
     * Restricted and kicked only. Date when restrictions will be lifted for this user; unix time.
     */
    @Nullable
    @JsonProperty("until_date")
    private Integer untilDate;

    /**
     * Administrators only. True, if the bot is allowed to edit administrator privileges of that user.
     */
    @Nullable
    @JsonProperty("can_be_edited")
    private Boolean canBeEdited;

    /**
     * Administrators only. True, if the administrator can post in the channel; channels only.
     */
    @Nullable
    @JsonProperty("can_post_messages")
    private Boolean canPostMessages;

    /**
     * Administrators only. True, if the administrator can edit messages of other users and can pin messages; channels only.
     */
    @Nullable
    @JsonProperty("can_edit_messages")
    private Boolean canEditMessages;

    /**
     * Administrators only. True, if the administrator can delete messages of other users.
     */
    @Nullable
    private Boolean canDeleteMessages;

    /**
     * Administrators only. True, if the administrator can restrict, ban or unban chat members.
     */
    @Nullable
    @JsonProperty("can_restrict_members")
    private Boolean canRestrictMembers;

    /**
     * Administrators only. True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user).
     */
    @Nullable
    @JsonProperty("can_promote_members")
    private Boolean canPromoteMembers;

    /**
     * Administrators and restricted only. True, if the user is allowed to change the chat title, photo and other settings.
     */
    @JsonProperty("can_change_info")
    @Nullable
    private Boolean canChangeInfo;

    /**
     * Administrators and restricted only. True, if the user is allowed to invite new users to the chat.
     */
    @Nullable
    @JsonProperty("can_invite_users")
    private Boolean canInviteUsers;

    /**
     * Administrators and restricted only. True, if the user is allowed to pin messages; groups and supergroups only.
     */
    @Nullable
    @JsonProperty("can_pin_messages")
    private Boolean canPinMessages;

    /**
     * Restricted only. True, if the user is a member of the chat at the moment of the request.
     */
    @Nullable
    @JsonProperty("is_member")
    private Boolean isMember;

    /**
     * Restricted only. True, if the user is allowed to send text messages, contacts, locations and venues.
     */
    @Nullable
    @JsonProperty("can_send_messages")
    private Boolean canSendMessages;

    /**
     * Restricted only. True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes.
     */
    @Nullable
    @JsonProperty("can_send_media_messages")
    private Boolean canSendMediaMessages;

    /**
     * Restricted only. True, if the user is allowed to send polls.
     */
    @Nullable
    @JsonProperty("can_send_polls")
    private Boolean canSendPolls;

    /**
     * Restricted only. True, if the user is allowed to send animations, games, stickers and use inline bots.
     */
    @Nullable
    @JsonProperty("can_send_other_messages")
    private Boolean canSendOtherMessages;

    /**
     *  Restricted only. True, if the user is allowed to add web page previews to their messages.
     */
    @Nullable
    @JsonProperty("can_add_web_page_previews")
    private Boolean canAddWebPagePreviews;

    public ChatMember() {
    }

    /**
     *
     * @return Information about the user.
     */
    @NonNull
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user Information about the user.
     */
    public void setUser(@NonNull User user) {
        this.user = user;
    }

    /**
     *
     * @return The member's status in the chat.
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status The member's status in the chat.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return Custom title for this user.
     */
    @Nullable
    public String getCustomTitle() {
        return customTitle;
    }

    /**
     *
     * @param customTitle Custom title for this user.
     */
    public void setCustomTitle(@Nullable String customTitle) {
        this.customTitle = customTitle;
    }

    /**
     *
     * @return Date when restrictions will be lifted for this user
     */
    @Nullable
    public Integer getUntilDate() {
        return untilDate;
    }

    /**
     *
     * @param untilDate Date when restrictions will be lifted for this user
     */
    public void setUntilDate(@Nullable Integer untilDate) {
        this.untilDate = untilDate;
    }

    /**
     *
     * @return True, if the bot is allowed to edit administrator privileges of that user.
     */
    @Nullable
    public Boolean getCanBeEdited() {
        return canBeEdited;
    }

    /**
     *
     * @param canBeEdited True, if the bot is allowed to edit administrator privileges of that user.
     */
    public void setCanBeEdited(@Nullable Boolean canBeEdited) {
        this.canBeEdited = canBeEdited;
    }

    /**
     *
     * @return True, if the administrator can post in the channel; channels only.
     */
    @Nullable
    public Boolean getCanPostMessages() {
        return canPostMessages;
    }

    /**
     *
     * @param canPostMessages True, if the administrator can post in the channel; channels only.
     */
    public void setCanPostMessages(@Nullable Boolean canPostMessages) {
        this.canPostMessages = canPostMessages;
    }

    /**
     *
     * @return True, if the administrator can edit messages of other users and can pin messages; channels only.
     */
    @Nullable
    public Boolean getCanEditMessages() {
        return canEditMessages;
    }

    /**
     *
     * @param canEditMessages True, if the administrator can edit messages of other users and can pin messages; channels only.
     */
    public void setCanEditMessages(@Nullable Boolean canEditMessages) {
        this.canEditMessages = canEditMessages;
    }

    /**
     *
     * @return True, if the administrator can delete messages of other users.
     */
    @Nullable
    public Boolean getCanDeleteMessages() {
        return canDeleteMessages;
    }

    /**
     *
     * @param canDeleteMessages True, if the administrator can delete messages of other users.
     */
    public void setCanDeleteMessages(@Nullable Boolean canDeleteMessages) {
        this.canDeleteMessages = canDeleteMessages;
    }

    /**
     *
     * @return True, if the administrator can restrict, ban or unban chat members.
     */
    @Nullable
    public Boolean getCanRestrictMembers() {
        return canRestrictMembers;
    }

    /**
     *
     * @param canRestrictMembers True, if the administrator can restrict, ban or unban chat members.
     */
    public void setCanRestrictMembers(@Nullable Boolean canRestrictMembers) {
        this.canRestrictMembers = canRestrictMembers;
    }

    /**
     *
     * @return True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly
     */
    @Nullable
    public Boolean getCanPromoteMembers() {
        return canPromoteMembers;
    }

    /**
     *
     * @param canPromoteMembers True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly
     */
    public void setCanPromoteMembers(@Nullable Boolean canPromoteMembers) {
        this.canPromoteMembers = canPromoteMembers;
    }

    /**
     *
     * @return True, if the user is allowed to change the chat title, photo and other settings.
     */
    @Nullable
    public Boolean getCanChangeInfo() {
        return canChangeInfo;
    }

    /**
     *
     * @param canChangeInfo True, if the user is allowed to change the chat title, photo and other settings.
     */
    public void setCanChangeInfo(@Nullable Boolean canChangeInfo) {
        this.canChangeInfo = canChangeInfo;
    }

    /**
     *
     * @return True, if the user is allowed to invite new users to the chat.
     */
    @Nullable
    public Boolean getCanInviteUsers() {
        return canInviteUsers;
    }

    /**
     *
     * @param canInviteUsers True, if the user is allowed to invite new users to the chat.
     */
    public void setCanInviteUsers(@Nullable Boolean canInviteUsers) {
        this.canInviteUsers = canInviteUsers;
    }

    /**
     *
     * @return True, if the user is allowed to pin messages; groups and supergroups only.
     */
    @Nullable
    public Boolean getCanPinMessages() {
        return canPinMessages;
    }

    /**
     *
     * @param canPinMessages True, if the user is allowed to pin messages; groups and supergroups only.
     */
    public void setCanPinMessages(@Nullable Boolean canPinMessages) {
        this.canPinMessages = canPinMessages;
    }

    /**
     *
     * @return True, if the user is a member of the chat at the moment of the request.
     */
    @Nullable
    public Boolean getMember() {
        return isMember;
    }

    /**
     *
     * @param member True, if the user is a member of the chat at the moment of the request.
     */
    public void setMember(@Nullable Boolean member) {
        isMember = member;
    }

    /**
     *
     * @return True, if the user is allowed to send text messages, contacts, locations and venues.
     */
    @Nullable
    public Boolean getCanSendMessages() {
        return canSendMessages;
    }

    /**
     *
     * @param canSendMessages True, if the user is allowed to send text messages, contacts, locations and venues.
     */
    public void setCanSendMessages(@Nullable Boolean canSendMessages) {
        this.canSendMessages = canSendMessages;
    }

    /**
     *
     * @return True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes.
     */
    @Nullable
    public Boolean getCanSendMediaMessages() {
        return canSendMediaMessages;
    }

    /**
     *
     * @param canSendMediaMessages True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes.
     */
    public void setCanSendMediaMessages(@Nullable Boolean canSendMediaMessages) {
        this.canSendMediaMessages = canSendMediaMessages;
    }

    /**
     *
     * @return True, if the user is allowed to send polls.
     */
    @Nullable
    public Boolean getCanSendPolls() {
        return canSendPolls;
    }

    /**
     *
     * @param canSendPolls True, if the user is allowed to send polls.
     */
    public void setCanSendPolls(@Nullable Boolean canSendPolls) {
        this.canSendPolls = canSendPolls;
    }

    /**
     *
     * @return True, if the user is allowed to send animations, games, stickers and use inline bots.
     */
    @Nullable
    public Boolean getCanSendOtherMessages() {
        return canSendOtherMessages;
    }

    /**
     *
     * @param canSendOtherMessages True, if the user is allowed to send animations, games, stickers and use inline bots.
     */
    public void setCanSendOtherMessages(@Nullable Boolean canSendOtherMessages) {
        this.canSendOtherMessages = canSendOtherMessages;
    }

    /**
     *
     * @return True, if the user is allowed to add web page previews to their messages.
     */
    @Nullable
    public Boolean getCanAddWebPagePreviews() {
        return canAddWebPagePreviews;
    }

    /**
     *
     * @param canAddWebPagePreviews True, if the user is allowed to add web page previews to their messages.
     */
    public void setCanAddWebPagePreviews(@Nullable Boolean canAddWebPagePreviews) {
        this.canAddWebPagePreviews = canAddWebPagePreviews;
    }

    @Override
    public String toString() {
        return "ChatMember{" +
                "user=" + (user != null ? user.toString() : "") +
                ", status='" + status + '\'' +
                ", customTitle='" + customTitle + '\'' +
                ", untilDate=" + untilDate +
                ", canBeEdited=" + canBeEdited +
                ", canPostMessages=" + canPostMessages +
                ", canEditMessages=" + canEditMessages +
                ", canDeleteMessages=" + canDeleteMessages +
                ", canRestrictMembers=" + canRestrictMembers +
                ", canPromoteMembers=" + canPromoteMembers +
                ", canChangeInfo=" + canChangeInfo +
                ", canInviteUsers=" + canInviteUsers +
                ", canPinMessages=" + canPinMessages +
                ", isMember=" + isMember +
                ", canSendMessages=" + canSendMessages +
                ", canSendMediaMessages=" + canSendMediaMessages +
                ", canSendPolls=" + canSendPolls +
                ", canSendOtherMessages=" + canSendOtherMessages +
                ", canAddWebPagePreviews=" + canAddWebPagePreviews +
                '}';
    }
}
