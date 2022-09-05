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

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

/**
 * Represents an audio file to be treated as music to be sent.
 */
@Serdeable
public class InputMediaAudio extends InputMediaDocument {
    private static final String TYPE_AUDIO = "audio";

    /**
     * Duration of the audio in seconds.
     */
    @Nullable
    private Integer duration;

    /**
     * Performer of the audio.
     */
    @Nullable
    private String performer;

    /**
     * Title of the audio.
     */
    @Nullable
    private String title;

    public InputMediaAudio() {
        super(TYPE_AUDIO);
    }

    /**
     *
     * @return Duration of the audio in seconds.
     */
    @Nullable
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration Duration of the audio in seconds.
     */
    public void setDuration(@Nullable Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return Performer of the audio.
     */
    @Nullable
    public String getPerformer() {
        return performer;
    }

    /**
     *
     * @param performer Performer of the audio.
     */
    public void setPerformer(@Nullable String performer) {
        this.performer = performer;
    }

    /**
     *
     * @return Title of the audio
     */
    @Nullable
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title Title of the audio
     */
    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "InputMediaAudio{" +
                "duration=" + duration +
                ", performer='" + performer + '\'' +
                ", title='" + title + '\'' +
                super.toString() +
                '}';
    }
}
