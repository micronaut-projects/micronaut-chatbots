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

import jakarta.validation.constraints.NotNull;

/**
 * Represents an incoming update.
 * At most one of the optional parameters can be present in any given update.
 * @see <a href="https://core.telegram.org/bots/api#update">Update</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class Update {

    /**
     * The update‘s unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you’re using Webhooks, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
     */
    @JsonProperty("update_id")
    @NonNull
    @NotNull
    private Integer updateId;

    /**
     * New incoming message of any kind — text, photo, sticker, etc.
     */
    @Nullable
    private Message message;

    /**
     * New version of a message that is known to the bot and was edited.
     */
    @Nullable
    @JsonProperty("edited_message")
    private Message editedMessage;

    /**
     * New incoming channel post of any kind — text, photo, sticker, etc.
     */
    @Nullable
    @JsonProperty("channel_post")
    private Message channelPost;

    /**
     * New version of a channel post that is known to the bot and was edited.
     */
    @Nullable
    @JsonProperty("edited_channel_post")
    private Message editedChannelPost;

    /**
     * New incoming inline query.
     */
    @Nullable
    @JsonProperty("inline_query")
    private InlineQuery inlineQuery;

    /**
     * The result of an inline query that was chosen by a user and sent to their chat partner. Please see our documentation on the feedback collecting for details on how to enable these updates for your bot.
     */
    @Nullable
    @JsonProperty("chosen_inline_result")
    private ChosenInlineResult chosenInlineResult;

    /**
     * New incoming callback query.
     */
    @Nullable
    @JsonProperty("callback_query")
    private CallbackQuery callbackQuery;

    /**
     *  New incoming shipping query. Only for invoices with flexible price.
     */
    @Nullable
    @JsonProperty("shipping_query")
    private ShippingQuery shippingQuery;

    /**
     *  New incoming pre-checkout query. Contains full information about checkout.
     */
    @Nullable
    @JsonProperty("pre_checkout_query")
    private PreCheckoutQuery preCheckoutQuery;

    /**
     * New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot.
     */
    @Nullable
    private Poll poll;

    /**
     *  A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself.
     */
    @JsonProperty("poll_answer")
    @Nullable
    private PollAnswer pollAnswer;

    /**
     *
     * @return The update‘s unique identifier.
     */
    @NonNull
    public Integer getUpdateId() {
        return updateId;
    }

    /**
     *
     * @param updateId The update‘s unique identifier.
     */
    public void setUpdateId(@NonNull Integer updateId) {
        this.updateId = updateId;
    }

    /**
     *
     * @return New incoming message of any kind — text, photo, sticker, etc.
     */
    @Nullable
    public Message getMessage() {
        return message;
    }

    /**
     *
     * @param message New incoming message of any kind — text, photo, sticker, etc.
     */
    public void setMessage(@Nullable Message message) {
        this.message = message;
    }

    /**
     *
     * @return New version of a message that is known to the bot and was edited.
     */
    @Nullable
    public Message getEditedMessage() {
        return editedMessage;
    }

    /**
     *
     * @param editedMessage New version of a message that is known to the bot and was edited.
     */
    public void setEditedMessage(@Nullable Message editedMessage) {
        this.editedMessage = editedMessage;
    }

    /**
     *
     * @return New incoming channel post of any kind — text, photo, sticker, etc.
     */
    @Nullable
    public Message getChannelPost() {
        return channelPost;
    }

    /**
     *
     * @param channelPost New incoming channel post of any kind — text, photo, sticker, etc.
     */
    public void setChannelPost(@Nullable Message channelPost) {
        this.channelPost = channelPost;
    }

    /**
     *
     * @return New version of a channel post that is known to the bot and was edited.
     */
    @Nullable
    public Message getEditedChannelPost() {
        return editedChannelPost;
    }

    /**
     *
     * @param editedChannelPost New version of a channel post that is known to the bot and was edited.
     */
    public void setEditedChannelPost(@Nullable Message editedChannelPost) {
        this.editedChannelPost = editedChannelPost;
    }

    /**
     *
     * @return New incoming inline query.
     */
    @Nullable
    public InlineQuery getInlineQuery() {
        return inlineQuery;
    }

    /**
     *
     * @param inlineQuery New incoming inline query.
     */
    public void setInlineQuery(@Nullable InlineQuery inlineQuery) {
        this.inlineQuery = inlineQuery;
    }

    /**
     *
     * @return The result of an inline query that was chosen by a user and sent to their chat partner
     */
    @Nullable
    public ChosenInlineResult getChosenInlineResult() {
        return chosenInlineResult;
    }

    /**
     *
     * @param chosenInlineResult The result of an inline query that was chosen by a user and sent to their chat partner
     */
    public void setChosenInlineResult(@Nullable ChosenInlineResult chosenInlineResult) {
        this.chosenInlineResult = chosenInlineResult;
    }

    /**
     *
     * @return New incoming callback query.
     */
    @Nullable
    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }

    /**
     *
     * @param callbackQuery New incoming callback query.
     */
    public void setCallbackQuery(@Nullable CallbackQuery callbackQuery) {
        this.callbackQuery = callbackQuery;
    }

    /**
     *
     * @return New incoming shipping query. Only for invoices with flexible price.
     */
    @Nullable
    public ShippingQuery getShippingQuery() {
        return shippingQuery;
    }

    /**
     *
     * @param shippingQuery New incoming shipping query. Only for invoices with flexible price.
     */
    public void setShippingQuery(@Nullable ShippingQuery shippingQuery) {
        this.shippingQuery = shippingQuery;
    }

    /**
     *
     * @return New incoming pre-checkout query. Contains full information about checkout.
     */
    @Nullable
    public PreCheckoutQuery getPreCheckoutQuery() {
        return preCheckoutQuery;
    }

    /**
     *
     * @param preCheckoutQuery New incoming pre-checkout query. Contains full information about checkout.
     */
    public void setPreCheckoutQuery(@Nullable PreCheckoutQuery preCheckoutQuery) {
        this.preCheckoutQuery = preCheckoutQuery;
    }

    /**
     *
     * @return New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot.
     */
    @Nullable
    public Poll getPoll() {
        return poll;
    }

    /**
     *
     * @param poll New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot.
     */
    public void setPoll(@Nullable Poll poll) {
        this.poll = poll;
    }

    /**
     *
     * @return A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself.
     */
    @Nullable
    public PollAnswer getPollAnswer() {
        return pollAnswer;
    }

    /**
     *
     * @param pollAnswer A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself.
     */
    public void setPollAnswer(@Nullable PollAnswer pollAnswer) {
        this.pollAnswer = pollAnswer;
    }

    @Override
    public String toString() {
        return "Update{" +
                "updateId=" + updateId +
                ", message=" + (message != null ? message.toString() : "") +
                ", editedMessage=" + (editedMessage != null ? editedMessage.toString() : "") +
                ", channelPost=" + (channelPost != null ? channelPost.toString() : "") +
                ", editedChannelPost=" + (editedChannelPost  != null ? editedChannelPost.toString() : "") +
                ", inlineQuery=" + (inlineQuery != null ? inlineQuery.toString() : "") +
                ", chosenInlineResult=" + (chosenInlineResult != null ? chosenInlineResult.toString() : "") +
                ", callbackQuery=" + (callbackQuery != null ? callbackQuery.toString() : "") +
                ", shippingQuery=" + (shippingQuery != null ? shippingQuery.toString() : "") +
                ", preCheckoutQuery=" + (preCheckoutQuery != null ? preCheckoutQuery.toString() : "") +
                ", poll=" + (poll != null ? poll.toString() : "") +
                ", pollAnswer=" + (pollAnswer != null ? pollAnswer.toString() : "") +
                '}';
    }
}
