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
package io.micronaut.chatbots.telegram.api.send;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;

/**
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class SendVoice extends SendCaption {

    public static final String SEND_VOICE = "sendVoice";

    /**
     * Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data.
     */
    @NonNull
    @NotBlank
    private String voice;

    /**
     * Duration of the voice message in seconds.
     */
    @Nullable
    private Integer duration;

    /**
     * Constructor.
     */
    public SendVoice() {
        super(SEND_VOICE);
    }

    /**
     *
     * @return Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data.
     */
    @NonNull
    public String getVoice() {
        return voice;
    }

    /**
     *
     * @param voice Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data.
     */
    public void setVoice(@NonNull String voice) {
        this.voice = voice;
    }

    /**
     *
     * @return Duration of the voice message in seconds.
     */
    @Nullable
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration Duration of the voice message in seconds.
     */
    public void setDuration(@Nullable Integer duration) {
        this.duration = duration;
    }
}
