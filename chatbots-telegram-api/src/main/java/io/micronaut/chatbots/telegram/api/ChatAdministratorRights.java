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
 * Represents the rights of an administrator in a chat.
 * <a href="https://core.telegram.org/bots/api#chatadministratorrights">ChatAdministratorRights</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class ChatAdministratorRights {

    /**
     * True, if the user's presence in the chat is hidden.
     */
    @NonNull
    @NotNull
    @JsonProperty("is_anonymous")
    private Boolean anonymous;

    /**
     * True, if the administrator can access the chat event log, chat statistics, message statistics in channels, see channel members, see anonymous administrators in supergroups and ignore slow mode. Implied by any other administrator privilege.
     */
    @NonNull
    @NotNull
    @JsonProperty("can_manage_chat")
    private Boolean canManageChat;

    /**
     * True, if the administrator can delete messages of other users.
     */
    @NonNull
    @NotNull
    @JsonProperty("can_delete_messages")
    private Boolean canDeleteMessages;

    /**
     * True, if the administrator can manage video chats.
     */
    @NonNull
    @NotNull
    @JsonProperty("can_manage_video_chats")
    private Boolean canManageVideoChats;

    /**
     * True, if the administrator can restrict, ban or unban chat members.
     */
    @NonNull
    @NotNull
    @JsonProperty("can_restrict_members")
    private Boolean canRestrictMembers;

    /**
     * True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user).
     */
    @NonNull
    @NotNull
    @JsonProperty("can_promote_members")
    private Boolean canPromoteMembers;

    /**
     * True, if the user is allowed to change the chat title, photo and other settings.
     */
    @NonNull
    @NotNull
    @JsonProperty("can_change_info")
    private Boolean canChangeInfo;

    /**
     * True, if the user is allowed to invite new users to the chat.
     */
    @NonNull
    @NotNull
    @JsonProperty("can_invite_users")
    private Boolean canInviteUsers;

    /**
     * True, if the administrator can post in the channel; channels only.
     */
    @Nullable
    @JsonProperty("can_post_messages")
    private Boolean canPostMessages;

    /**
     * True, if the administrator can edit messages of other users and can pin messages; channels only.
     */
    @Nullable
    @JsonProperty("can_edit_messages")
    private Boolean canEditMessages;

    /**
     * True, if the user is allowed to pin messages; groups and supergroups only.
     */
    @Nullable
    @JsonProperty("can_pin_messages")
    private Boolean canPinMessages;

    /**
     *
     * @return True, if the user's presence in the chat is hidden
     */
    @NonNull
    public Boolean isAnonymous() {
        return anonymous;
    }

    /**
     *
     * @param anonymous True, if the user's presence in the chat is hidden
     */
    public void setAnonymous(@NonNull Boolean anonymous) {
        this.anonymous = anonymous;
    }

    /**
     *
     * @return True, if the administrator can access the chat event log, chat statistics, message statistics in channels, see channel members, see anonymous administrators in supergroups and ignore slow mode. Implied by any other administrator privilege
     */
    @NonNull
    public Boolean getCanManageChat() {
        return canManageChat;
    }

    /**
     *
     * @param canManageChat True, if the administrator can access the chat event log, chat statistics, message statistics in channels, see channel members, see anonymous administrators in supergroups and ignore slow mode. Implied by any other administrator privilege
     */
    public void setCanManageChat(@NonNull Boolean canManageChat) {
        this.canManageChat = canManageChat;
    }

    /**
     *
     * @return True, if the administrator can delete messages of other users
     */
    @NonNull
    public Boolean getCanDeleteMessages() {
        return canDeleteMessages;
    }

    /**
     *
     * @param canDeleteMessages True, if the administrator can delete messages of other users
     */
    public void setCanDeleteMessages(@NonNull Boolean canDeleteMessages) {
        this.canDeleteMessages = canDeleteMessages;
    }

    /**
     *
     * @return True, if the administrator can manage video chats
     */
    @NonNull
    public Boolean getCanManageVideoChats() {
        return canManageVideoChats;
    }

    /**
     *
     * @param canManageVideoChats True, if the administrator can manage video chats
     */
    public void setCanManageVideoChats(@NonNull Boolean canManageVideoChats) {
        this.canManageVideoChats = canManageVideoChats;
    }

    /**
     *
     * @return True, if the administrator can restrict, ban or unban chat members
     */
    @NonNull
    public Boolean getCanRestrictMembers() {
        return canRestrictMembers;
    }

    /**
     *
     * @param canRestrictMembers True, if the administrator can restrict, ban or unban chat members
     */
    public void setCanRestrictMembers(@NonNull Boolean canRestrictMembers) {
        this.canRestrictMembers = canRestrictMembers;
    }

    /**
     *
     * @return True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user)
     */
    @NonNull
    public Boolean getCanPromoteMembers() {
        return canPromoteMembers;
    }

    /**
     *
     * @param canPromoteMembers True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user)
     */
    public void setCanPromoteMembers(@NonNull Boolean canPromoteMembers) {
        this.canPromoteMembers = canPromoteMembers;
    }

    /**
     *
     * @return True, if the user is allowed to change the chat title, photo and other settings
     */
    @NonNull
    public Boolean getCanChangeInfo() {
        return canChangeInfo;
    }

    /**
     *
     * @param canChangeInfo True, if the user is allowed to change the chat title, photo and other settings
     */
    public void setCanChangeInfo(@NonNull Boolean canChangeInfo) {
        this.canChangeInfo = canChangeInfo;
    }

    /**
     *
     * @return True, if the user is allowed to invite new users to the chat
     */
    @NonNull
    public Boolean getCanInviteUsers() {
        return canInviteUsers;
    }

    /**
     *
     * @param canInviteUsers True, if the user is allowed to invite new users to the chat
     */
    public void setCanInviteUsers(@NonNull Boolean canInviteUsers) {
        this.canInviteUsers = canInviteUsers;
    }

    /**
     *
     * @return Optional. True, if the administrator can post in the channel; channels only
     */
    @Nullable
    public Boolean getCanPostMessages() {
        return canPostMessages;
    }

    /**
     *
     * @param canPostMessages Optional. True, if the administrator can post in the channel; channels only
     */
    public void setCanPostMessages(@Nullable Boolean canPostMessages) {
        this.canPostMessages = canPostMessages;
    }

    /**
     *
     * @return Optional. True, if the administrator can edit messages of other users and can pin messages; channels only
     */
    @Nullable
    public Boolean getCanEditMessages() {
        return canEditMessages;
    }

    /**
     *
     * @param canEditMessages True, if the administrator can edit messages of other users and can pin messages; channels only
     */
    public void setCanEditMessages(@Nullable Boolean canEditMessages) {
        this.canEditMessages = canEditMessages;
    }

    /**
     *
     * @return Optional. True, if the user is allowed to pin messages; groups and supergroups only
     */
    @Nullable
    public Boolean getCanPinMessages() {
        return canPinMessages;
    }

    /**
     *
     * @param canPinMessages Optional. True, if the user is allowed to pin messages; groups and supergroups only
     */
    public void setCanPinMessages(@Nullable Boolean canPinMessages) {
        this.canPinMessages = canPinMessages;
    }
}
