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

import javax.validation.constraints.NotNull;

/**
 * This object represents a service message about a video chat scheduled in the chat.
 * <a href="https://core.telegram.org/bots/api#videochatscheduled">Video Chat Scheduled</a>
 */
@Serdeable
public class VideoChatScheduled {

    /**
     * Point in time (Unix timestamp) when the video chat is supposed to be started by a chat administrator.
     */
    @JsonProperty("start_date")
    @NonNull
    @NotNull
    private Integer startDate;

    /**
     *
     * @return Point in time (Unix timestamp) when the video chat is supposed to be started by a chat administrator
     */
    @NonNull
    public Integer getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate Point in time (Unix timestamp) when the video chat is supposed to be started by a chat administrator
     */
    public void setStartDate(@NonNull Integer startDate) {
        this.startDate = startDate;
    }
}
