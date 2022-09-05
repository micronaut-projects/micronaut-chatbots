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
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * This object represents a chat.
 */
@Serdeable
public class Chat {

    /**
     * Unique identifier for this chat. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    @NonNull
    @NotNull
    private Integer id;

    /**
     * Type of chat, can be either “private”, “group”, “supergroup” or “channel”.
     */
    @NonNull
    @NotNull
    @Pattern(regexp = "private|group|supergroup|channel")
    private String type;

    /**
     * Title, for supergroups, channels and group chats.
     */
    @Nullable
    private String title;

    /**
     * Username, for private chats, supergroups and channels if available.
     */
    @Nullable
    private String username;

    /**
     * First name of the other party in a private chat.
     */
    @JsonProperty("first_name")
    @Nullable
    private String firstName;

    /**
     * Last name of the other party in a private chat.
     */
    @JsonProperty("last_name")
    @Nullable
    private String lastName;

    /**
     * Chat photo. Returned only in getChat.
     */
    @Nullable
    @Valid
    private ChatPhoto photo;

    /**
     * Bio of the other party in a private chat. Returned only in getChat.
     */
    @Nullable
    private String bio;

    /**
     * True, if privacy settings of the other party in the private chat allows to use {@code tg://user?id=<user_id>} links only in chats with the user. Returned only in getChat.
     */
    @JsonProperty("has_private_forwards")
    @Nullable
    private Boolean hasPrivateForwards;

    /**
     * True, if the privacy settings of the other party restrict sending voice and video note messages in the private chat. Returned only in getChat.
     */
    @JsonProperty("has_restricted_voice_and_video_messages")
    @Nullable
    private Boolean hasRestrictedVoiceAndVideoMessages;

    /**
     * True, if users need to join the supergroup before they can send messages. Returned only in getChat.
     */
    @JsonProperty("join_to_send_messages")
    @Nullable
    private Boolean joinToSendMessages;

    /**
     * True, if all users directly joining the supergroup need to be approved by supergroup administrators. Returned only in getChat.
     */
    @JsonProperty("join_by_request")
    @Nullable
    private Boolean joinByRequest;

    /**
     * Description, for groups, supergroups and channel chats. Returned only in getChat.
     */
    @Nullable
    private String description;

    /**
     * Chat invite link, for groups, supergroups and channel chats. Each administrator in a chat generates their own invite links, so the bot must first generate the link using exportChatInviteLink. Returned only in getChat.
     */
    @Nullable
    @JsonProperty("invite_link")
    private String inviteLink;

    /**
     * Pinned message, for groups, supergroups and channels. Returned only in getChat.
     */
    @Nullable
    @JsonProperty("pinned_message")
    private Message pinnedMessage;

    /**
     * Default chat member permissions, for groups and supergroups. Returned only in getChat.
     */
    @Nullable
    private ChatPermissions permissions;

    /**
     * For supergroups, the minimum allowed delay between consecutive messages sent by each unpriviledged user. Returned only in getChat.
     */
    @Nullable
    @JsonProperty("slow_mode_delay")
    private Integer slowModeDelay;

    /**
     * The time after which all messages sent to the chat will be automatically deleted; in seconds. Returned only in getChat.
     */
    @Nullable
    @JsonProperty("message_auto_delete_time")
    private Integer messageAutoDeleteTime;

    /**
     * True, if messages from the chat can't be forwarded to other chats. Returned only in getChat.
     */
    @JsonProperty("has_protected_content")
    @Nullable
    private Boolean hasProtectedContent;

    /**
     * For supergroups, name of group sticker set. Returned only in getChat.
     */
    @Nullable
    @JsonProperty("sticker_set_name")
    private String stickerSetName;

    /**
     * True, if the bot can change the group sticker set. Returned only in getChat.
     */
    @Nullable
    @JsonProperty("can_set_sticker_set")
    private Boolean canSetStickerSet;

    /**
     * Unique identifier for the linked chat, i.e. the discussion group identifier for a channel and vice versa; for supergroups and channel chats. This identifier may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier. Returned only in getChat.
     */
    @Nullable
    @JsonProperty("linked_chat_id")
    private Integer linkedChatId;

    /**
     * Optional. For supergroups, the location to which the supergroup is connected. Returned only in getChat.
     */
    @Nullable
    @Valid
    private ChatLocation location;

    /**
     *
     * @return Unique identifier for this chat.
     */
    @NonNull
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id Unique identifier for this chat.
     */
    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    /**
     *
     * @return Type of chat, can be either “private”, “group”, “supergroup” or “channel”.
     */
    @NonNull
    public String getType() {
        return type;
    }

    /**
     *
     * @param type Type of chat, can be either “private”, “group”, “supergroup” or “channel”.
     */
    public void setType(@NonNull String type) {
        this.type = type;
    }

    /**
     *
     * @return Title, for supergroups, channels and group chats.
     */
    @Nullable
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title Title, for supergroups, channels and group chats.
     */
    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    /**
     *
     * @return Username, for private chats, supergroups and channels if available.
     */
    @Nullable
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username Username, for private chats, supergroups and channels if available.
     */
    public void setUsername(@Nullable String username) {
        this.username = username;
    }

    /**
     *
     * @return First name of the other party in a private chat.
     */
    @Nullable
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName First name of the other party in a private chat.
     */
    public void setFirstName(@Nullable String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return Last name of the other party in a private chat.
     */
    @Nullable
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName Last name of the other party in a private chat.
     */
    public void setLastName(@Nullable String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return Chat photo. Returned only in getChat.
     */
    @Nullable
    public ChatPhoto getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo Chat photo. Returned only in getChat.
     */
    public void setPhoto(@Nullable ChatPhoto photo) {
        this.photo = photo;
    }

    /**
     *
     * @return Description, for groups, supergroups and channel chats. Returned only in getChat.
     */
    @Nullable
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description Description, for groups, supergroups and channel chats. Returned only in getChat.
     */
    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    /**
     *
     * @return Chat invite link, for groups, supergroups and channel chats.
     */
    @Nullable
    public String getInviteLink() {
        return inviteLink;
    }

    /**
     *
     * @param inviteLink Chat invite link, for groups, supergroups and channel chats.
     */
    public void setInviteLink(@Nullable String inviteLink) {
        this.inviteLink = inviteLink;
    }

    /**
     *
     * @return Pinned message, for groups, supergroups and channels. Returned only in getChat.
     */
    @Nullable
    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    /**
     *
     * @param pinnedMessage Pinned message, for groups, supergroups and channels. Returned only in getChat.
     */
    public void setPinnedMessage(@Nullable Message pinnedMessage) {
        this.pinnedMessage = pinnedMessage;
    }

    /**
     *
     * @return Default chat member permissions, for groups and supergroups. Returned only in getChat.
     */
    @Nullable
    public ChatPermissions getPermissions() {
        return permissions;
    }

    /**
     *
     * @param permissions Default chat member permissions, for groups and supergroups. Returned only in getChat.
     */
    public void setPermissions(@Nullable ChatPermissions permissions) {
        this.permissions = permissions;
    }

    /**
     *
     * @return For supergroups, the minimum allowed delay between consecutive messages sent by each unpriviledged user.
     */
    @Nullable
    public Integer getSlowModeDelay() {
        return slowModeDelay;
    }

    /**
     *
     * @param slowModeDelay For supergroups, the minimum allowed delay between consecutive messages sent by each unpriviledged user.
     */
    public void setSlowModeDelay(@Nullable Integer slowModeDelay) {
        this.slowModeDelay = slowModeDelay;
    }

    /**
     *
     * @return For supergroups, name of group sticker set. Returned only in getChat.
     */
    @Nullable
    public String getStickerSetName() {
        return stickerSetName;
    }

    /**
     *
     * @param stickerSetName For supergroups, name of group sticker set. Returned only in getChat.
     */
    public void setStickerSetName(@Nullable String stickerSetName) {
        this.stickerSetName = stickerSetName;
    }

    /**
     *
     * @return True, if the bot can change the group sticker set. Returned only in getChat.
     */
    @Nullable
    public Boolean getCanSetStickerSet() {
        return canSetStickerSet;
    }

    /**
     *
     * @param canSetStickerSet True, if the bot can change the group sticker set. Returned only in getChat.
     */
    public void setCanSetStickerSet(@Nullable Boolean canSetStickerSet) {
        this.canSetStickerSet = canSetStickerSet;
    }

    /**
     *
     * @return Bio of the other party in a private chat.
     */
    @Nullable
    public String getBio() {
        return bio;
    }

    /**
     *
     * @param bio Bio of the other party in a private chat.
     */
    public void setBio(@Nullable String bio) {
        this.bio = bio;
    }

    /**
     *
     * @return True, if privacy settings of the other party in the private chat allows to use {@code tg://user?id=<user_id>} links only in chats with the user. Returned only in getChat.
     */
    @Nullable
    public Boolean getHasPrivateForwards() {
        return hasPrivateForwards;
    }

    /**
     *
     * @param hasPrivateForwards True, if privacy settings of the other party in the private chat allows to use {@code tg://user?id=<user_id>} links only in chats with the user. Returned only in getChat.
     */
    public void setHasPrivateForwards(@Nullable Boolean hasPrivateForwards) {
        this.hasPrivateForwards = hasPrivateForwards;
    }

    /**
     *
     * @return True, if the privacy settings of the other party restrict sending voice and video note messages in the private chat. Returned only in getChat.
     */
    @Nullable
    public Boolean getHasRestrictedVoiceAndVideoMessages() {
        return hasRestrictedVoiceAndVideoMessages;
    }

    /**
     *
     * @param hasRestrictedVoiceAndVideoMessages True, if the privacy settings of the other party restrict sending voice and video note messages in the private chat. Returned only in getChat.
     */
    public void setHasRestrictedVoiceAndVideoMessages(@Nullable Boolean hasRestrictedVoiceAndVideoMessages) {
        this.hasRestrictedVoiceAndVideoMessages = hasRestrictedVoiceAndVideoMessages;
    }

    /**
     *
     * @return True, if users need to join the supergroup before they can send messages. Returned only in getChat.
     */
    @Nullable
    public Boolean getJoinToSendMessages() {
        return joinToSendMessages;
    }

    /**
     *
     * @param joinToSendMessages True, if users need to join the supergroup before they can send messages. Returned only in getChat.
     */
    public void setJoinToSendMessages(@Nullable Boolean joinToSendMessages) {
        this.joinToSendMessages = joinToSendMessages;
    }

    /**
     *
     * @return True, if all users directly joining the supergroup need to be approved by supergroup administrators. Returned only in getChat.
     */
    @Nullable
    public Boolean getJoinByRequest() {
        return joinByRequest;
    }

    /**
     *
     * @param joinByRequest True, if all users directly joining the supergroup need to be approved by supergroup administrators. Returned only in getChat.
     */
    public void setJoinByRequest(@Nullable Boolean joinByRequest) {
        this.joinByRequest = joinByRequest;
    }

    /**
     *
     * @return The time after which all messages sent to the chat will be automatically deleted; in seconds. Returned only in getChat.
     */
    @Nullable
    public Integer getMessageAutoDeleteTime() {
        return messageAutoDeleteTime;
    }

    /**
     *
     * @param messageAutoDeleteTime The time after which all messages sent to the chat will be automatically deleted; in seconds. Returned only in getChat.
     */
    public void setMessageAutoDeleteTime(@Nullable Integer messageAutoDeleteTime) {
        this.messageAutoDeleteTime = messageAutoDeleteTime;
    }

    /**
     *
     * @return Optional. True, if messages from the chat can't be forwarded to other chats. Returned only in getChat.
     */
    @Nullable
    public Boolean getHasProtectedContent() {
        return hasProtectedContent;
    }

    /**
     *
     * @param hasProtectedContent Optional. True, if messages from the chat can't be forwarded to other chats. Returned only in getChat.
     */
    public void setHasProtectedContent(@Nullable Boolean hasProtectedContent) {
        this.hasProtectedContent = hasProtectedContent;
    }

    /**
     *
     * @return Unique identifier for the linked chat, i.e. the discussion group identifier for a channel and vice versa; for supergroups and channel chats. This identifier may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier. Returned only in getChat.
     */
    @Nullable
    public Integer getLinkedChatId() {
        return linkedChatId;
    }

    /**
     *
     * @param linkedChatId Unique identifier for the linked chat, i.e. the discussion group identifier for a channel and vice versa; for supergroups and channel chats. This identifier may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier. Returned only in getChat.
     */
    public void setLinkedChatId(@Nullable Integer linkedChatId) {
        this.linkedChatId = linkedChatId;
    }

    /**
     *
     * @return Optional. For supergroups, the location to which the supergroup is connected. Returned only in getChat.
     */
    @Nullable
    public ChatLocation getLocation() {
        return location;
    }

    /**
     *
     * @param location Optional. For supergroups, the location to which the supergroup is connected. Returned only in getChat.
     */
    public void setLocation(@Nullable ChatLocation location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photo=" + (photo != null ? photo.toString() : "") +
                ", description='" + description + '\'' +
                ", inviteLink='" + inviteLink + '\'' +
                ", pinnedMessage=" + (pinnedMessage != null ? pinnedMessage.toString() : "") +
                ", permissions=" + (permissions != null ? permissions.toString() : "") +
                ", slowModeDelay=" + slowModeDelay +
                ", stickerSetName='" + stickerSetName + '\'' +
                ", canSetStickerSet=" + canSetStickerSet +
                '}';
    }
}

