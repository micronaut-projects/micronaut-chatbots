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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This object contains information about a poll.
 * @see <a href="https://core.telegram.org/bots/api#poll">Poll</a>
 */
@Serdeable
public class Poll {

    /**
     * Unique poll identifier.
     */
    @NonNull
    @NotBlank
    private String id;

    /**
     * Poll question, 1-255 characters.
     */
    @NonNull
    @NotBlank
    private String question;

    /**
     * List of poll options.
     */
    @NonNull
    @NotNull
    private List<PollOption> options;

    /**
     * Total number of users that voted in the poll.
     */
    @JsonProperty("total_voter_count")
    @NonNull
    @NotNull
    private Integer totalVoterCount;

    /**
     * True, if the poll is closed.
     */
    @JsonProperty("is_closed")
    @NonNull
    @NotNull
    private Boolean closed;

    /**
     * True, if the poll is anonymous.
     */
    @JsonProperty("is_anonymous")
    @NonNull
    @NotNull
    private Boolean anonymous;

    /**
     * type, currently can be “regular” or “quiz”.
     */
    @NonNull
    @NotBlank
    @Pattern(regexp = "regular|quiz")
    private String type;

    /**
     * True, if the poll allows multiple answers.
     */
    @JsonProperty("allows_multiple_answers")
    @NonNull
    @NotNull
    private Boolean allowsMultipleAnswers;

    /**
     * Optional. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
     */
    @JsonProperty("correct_option_id")
    @Nullable
    private Integer correctOptionId;

    /**
     * Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters.
     */
    @Nullable
    private String explanation;

    /**
     * Special entities like usernames, URLs, bot commands, etc. that appear in the explanation.
     */
    @Nullable
    @JsonProperty("explanation_entities")
    private List<MessageEntity> explanationEntities;

    /**
     * Amount of time in seconds the poll will be active after creation.
     */
    @JsonProperty("open_period")
    @Nullable
    private Integer openPeriod;

    /**
     * Point in time (Unix timestamp) when the poll will be automatically closed.
     */
    @Nullable
    @JsonProperty("close_date")
    private Integer closeDate;

    /**
     *
     * @return Unique poll identifier.
     */
    @NonNull
    public String getId() {
        return id;
    }

    /**
     *
     * @param id Unique poll identifier.
     */
    public void setId(@NonNull String id) {
        this.id = id;
    }

    /**
     *
     * @return Poll question, 1-255 characters.
     */
    @NonNull
    public String getQuestion() {
        return question;
    }

    /**
     *
     * @param question Poll question, 1-255 characters.
     */
    public void setQuestion(@NonNull String question) {
        this.question = question;
    }

    /**
     *
     * @return List of poll options.
     */
    @NonNull
    public List<PollOption> getOptions() {
        return options;
    }

    /**
     *
     * @param options List of poll options.
     */
    public void setOptions(@NonNull List<PollOption> options) {
        this.options = options;
    }

    /**
     *
     * @return Total number of users that voted in the poll.
     */
    @NonNull
    public Integer getTotalVoterCount() {
        return totalVoterCount;
    }

    /**
     *
     * @param totalVoterCount Total number of users that voted in the poll.
     */
    public void setTotalVoterCount(@NonNull Integer totalVoterCount) {
        this.totalVoterCount = totalVoterCount;
    }

    /**
     *
     * @return True, if the poll is closed.
     */
    @NonNull
    public Boolean isClosed() {
        return closed;
    }

    /**
     *
     * @param closed True, if the poll is closed.
     */
    public void setClosed(@NonNull Boolean closed) {
        this.closed = closed;
    }

    /**
     *
     * @return True, if the poll is anonymous.
     */
    @NonNull
    public Boolean isAnonymous() {
        return anonymous;
    }

    /**
     *
     * @param anonymous True, if the poll is anonymous.
     */
    public void setAnonymous(@NonNull Boolean anonymous) {
        this.anonymous = anonymous;
    }

    /**
     *
     * @return type, currently can be “regular” or “quiz”.
     */
    @NonNull
    public String getType() {
        return type;
    }

    /**
     *
     * @param type type, currently can be “regular” or “quiz”.
     */
    public void setType(@NonNull String type) {
        this.type = type;
    }

    /**
     *
     * @return True, if the poll allows multiple answers.
     */
    @NonNull
    public Boolean getAllowsMultipleAnswers() {
        return allowsMultipleAnswers;
    }

    /**
     *
     * @param allowsMultipleAnswers True, if the poll allows multiple answers.
     */
    public void setAllowsMultipleAnswers(@NonNull Boolean allowsMultipleAnswers) {
        this.allowsMultipleAnswers = allowsMultipleAnswers;
    }

    /**
     *
     * @return Optional. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
     */
    public Integer getCorrectOptionId() {
        return correctOptionId;
    }

    /**
     *
     * @param correctOptionId Optional. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
     */
    public void setCorrectOptionId(Integer correctOptionId) {
        this.correctOptionId = correctOptionId;
    }

    /**
     *
     * @return Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters
     */
    @Nullable
    public String getExplanation() {
        return explanation;
    }

    /**
     *
     * @param explanation Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters
     */
    public void setExplanation(@Nullable String explanation) {
        this.explanation = explanation;
    }

    /**
     *
     * @return Special entities like usernames, URLs, bot commands, etc. that appear in the explanation
     */
    @Nullable
    public List<MessageEntity> getExplanationEntities() {
        return explanationEntities;
    }

    /**
     *
     * @param explanationEntities Special entities like usernames, URLs, bot commands, etc. that appear in the explanation
     */
    public void setExplanationEntities(@Nullable List<MessageEntity> explanationEntities) {
        this.explanationEntities = explanationEntities;
    }

    /**
     *
     * @return Amount of time in seconds the poll will be active after creation.
     */
    @Nullable
    public Integer getOpenPeriod() {
        return openPeriod;
    }

    /**
     *
     * @param openPeriod Amount of time in seconds the poll will be active after creation.
     */
    public void setOpenPeriod(@Nullable Integer openPeriod) {
        this.openPeriod = openPeriod;
    }

    /**
     *
     * @return Point in time (Unix timestamp) when the poll will be automatically closed
     */
    @Nullable
    public Integer getCloseDate() {
        return closeDate;
    }

    /**
     *
     * @param closeDate Point in time (Unix timestamp) when the poll will be automatically closed
     */
    public void setCloseDate(@Nullable Integer closeDate) {
        this.closeDate = closeDate;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", options=" + (options != null ? options.stream().map(PollOption::toString).collect(Collectors.joining(",")) : "") +
                ", totalVoterCount=" + totalVoterCount +
                ", isClosed=" + closed +
                ", isAnonymous=" + anonymous +
                ", typePoll='" + type + '\'' +
                ", allowsMultipleAnswers=" + allowsMultipleAnswers +
                ", correctOptionId=" + correctOptionId +
                '}';
    }
}
