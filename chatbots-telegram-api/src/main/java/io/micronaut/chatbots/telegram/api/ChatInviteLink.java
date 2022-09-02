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
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Represents an invite link for a chat.
 * <a href="https://core.telegram.org/bots/api#chatinvitelink">ChatInviteLink</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class ChatInviteLink {

    /**
     * The invite link. If the link was created by another chat administrator, then the second part of the link will be replaced with "...";
     */
    @JsonProperty("invite_link")
    private String inviteLink;

    /**
     * Creator of the link.
     */
    @NotNull
    @Valid
    private User creator;

    /**
     * True, if users joining the chat via the link need to be approved by chat administrators.
     */
    @JsonProperty("creates_join_request")
    private Boolean createsJoinRequest;

    /**
     * True, if the link is primary.
     */
    @JsonProperty("is_primary")
    @NotNull
    private Boolean primary;

    /**
     * True, if the link is revoked.
     */
    @JsonProperty("is_revoked")
    @NotNull
    private Boolean revoked;

    /**
     * Invite link name.
     */
    @Nullable
    private String name;

    /**
     * Point in time (Unix timestamp) when the link will expire or has been expired.
     */
    @Nullable
    @JsonProperty("expire_date")
    private Integer expireDate;

    /**
     * The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999.
     */
    @Nullable
    @JsonProperty("member_limit")
    private Integer memberLimit;

    /**
     * Number of pending join requests created using this link.
     */
    @Nullable
    @JsonProperty("pending_join_request_count")
    private Integer pendingJoinRequestCount;

    /**
     *
     * @return The invite link. If the link was created by another chat administrator, then the second part of the link will be replaced with "...";
     */
    public String getInviteLink() {
        return inviteLink;
    }

    /**
     *
     * @param inviteLink The invite link. If the link was created by another chat administrator, then the second part of the link will be replaced with "...";
     */
    public void setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
    }

    /**
     *
     * @return Creator of the link.
     */
    public User getCreator() {
        return creator;
    }

    /**
     *
     * @param creator Creator of the link.
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     *
     * @return True, if users joining the chat via the link need to be approved by chat administrators.
     */
    public Boolean getCreatesJoinRequest() {
        return createsJoinRequest;
    }

    /**
     *
     * @param createsJoinRequest True, if users joining the chat via the link need to be approved by chat administrators.
     */
    public void setCreatesJoinRequest(Boolean createsJoinRequest) {
        this.createsJoinRequest = createsJoinRequest;
    }

    /**
     *
     * @return True, if the link is primary.
     */
    public Boolean isPrimary() {
        return primary;
    }

    /**
     *
     * @param primary True, if the link is primary.
     */
    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    /**
     *
     * @return True, if the link is revoked.
     */
    public Boolean isRevoked() {
        return revoked;
    }

    /**
     *
     * @param revoked True, if the link is revoked.
     */
    public void setRevoked(Boolean revoked) {
        this.revoked = revoked;
    }

    /**
     *
     * @return Invite link name
     */
    @Nullable
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Invite link name
     */
    public void setName(@Nullable String name) {
        this.name = name;
    }

    /**
     *
     * @return Point in time (Unix timestamp) when the link will expire or has been expired.
     */
    @Nullable
    public Integer getExpireDate() {
        return expireDate;
    }

    /**
     *
     * @param expireDate Point in time (Unix timestamp) when the link will expire or has been expired.
     */
    public void setExpireDate(@Nullable Integer expireDate) {
        this.expireDate = expireDate;
    }

    /**
     *
     * @return The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999.
     */
    @Nullable
    public Integer getMemberLimit() {
        return memberLimit;
    }

    /**
     *
     * @param memberLimit The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999.
     */
    public void setMemberLimit(@Nullable Integer memberLimit) {
        this.memberLimit = memberLimit;
    }

    /**
     *
     * @return Number of pending join requests created using this link.
     */
    @Nullable
    public Integer getPendingJoinRequestCount() {
        return pendingJoinRequestCount;
    }

    /**
     *
     * @param pendingJoinRequestCount Number of pending join requests created using this link.
     */
    public void setPendingJoinRequestCount(@Nullable Integer pendingJoinRequestCount) {
        this.pendingJoinRequestCount = pendingJoinRequestCount;
    }
}
