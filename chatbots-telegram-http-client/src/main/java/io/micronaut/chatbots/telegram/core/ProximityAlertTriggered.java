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

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * This object represents the content of a service message, sent whenever a user in the chat triggers a proximity alert set by another user.
 * <a href="https://core.telegram.org/bots/api#proximityalerttriggered>ProximityAlterTrigger</a>
 */
@Serdeable
public class ProximityAlertTriggered {

    /**
     * User that triggered the alert.
     */
    @NonNull
    @NotNull
    @Valid
    private User traveler;

    /**
     * User that set the alert.
     */
    @NonNull
    @NotNull
    @Valid
    private User watcher;

    /**
     * The distance between the users.
     */
    @NonNull
    @NotNull
    private Integer distance;

    /**
     *
     * @return User that triggered the alert.
     */
    @NonNull
    public User getTraveler() {
        return traveler;
    }

    /**
     *
     * @param traveler User that triggered the alert.
     */
    public void setTraveler(@NonNull User traveler) {
        this.traveler = traveler;
    }

    /**
     *
     * @return User that set the alert.
     */
    @NonNull
    public User getWatcher() {
        return watcher;
    }

    /**
     *
     * @param watcher User that set the alert.
     */
    public void setWatcher(@NonNull User watcher) {
        this.watcher = watcher;
    }

    /**
     *
     * @return The distance between the users.
     */
    @NonNull
    public Integer getDistance() {
        return distance;
    }

    /**
     *
     * @param distance The distance between the users.
     */
    public void setDistance(@NonNull Integer distance) {
        this.distance = distance;
    }
}
