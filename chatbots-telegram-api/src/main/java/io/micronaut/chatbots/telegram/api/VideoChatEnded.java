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

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotNull;

/**
 * This object represents a service message about a video chat ended in the chat.
 * <a href="https://core.telegram.org/bots/api#videochatended">VideoChatEnded</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class VideoChatEnded {
    /**
     * Video chat duration in seconds.
     */
    @NonNull
    @NotNull
    private Integer duration;

    /**
     *
     * @return Video chat duration in seconds
     */
    @NonNull
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration Video chat duration in seconds
     */
    public void setDuration(@NonNull Integer duration) {
        this.duration = duration;
    }
}
