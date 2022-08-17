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
package io.micronaut.chatbots.telegram.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

/**
 * Represents a video to be sent.
 */
@Serdeable
public class InputMediaVideo extends InputMediaDocument {
    private static final String TYPE_VIDEO = "video";

    /**
     * Video width.
     */
    @Nullable
    private Integer width;

    /**
     * Video height.
     */
    @Nullable
    private Integer height;

    /**
     * Video duration.
     */
    @Nullable
    private Integer duration;

    /**
     *  Pass True, if the uploaded video is suitable for streaming.
     */
    @Nullable
    @JsonProperty("supports_streaming")
    private Boolean supportsStreaming;

    public InputMediaVideo() {
        super(TYPE_VIDEO);
    }

    /**
     *
     * @return Video width
     */
    @Nullable
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width Video width
     */
    public void setWidth(@Nullable Integer width) {
        this.width = width;
    }

    /**
     *
     * @return Video height.
     */
    @Nullable
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height Video height.
     */
    public void setHeight(@Nullable Integer height) {
        this.height = height;
    }

    /**
     *
     * @return Video duration.
     */
    @Nullable
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration Video duration.
     */
    public void setDuration(@Nullable Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return True, if the uploaded video is suitable for streaming.
     */
    @Nullable
    public Boolean getSupportsStreaming() {
        return supportsStreaming;
    }

    /**
     *
     * @param supportsStreaming Pass True, if the uploaded video is suitable for streaming.
     */
    public void setSupportsStreaming(@Nullable Boolean supportsStreaming) {
        this.supportsStreaming = supportsStreaming;
    }

    @Override
    public String toString() {
        return "InputMediaVideo{" +
                "width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", supportsStreaming=" + supportsStreaming +
                '}';
    }
}
