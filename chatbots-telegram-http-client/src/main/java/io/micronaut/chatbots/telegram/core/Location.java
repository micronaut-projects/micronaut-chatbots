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
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import javax.validation.constraints.NotNull;

/**
 * This object represents a point on the map.
 * @see <a href="https://core.telegram.org/bots/api#location">Location</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class Location {

    /**
     * Longitude as defined by sender.
     */
    @NonNull
    @NotNull
    private Float longitude;

    /**
     * Latitude as defined by sender.
     */
    @NonNull
    @NotNull
    private Float latitude;

    /**
     * The radius of uncertainty for the location, measured in meters; 0-1500.
     */
    @JsonProperty("horizontal_accuracy")
    @Nullable
    private Float horizontalAccuracy;

    /**
     * Time relative to the message sending date, during which the location can be updated; in seconds. For active live locations only.
     */
    @JsonProperty("live_period")
    @Nullable
    private Integer livePeriod;

    /**
     * The direction in which user is moving, in degrees; 1-360. For active live locations only.
     */
    @Nullable
    private Integer heading;

    /**
     * The maximum distance for proximity alerts about approaching another chat member, in meters. For sent live locations only.
     */
    @JsonProperty("proximity_alert_radius")
    @Nullable
    private Integer proximityAlertRadius;

    public Location() {
    }

    /**
     *
     * @return Longitude as defined by sender.
     */
    @NonNull
    public Float getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude Longitude as defined by sender.
     */
    public void setLongitude(@NonNull Float longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return Latitude as defined by sender.
     */
    @NonNull
    public Float getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude Latitude as defined by sender.
     */
    public void setLatitude(@NonNull Float latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return The radius of uncertainty for the location, measured in meters; 0-1500.
     */
    @Nullable
    public Float getHorizontalAccuracy() {
        return horizontalAccuracy;
    }

    /**
     *
     * @param horizontalAccuracy The radius of uncertainty for the location, measured in meters; 0-1500.
     */
    public void setHorizontalAccuracy(@Nullable Float horizontalAccuracy) {
        this.horizontalAccuracy = horizontalAccuracy;
    }

    /**
     *
     * @return Time relative to the message sending date, during which the location can be updated; in seconds. For active live locations only.
     */
    @Nullable
    public Integer getLivePeriod() {
        return livePeriod;
    }

    /**
     *
     * @param livePeriod Time relative to the message sending date, during which the location can be updated; in seconds. For active live locations only.
     */
    public void setLivePeriod(@Nullable Integer livePeriod) {
        this.livePeriod = livePeriod;
    }

    /**
     *
     * @return The direction in which user is moving, in degrees; 1-360. For active live locations only.
     */
    @Nullable
    public Integer getHeading() {
        return heading;
    }

    /**
     *
     * @param heading The direction in which user is moving, in degrees; 1-360. For active live locations only.
     */
    public void setHeading(@Nullable Integer heading) {
        this.heading = heading;
    }

    /**
     *
     * @return The maximum distance for proximity alerts about approaching another chat member, in meters. For sent live locations only.
     */
    @Nullable
    public Integer getProximityAlertRadius() {
        return proximityAlertRadius;
    }

    /**
     *
     * @param proximityAlertRadius The maximum distance for proximity alerts about approaching another chat member, in meters. For sent live locations only.
     */
    public void setProximityAlertRadius(@Nullable Integer proximityAlertRadius) {
        this.proximityAlertRadius = proximityAlertRadius;
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
