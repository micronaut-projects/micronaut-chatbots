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
import java.util.List;

/**
 * This object represents a service message about new members invited to a video chat.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class VideoChatParticipantsInvited {
    /**
     * New members that were invited to the video chat.
     */
    @NonNull
    @NotNull
    private List<User> users;

    /**
     *
     * @return New members that were invited to the video chat
     */
    @NonNull
    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * @param users New members that were invited to the video chat
     */
    public void setUsers(@NonNull List<User> users) {
        this.users = users;
    }
}
