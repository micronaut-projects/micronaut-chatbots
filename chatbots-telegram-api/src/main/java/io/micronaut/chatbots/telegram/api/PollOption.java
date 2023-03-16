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
import io.micronaut.serde.annotation.Serdeable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * This object contains information about one answer option in a poll.
 * @see <a href="https://core.telegram.org/bots/api#polloption">Poll Option</a>
 */
@Serdeable
public class PollOption {
    /**
     * Option text, 1-100 characters.
     */
    @NonNull
    @NotBlank
    private String text;

    /**
     * Number of users that voted for this option.
     */
    @JsonProperty("voter_count")
    @NonNull
    @NotNull
    private Integer voterCount;

    /**
     *
     * @return Option text, 1-100 characters.
     */
    @NonNull
    public String getText() {
        return text;
    }

    /**
     *
     * @param text Option text, 1-100 characters.
     */
    public void setText(@NonNull String text) {
        this.text = text;
    }

    /**
     *
     * @return Number of users that voted for this option
     */
    @NonNull
    public Integer getVoterCount() {
        return voterCount;
    }

    /**
     *
     * @param voterCount Number of users that voted for this option
     */
    public void setVoterCount(@NonNull Integer voterCount) {
        this.voterCount = voterCount;
    }

    @Override
    public String toString() {
        return "PollOption{" +
                "text='" + text + '\'' +
                ", voterCount=" + voterCount +
                '}';
    }
}
