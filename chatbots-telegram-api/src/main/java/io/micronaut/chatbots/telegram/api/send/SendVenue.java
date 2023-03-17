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

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;

/**
 * @see <a href="https://core.telegram.org/bots/api#sendvenue">SendVenue</a>
 */
@Serdeable
public class SendVenue extends SendCoordinates {
    /**
     * Name of the venue.
     */
    @NonNull
    @NotBlank
    private String title;

    /**
     * Address of the venue.
     */
    @NonNull
    @NotBlank
    private String address;

    /**
     * Foursquare identifier of the venue.
     */
    @Nullable
    @JsonProperty("foursquare_id")
    private String foursquareId;

    /**
     * Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
     */
    @Nullable
    @JsonProperty("foursquare_type")
    private String foursquareType;

    public SendVenue() {
        super("sendVenue");
    }

    /**
     *
     * @return Name of the venue
     */
    @NonNull
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title Name of the venue
     */
    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    /**
     *
     * @return Address of the venue.
     */
    @NonNull
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address Address of the venue.
     */
    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    /**
     *
     * @return Foursquare identifier of the venue.
     */
    @Nullable
    public String getFoursquareId() {
        return foursquareId;
    }

    /**
     *
     * @param foursquareId Foursquare identifier of the venue.
     */
    public void setFoursquareId(@Nullable String foursquareId) {
        this.foursquareId = foursquareId;
    }

    /**
     *
     * @return Foursquare type of the venue
     */
    @Nullable
    public String getFoursquareType() {
        return foursquareType;
    }

    /**
     *
     * @param foursquareType Foursquare type of the venue
     */
    public void setFoursquareType(@Nullable String foursquareType) {
        this.foursquareType = foursquareType;
    }
}
