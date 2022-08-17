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
import java.util.List;
import java.util.stream.Collectors;

/**
 * This object represents a message.
 * @see <a href="https://core.telegram.org/bots/api#message">Message</a>
 */
@Serdeable
public class Message {

    /**
     * Unique message identifier inside this chat.
     */
    @JsonProperty("message_id")
    @NonNull
    @NotNull
    private Integer messageId;

    /**
     * Sender, empty for messages sent to channels.
     */
    @Nullable
    @Valid
    @NotNull
    private User from;

    /**
     * Optional. Sender of the message, sent on behalf of a chat. For example, the channel itself for channel posts, the supergroup itself for messages from anonymous group administrators, the linked channel for messages automatically forwarded to the discussion group. For backward compatibility, the field from contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat.
     */
    @JsonProperty("sender_chat")
    @Nullable
    @Valid
    private Chat senderChat;

    /**
     * Date the message was sent in Unix time.
     */
    @NonNull
    @NotNull
    private Integer date;

    /**
     * Conversation the message belongs to.
     */
    @NonNull
    @Valid
    @NotNull
    private Chat chat;

    /**
     * For forwarded messages, sender of the original message.
     */
    @Nullable
    @Valid
    @JsonProperty("forward_from")
    private User forwardFrom;

    /**
     * For messages forwarded from channels, information about the original channel.
     */
    @Nullable
    @Valid
    @JsonProperty("forward_from_chat")
    private Chat forwardFromChat;

    /**
     * For messages forwarded from channels, identifier of the original message in the channel.
     */
    @Nullable
    @JsonProperty("forward_from_message_id")
    private Integer forwardFromMessageId;

    /**
     * For messages forwarded from channels, signature of the post author if present.
     */
    @Nullable
    @JsonProperty("forward_signature")
    private String forwardSignature;

    /**
     * Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages.
     */
    @Nullable
    @JsonProperty("forward_sender_name")
    private String forwardSenderName;

    /**
     * For forwarded messages, date the original message was sent in Unix time.
     */
    @Nullable
    @JsonProperty("forward_date")
    private Integer forwardDate;

    /**
     * True, if the message is a channel post that was automatically forwarded to the connected discussion group.
     */
    @JsonProperty("is_automatic_forward")
    @Nullable
    private Boolean isAutomaticForward;

    /**
     * For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
     */
    @Nullable
    @JsonProperty("reply_to_message")
    private Message replyToMessage;

    /**
     * Bot through which the message was sent.
     */
    @JsonProperty("via_bot")
    @Nullable
    @Valid
    private User viaBot;

    /**
     * Date the message was last edited in Unix time.
     */
    @Nullable
    @JsonProperty("edit_date")
    private Integer editDate;

    /**
     * True, if the message can't be forwarded.
     */
    @JsonProperty("has_protected_content")
    @Nullable
    private Boolean hasProtectedContent;

    /**
     * The unique identifier of a media message group this message belongs to.
     */
    @Nullable
    @JsonProperty("media_group_id")
    private String mediaGroupId;

    /**
     * Signature of the post author for messages in channels.
     */
    @JsonProperty("author_signature")
    @Nullable
    private String authorSignature;

    /**
     * For text messages, the actual UTF-8 text of the message, 0-4096 characters.
     */
    @Nullable
    private String text;

    /**
     * For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text.
     */
    @Nullable
    private List<MessageEntity> entities;

    /**
     * Message is an animation, information about the animation. For backward compatibility, when this field is set, the document field will also be set.
     */
    @Nullable
    private Animation animation;

    /**
     * Message is an audio file, information about the file.
     */
    @Nullable
    private Audio audio;

    /**
     * Message is a general file, information about the file.
     */
    @Nullable
    private Document document;

    /**
     * Message is a photo, available sizes of the photo.
     */
    @Nullable
    private List<PhotoSize> photo;

    /**
     * Message is a sticker, information about the sticker.
     */
    @Nullable
    private Sticker sticker;

    /**
     * Message is a video, information about the video.
     */
    @Nullable
    private Video video;

    /**
     * Message is a video note, information about the video message.
     */
    @Nullable
    @JsonProperty("video_note")
    private VideoNote videoNote;

    /**
     * Message is a voice message, information about the file.
     */
    @Nullable
    private Voice voice;

    /**
     * Caption for the animation, audio, document, photo, video or voice, 0-1024 characters.
     */
    @Nullable
    private String caption;

    /**
     * For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption.
     */
    @Nullable
    @JsonProperty("caption_entities")
    private List<MessageEntity> captionEntities;

    /**
     * Message is a shared contact, information about the contact.
     */
    @Nullable
    private Contact contact;

    /**
     * Message is a dice with random value.
     */
    @Nullable
    @Valid
    private Dice dice;

    /**
     * Message is a game, information about the game.
     */
    @Nullable
    private Game game;

    /**
     * Message is a native poll, information about the poll.
     */
    @Nullable
    private Poll poll;

    /**
     * Message is a venue, information about the venue.
     */
    @Nullable
    private Venue venue;

    /**
     * Message is a shared location, information about the location.
     */
    @Nullable
    private Location location;

    /**
     * New members that were added to the group or supergroup and information about them (the bot itself may be one of these members).
     */
    @Nullable
    @JsonProperty("new_chat_members")
    private List<User> newChatMembers;

    /**
     * A member was removed from the group, information about them (this member may be the bot itself).
     */
    @Nullable
    @JsonProperty("left_chat_member")
    private User leftChatMember;

    /**
     * A chat title was changed to this value.
     */
    @JsonProperty("new_chat_title")
    @Nullable
    private String newChatTitle;

    /**
     *  A chat photo was change to this value.
     */
    @Nullable
    @JsonProperty("new_chat_photo")
    private List<PhotoSize> newChatPhoto;

    /**
     * Service message: the chat photo was deleted.
     */
    @Nullable
    @JsonProperty("delete_chat_photo")
    private Boolean deleteChatPhoto;

    /**
     * Service message: the group has been created.
     */
    @Nullable
    @JsonProperty("group_chat_created")
    private Boolean groupChatCreated;

    /**
     * Service message: the supergroup has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
     */
    @Nullable
    @JsonProperty("supergroup_chat_created")
    private Boolean supergroupChatCreated;

    /**
     * Service message: the channel has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel.
     */
    @Nullable
    @JsonProperty("channel_chat_created")
    private Boolean channelChatCreated;

    /**
     * Service message: auto-delete timer settings changed in the chat.
     */
    @JsonProperty("message_auto_delete_timer_changed")
    @Nullable
    @Valid
    private MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged;

    /**
     * The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    @JsonProperty("migrate_to_chat_id")
    @Nullable
    private Integer migrateToChatId;

    /**
     * The supergroup has been migrated from a group with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    @Nullable
    @JsonProperty("migrate_from_chat_id")
    private Integer migrateFromChatId;

    /**
     * Specified message was pinned. Note that the Message object in this field will not contain further reply_to_message fields even if it is itself a reply.
     */
    @Nullable
    private Message pinnedMessage;

    /**
     *  Message is an invoice for a payment, information about the invoice.
     */
    @Nullable
    private Invoice invoice;

    /**
     * Message is a service message about a successful payment, information about the payment.
     */
    @Nullable
    @JsonProperty("successful_payment")
    private SuccessfulPayment successfulPayment;

    /**
     * The domain name of the website on which the user has logged in.
     */
    @Nullable
    @JsonProperty("connected_website")
    private String connectedWebsite;

    /**
     * Telegram Passport data.
     */
    @Nullable
    private PassportData passportData;

    /**
     * Service message: video chat scheduled.
     */
    @JsonProperty("video_chat_scheduled")
    @Nullable
    private VideoChatScheduled videoChatScheduled;

    /**
     * Service message: video chat started.
     */
    @JsonProperty("video_chat_started")
    @Nullable
    private VideoChatStarted videoChatStarted;

    /**
     * Service message: video chat ended.
     */
    @JsonProperty("video_chat_ended")
    @Nullable
    private VideoChatEnded videoChatEnded;

    /**
     * Service message: new participants invited to a video chat.
     */
    @JsonProperty("video_chat_participants_invited")
    @Nullable
    private VideoChatParticipantsInvited videoChatParticipantsInvited;

    /**
     * Service message: data sent by a Web App.
     */
    @JsonProperty("web_app_data")
    @Nullable
    private WebAppData webAppData;

    /**
     * Inline keyboard attached to the message. login_url buttons are represented as ordinary url buttons.
     */
    @Nullable
    @JsonProperty("reply_markup")
    private InlineKeyboardMarkup replyMarkup;

    public Message() {

    }

    /**
     *
     * @return Unique message identifier inside this chat.
     */
    @NonNull
    public Integer getMessageId() {
        return messageId;
    }

    /**
     *
     * @param messageId Unique message identifier inside this chat.
     */
    public void setMessageId(@NonNull Integer messageId) {
        this.messageId = messageId;
    }

    /**
     *
     * @return Sender, empty for messages sent to channels.
     */
    @Nullable
    public User getFrom() {
        return from;
    }

    /**
     *
     * @param from Sender, empty for messages sent to channels.
     */
    public void setFrom(@Nullable User from) {
        this.from = from;
    }

    /**
     *
     * @return Date the message was sent in Unix time.
     */
    @NonNull
    public Integer getDate() {
        return date;
    }

    /**
     *
     * @param date Date the message was sent in Unix time.
     */
    public void setDate(@NonNull Integer date) {
        this.date = date;
    }

    /**
     *
     * @return Conversation the message belongs to.
     */
    @NonNull
    public Chat getChat() {
        return chat;
    }

    /**
     *
     * @param chat Conversation the message belongs to.
     */
    public void setChat(@NonNull Chat chat) {
        this.chat = chat;
    }

    /**
     *
     * @return For forwarded messages, sender of the original message.
     */
    @Nullable
    public User getForwardFrom() {
        return forwardFrom;
    }

    /**
     *
     * @param forwardFrom For forwarded messages, sender of the original message.
     */
    public void setForwardFrom(@Nullable User forwardFrom) {
        this.forwardFrom = forwardFrom;
    }

    /**
     *
     * @return For messages forwarded from channels, information about the original channel.
     */
    @Nullable
    public Chat getForwardFromChat() {
        return forwardFromChat;
    }

    /**
     *
     * @param forwardFromChat For messages forwarded from channels, information about the original channel.
     */
    public void setForwardFromChat(@Nullable Chat forwardFromChat) {
        this.forwardFromChat = forwardFromChat;
    }

    /**
     *
     * @return For messages forwarded from channels, identifier of the original message in the channel.
     */
    @Nullable
    public Integer getForwardFromMessageId() {
        return forwardFromMessageId;
    }

    /**
     *
     * @param forwardFromMessageId For messages forwarded from channels, identifier of the original message in the channel.
     */
    public void setForwardFromMessageId(@Nullable Integer forwardFromMessageId) {
        this.forwardFromMessageId = forwardFromMessageId;
    }

    /**
     *
     * @return For messages forwarded from channels, signature of the post author if present.
     */
    @Nullable
    public String getForwardSignature() {
        return forwardSignature;
    }

    /**
     *
     * @param forwardSignature For messages forwarded from channels, signature of the post author if present.
     */
    public void setForwardSignature(@Nullable String forwardSignature) {
        this.forwardSignature = forwardSignature;
    }

    /**
     *
     * @return Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages.
     */
    @Nullable
    public String getForwardSenderName() {
        return forwardSenderName;
    }

    /**
     *
     * @param forwardSenderName Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages.
     */
    public void setForwardSenderName(@Nullable String forwardSenderName) {
        this.forwardSenderName = forwardSenderName;
    }

    /**
     *
     * @return For forwarded messages, date the original message was sent in Unix time
     */
    @Nullable
    public Integer getForwardDate() {
        return forwardDate;
    }

    /**
     *
     * @param forwardDate For forwarded messages, date the original message was sent in Unix time
     */
    public void setForwardDate(@Nullable Integer forwardDate) {
        this.forwardDate = forwardDate;
    }

    /**
     *
     * @return For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
     */
    @Nullable
    public Message getReplyToMessage() {
        return replyToMessage;
    }

    /**
     *
     * @param replyToMessage For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
     */
    public void setReplyToMessage(@Nullable Message replyToMessage) {
        this.replyToMessage = replyToMessage;
    }

    /**
     *
     * @return Date the message was last edited in Unix time.
     */
    @Nullable
    public Integer getEditDate() {
        return editDate;
    }

    /**
     *
     * @param editDate Date the message was last edited in Unix time.
     */
    public void setEditDate(@Nullable Integer editDate) {
        this.editDate = editDate;
    }

    /**
     *
     * @return The unique identifier of a media message group this message belongs to.
     */
    @Nullable
    public String getMediaGroupId() {
        return mediaGroupId;
    }

    /**
     *
     * @param mediaGroupId The unique identifier of a media message group this message belongs to.
     */
    public void setMediaGroupId(@Nullable String mediaGroupId) {
        this.mediaGroupId = mediaGroupId;
    }

    /**
     *
     * @return Signature of the post author for messages in channels.
     */
    @Nullable
    public String getAuthorSignature() {
        return authorSignature;
    }

    /**
     *
     * @param authorSignature Signature of the post author for messages in channels.
     */
    public void setAuthorSignature(@Nullable String authorSignature) {
        this.authorSignature = authorSignature;
    }

    /**
     *
     * @return For text messages, the actual UTF-8 text of the message, 0-4096 characters.
     */
    @Nullable
    public String getText() {
        return text;
    }

    /**
     *
     * @param text For text messages, the actual UTF-8 text of the message, 0-4096 characters.
     */
    public void setText(@Nullable String text) {
        this.text = text;
    }

    /**
     *
     * @return For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text.
     */
    @Nullable
    public List<MessageEntity> getEntities() {
        return entities;
    }

    /**
     *
     * @param entities For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text.
     */
    public void setEntities(@Nullable List<MessageEntity> entities) {
        this.entities = entities;
    }

    /**
     *
     * @return For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption.
     */
    @Nullable
    public List<MessageEntity> getCaptionEntities() {
        return captionEntities;
    }

    /**
     *
     * @param captionEntities For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption.
     */
    public void setCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
    }

    /**
     *
     * @return Message is an audio file, information about the file.
     */
    @Nullable
    public Audio getAudio() {
        return audio;
    }

    /**
     *
     * @param audio Message is an audio file, information about the file.
     */
    public void setAudio(@Nullable Audio audio) {
        this.audio = audio;
    }

    /**
     *
     * @return Message is a general file, information about the file.
     */
    @Nullable
    public Document getDocument() {
        return document;
    }

    /**
     *
     * @param document Message is a general file, information about the file.
     */
    public void setDocument(@Nullable Document document) {
        this.document = document;
    }

    /**
     *
     * @return Message is an animation, information about the animation. For backward compatibility, when this field is set, the document field will also be set.
     */
    @Nullable
    public Animation getAnimation() {
        return animation;
    }

    /**
     *
     * @param animation Message is an animation, information about the animation. For backward compatibility, when this field is set, the document field will also be set.
     */
    public void setAnimation(@Nullable Animation animation) {
        this.animation = animation;
    }

    /**
     *
     * @return Message is a game, information about the game.
     */
    @Nullable
    public Game getGame() {
        return game;
    }

    /**
     *
     * @param game Message is a game, information about the game.
     */
    public void setGame(@Nullable Game game) {
        this.game = game;
    }

    /**
     *
     * @return Message is a photo, available sizes of the photo
     */
    @Nullable
    public List<PhotoSize> getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo Message is a photo, available sizes of the photo
     */
    public void setPhoto(@Nullable List<PhotoSize> photo) {
        this.photo = photo;
    }

    /**
     *
     * @return Message is a sticker, information about the sticker.
     */
    @Nullable
    public Sticker getSticker() {
        return sticker;
    }

    /**
     *
     * @param sticker Message is a sticker, information about the sticker.
     */
    public void setSticker(@Nullable Sticker sticker) {
        this.sticker = sticker;
    }

    /**
     *
     * @return Message is a video, information about the video.
     */
    @Nullable
    public Video getVideo() {
        return video;
    }

    /**
     *
     * @param video Message is a video, information about the video.
     */
    public void setVideo(@Nullable Video video) {
        this.video = video;
    }

    /**
     *
     * @return Message is a voice message, information about the file.
     */
    @Nullable
    public Voice getVoice() {
        return voice;
    }

    /**
     *
     * @param voice Message is a voice message, information about the file.
     */
    public void setVoice(@Nullable Voice voice) {
        this.voice = voice;
    }

    /**
     *
     * @return Message is a video note, information about the video message.
     */
    @Nullable
    public VideoNote getVideoNote() {
        return videoNote;
    }

    /**
     *
     * @param videoNote Message is a video note, information about the video message.
     */
    public void setVideoNote(@Nullable VideoNote videoNote) {
        this.videoNote = videoNote;
    }

    /**
     *
     * @return Caption for the animation, audio, document, photo, video or voice, 0-1024 characters.
     */
    @Nullable
    public String getCaption() {
        return caption;
    }

    /**
     *
     * @param caption Caption for the animation, audio, document, photo, video or voice, 0-1024 characters.
     */
    public void setCaption(@Nullable String caption) {
        this.caption = caption;
    }

    /**
     *
     * @return Message is a shared contact, information about the contact.
     */
    @Nullable
    public Contact getContact() {
        return contact;
    }

    /**
     *
     * @param contact Message is a shared contact, information about the contact.
     */
    public void setContact(@Nullable Contact contact) {
        this.contact = contact;
    }

    /**
     *
     * @return Message is a shared location, information about the location.
     */
    @Nullable
    public Location getLocation() {
        return location;
    }

    /**
     *
     * @param location Message is a shared location, information about the location.
     */
    public void setLocation(@Nullable Location location) {
        this.location = location;
    }

    /**
     *
     * @return Message is a venue, information about the venue.
     */
    @Nullable
    public Venue getVenue() {
        return venue;
    }

    /**
     *
     * @param venue Message is a venue, information about the venue.
     */
    public void setVenue(@Nullable Venue venue) {
        this.venue = venue;
    }

    /**
     *
     * @return Message is a native poll, information about the poll.
     */
    @Nullable
    public Poll getPoll() {
        return poll;
    }

    /**
     *
     * @param poll Message is a native poll, information about the poll.
     */
    public void setPoll(@Nullable Poll poll) {
        this.poll = poll;
    }

    /**
     *
     * @return New members that were added to the group or supergroup and information about them (the bot itself may be one of these members).
     */
    @Nullable
    public List<User> getNewChatMembers() {
        return newChatMembers;
    }

    /**
     *
     * @param newChatMembers New members that were added to the group or supergroup and information about them (the bot itself may be one of these members).
     */
    public void setNewChatMembers(@Nullable List<User> newChatMembers) {
        this.newChatMembers = newChatMembers;
    }

    /**
     *
     * @return A member was removed from the group, information about them (this member may be the bot itself).
     */
    @Nullable
    public User getLeftChatMember() {
        return leftChatMember;
    }

    /**
     *
     * @param leftChatMember A member was removed from the group, information about them (this member may be the bot itself).
     */
    public void setLeftChatMember(@Nullable User leftChatMember) {
        this.leftChatMember = leftChatMember;
    }

    /**
     *
     * @return A chat title was changed to this value.
     */
    @Nullable
    public String getNewChatTitle() {
        return newChatTitle;
    }

    /**
     *
     * @param newChatTitle A chat title was changed to this value.
     */
    public void setNewChatTitle(@Nullable String newChatTitle) {
        this.newChatTitle = newChatTitle;
    }

    /**
     *
     * @return A chat photo was change to this value.
     */
    @Nullable
    public List<PhotoSize> getNewChatPhoto() {
        return newChatPhoto;
    }

    /**
     *
     * @param newChatPhoto A chat photo was change to this value.
     */
    public void setNewChatPhoto(@Nullable List<PhotoSize> newChatPhoto) {
        this.newChatPhoto = newChatPhoto;
    }

    /**
     *
     * @return Service message: the chat photo was deleted.
     */
    @Nullable
    public Boolean getDeleteChatPhoto() {
        return deleteChatPhoto;
    }

    /**
     *
     * @param deleteChatPhoto Service message: the chat photo was deleted.
     */
    public void setDeleteChatPhoto(@Nullable Boolean deleteChatPhoto) {
        this.deleteChatPhoto = deleteChatPhoto;
    }

    /**
     *
     * @return Service message: the group has been created.
     */
    @Nullable
    public Boolean getGroupChatCreated() {
        return groupChatCreated;
    }

    /**
     *
     * @param groupChatCreated Service message: the group has been created.
     */
    public void setGroupChatCreated(@Nullable Boolean groupChatCreated) {
        this.groupChatCreated = groupChatCreated;
    }

    /**
     *
     * @return if the supergroup has been created.
     */
    @Nullable
    public Boolean getSupergroupChatCreated() {
        return supergroupChatCreated;
    }

    /**
     *
     * @param supergroupChatCreated if the supergroup has been created.
     */
    public void setSupergroupChatCreated(@Nullable Boolean supergroupChatCreated) {
        this.supergroupChatCreated = supergroupChatCreated;
    }

    /**
     *
     * @return the channel has been created
     */
    @Nullable
    public Boolean getChannelChatCreated() {
        return channelChatCreated;
    }

    /**
     *
     * @param channelChatCreated the channel has been created
     */
    public void setChannelChatCreated(@Nullable Boolean channelChatCreated) {
        this.channelChatCreated = channelChatCreated;
    }

    /**
     *
     * @return The group has been migrated to a supergroup with the specified identifier.
     */
    @Nullable
    public Integer getMigrateToChatId() {
        return migrateToChatId;
    }

    /**
     *
     * @param migrateToChatId The group has been migrated to a supergroup with the specified identifier.
     */
    public void setMigrateToChatId(@Nullable Integer migrateToChatId) {
        this.migrateToChatId = migrateToChatId;
    }

    /**
     *
     * @return The supergroup has been migrated from a group with the specified identifier.
     */
    @Nullable
    public Integer getMigrateFromChatId() {
        return migrateFromChatId;
    }

    /**
     *
     * @param migrateFromChatId The supergroup has been migrated from a group with the specified identifier.
     */
    public void setMigrateFromChatId(@Nullable Integer migrateFromChatId) {
        this.migrateFromChatId = migrateFromChatId;
    }

    /**
     *
     * @return Specified message was pinned.
     */
    @Nullable
    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    /**
     *
     * @param pinnedMessage Specified message was pinned.
     */
    public void setPinnedMessage(@Nullable Message pinnedMessage) {
        this.pinnedMessage = pinnedMessage;
    }

    /**
     *
     * @return Message is an invoice for a payment, information about the invoice.
     */
    @Nullable
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     *
     * @param invoice Message is an invoice for a payment, information about the invoice.
     */
    public void setInvoice(@Nullable Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     *
     * @return Message is a service message about a successful payment, information about the payment.
     */
    @Nullable
    public SuccessfulPayment getSuccessfulPayment() {
        return successfulPayment;
    }

    /**
     *
     * @param successfulPayment Message is a service message about a successful payment, information about the payment.
     */
    public void setSuccessfulPayment(@Nullable SuccessfulPayment successfulPayment) {
        this.successfulPayment = successfulPayment;
    }

    /**
     *
     * @return The domain name of the website on which the user has logged in.
     */
    @Nullable
    public String getConnectedWebsite() {
        return connectedWebsite;
    }

    /**
     *
     * @param connectedWebsite The domain name of the website on which the user has logged in.
     */
    public void setConnectedWebsite(@Nullable String connectedWebsite) {
        this.connectedWebsite = connectedWebsite;
    }

    /**
     *
     * @return Telegram Passport data.
     */
    @Nullable
    public PassportData getPassportData() {
        return passportData;
    }

    /**
     *
     * @param passportData Telegram Passport data.
     */
    public void setPassportData(@Nullable PassportData passportData) {
        this.passportData = passportData;
    }

    /**
     *
     * @return Inline keyboard attached to the message.
     */
    @Nullable
    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    /**
     *
     * @param replyMarkup Inline keyboard attached to the message.
     */
    public void setReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    /**
     *
     * @return Optional. Sender of the message, sent on behalf of a chat. For example, the channel itself for channel posts, the supergroup itself for messages from anonymous group administrators, the linked channel for messages automatically forwarded to the discussion group. For backward compatibility, the field from contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat.
     */
    @Nullable
    public Chat getSenderChat() {
        return senderChat;
    }

    /**
     *
     * @param senderChat Optional. Sender of the message, sent on behalf of a chat. For example, the channel itself for channel posts, the supergroup itself for messages from anonymous group administrators, the linked channel for messages automatically forwarded to the discussion group. For backward compatibility, the field from contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat.
     */
    public void setSenderChat(@Nullable Chat senderChat) {
        this.senderChat = senderChat;
    }

    /**
     *
     * @return True, if the message is a channel post that was automatically forwarded to the connected discussion group
     */
    @Nullable
    public Boolean getAutomaticForward() {
        return isAutomaticForward;
    }

    /**
     *
     * @param automaticForward True, if the message is a channel post that was automatically forwarded to the connected discussion group
     */
    public void setAutomaticForward(@Nullable Boolean automaticForward) {
        isAutomaticForward = automaticForward;
    }

    /**
     *
     * @return Bot through which the message was sent.
     */
    @Nullable
    public User getViaBot() {
        return viaBot;
    }

    /**
     *
     * @param viaBot Bot through which the message was sent.
     */
    public void setViaBot(@Nullable User viaBot) {
        this.viaBot = viaBot;
    }

    /**
     *
     * @return True, if the message can't be forwarded
     */
    @Nullable
    public Boolean getHasProtectedContent() {
        return hasProtectedContent;
    }

    /**
     *
     * @param hasProtectedContent True, if the message can't be forwarded
     */
    public void setHasProtectedContent(@Nullable Boolean hasProtectedContent) {
        this.hasProtectedContent = hasProtectedContent;
    }

    /**
     *
     * @return Message is a dice with random value
     */
    @Nullable
    public Dice getDice() {
        return dice;
    }

    /**
     *
     * @param dice Message is a dice with random value
     */
    public void setDice(@Nullable Dice dice) {
        this.dice = dice;
    }

    /**
     *
     * @return Service message: auto-delete timer settings changed in the chat.
     */
    @Nullable
    public MessageAutoDeleteTimerChanged getMessageAutoDeleteTimerChanged() {
        return messageAutoDeleteTimerChanged;
    }

    /**
     *
     * @param messageAutoDeleteTimerChanged Service message: auto-delete timer settings changed in the chat.
     */
    public void setMessageAutoDeleteTimerChanged(@Nullable MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged) {
        this.messageAutoDeleteTimerChanged = messageAutoDeleteTimerChanged;
    }

    /**
     *
     * @return Service message: video chat scheduled
     */
    @Nullable
    public VideoChatScheduled getVideoChatScheduled() {
        return videoChatScheduled;
    }

    /**
     *
     * @param videoChatScheduled Service message: video chat scheduled
     */
    public void setVideoChatScheduled(@Nullable VideoChatScheduled videoChatScheduled) {
        this.videoChatScheduled = videoChatScheduled;
    }

    /**
     *
     * @return Service message: video chat started
     */
    @Nullable
    public VideoChatStarted getVideoChatStarted() {
        return videoChatStarted;
    }

    /**
     *
     * @param videoChatStarted Service message: video chat started
     */
    public void setVideoChatStarted(@Nullable VideoChatStarted videoChatStarted) {
        this.videoChatStarted = videoChatStarted;
    }

    /**
     *
     * @return Service message: video chat ended
     */
    @Nullable
    public VideoChatEnded getVideoChatEnded() {
        return videoChatEnded;
    }

    /**
     *
     * @param videoChatEnded Service message: video chat ended
     */
    public void setVideoChatEnded(@Nullable VideoChatEnded videoChatEnded) {
        this.videoChatEnded = videoChatEnded;
    }

    /**
     *
     * @return Service message: new participants invited to a video chat
     */
    @Nullable
    public VideoChatParticipantsInvited getVideoChatParticipantsInvited() {
        return videoChatParticipantsInvited;
    }

    /**
     *
     * @param videoChatParticipantsInvited Service message: new participants invited to a video chat
     */
    public void setVideoChatParticipantsInvited(@Nullable VideoChatParticipantsInvited videoChatParticipantsInvited) {
        this.videoChatParticipantsInvited = videoChatParticipantsInvited;
    }

    /**
     *
     * @return Service message: data sent by a Web App
     */
    @Nullable
    public WebAppData getWebAppData() {
        return webAppData;
    }

    /**
     *
     * @param webAppData Service message: data sent by a Web App
     */
    public void setWebAppData(@Nullable WebAppData webAppData) {
        this.webAppData = webAppData;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", from=" + (from != null ? from.toString() : "") +
                ", date=" + date +
                ", chat=" + (chat != null ? chat.toString() : "") +
                ", forwardFrom=" + (forwardFrom != null ? forwardFrom.toString() : "") +
                ", forwardFromChat=" + (forwardFromChat != null ? forwardFromChat.toString() : "") +
                ", forwardFromMessageId=" + forwardFromMessageId +
                ", forwardSignature='" + forwardSignature + '\'' +
                ", forwardSenderName='" + forwardSenderName + '\'' +
                ", forwardDate=" + forwardDate +
                ", replyToMessage=" + (replyToMessage != null ? replyToMessage.toString() : "") +
                ", editDate=" + editDate +
                ", mediaGroupId='" + mediaGroupId + '\'' +
                ", authorSignature='" + authorSignature + '\'' +
                ", text='" + text + '\'' +
                ", entities=" + (entities != null ? entities.stream().map(MessageEntity::toString).collect(Collectors.joining(",")) : "") +
                ", captionEntities=" + (captionEntities != null ? captionEntities.stream().map(MessageEntity::toString).collect(Collectors.joining(",")) : "") +
                ", audio=" + (audio != null ? audio.toString() : "") +
                ", document=" + (document != null ? document.toString() : "") +
                ", animation=" + (animation != null ? animation.toString() : "") +
                ", game=" + (game != null ? game.toString() : "") +
                ", photo=" + (photo != null ? photo.stream().map(PhotoSize::toString).collect(Collectors.joining(",")) : "") +
                ", sticker=" + (sticker != null ? sticker.toString() : "") +
                ", video=" + (video != null ? video.toString() : "") +
                ", voice=" + (voice != null ? voice.toString() : "") +
                ", videoNote=" + (videoNote != null ? videoNote.toString() : "") +
                ", caption='" + caption + '\'' +
                ", contact=" + (contact != null ? contact.toString() : "") +
                ", location=" + (location != null ? location.toString() : "") +
                ", venue=" + (venue != null ? venue.toString() : "") +
                ", poll=" + (poll  != null ? poll.toString() : "") +
                ", newChatMembers=" + (newChatMembers != null ? newChatMembers.stream().map(User::toString).collect(Collectors.joining(",")) : "") +
                ", leftChatMember=" + (leftChatMember != null ? leftChatMember.toString() : "") +
                ", newChatTitle='" + newChatTitle + '\'' +
                ", newChatPhoto=" + (newChatPhoto != null ? newChatPhoto.stream().map(PhotoSize::toString).collect(Collectors.joining(",")) : "") +
                ", deleteChatPhoto=" + deleteChatPhoto +
                ", groupChatCreated=" + groupChatCreated +
                ", supergroupChatCreated=" + supergroupChatCreated +
                ", channelChatCreated=" + channelChatCreated +
                ", migrateToChatId=" + migrateToChatId +
                ", migrateFromChatId=" + migrateFromChatId +
                ", pinnedMessage=" + (pinnedMessage != null ? pinnedMessage.toString() : "")  +
                ", invoice=" + (invoice != null ? invoice.toString() : "")  +
                ", successfulPayment=" + (successfulPayment != null ? successfulPayment.toString() : "")  +
                ", connectedWebsite='" + connectedWebsite + '\'' +
                ", passportData=" + (passportData != null ? passportData.toString() : "") +
                ", replyMarkup=" + (replyMarkup  != null ? replyMarkup.toString() : "") +
                '}';
    }
}
