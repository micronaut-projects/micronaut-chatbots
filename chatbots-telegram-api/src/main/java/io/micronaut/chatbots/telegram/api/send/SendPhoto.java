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
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;

/**
 * @see <a href="https://core.telegram.org/bots/api#sendphoto">SendPhoto</a>
 */
@Serdeable
public class SendPhoto extends SendCaption {

    public static final String SEND_PHOTO = "sendPhoto";
    /**
     * Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. More info on Sending Files »
     */
    @NonNull
    @NotBlank
    private String photo;

    public SendPhoto() {
        super(SEND_PHOTO);
    }

    /**
     *
     * @return Photo to send.
     */
    @NonNull
    public String getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo Photo to send.
     */
    public void setPhoto(@NonNull String photo) {
        this.photo = photo;
    }
}
