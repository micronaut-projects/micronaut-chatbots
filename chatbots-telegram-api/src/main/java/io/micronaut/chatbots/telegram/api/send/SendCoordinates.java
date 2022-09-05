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
package io.micronaut.chatbots.telegram.api.send;

import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotNull;

/**
 * Sends latitudes and longitudes.
 * @author Sergio del Amo
 * @since 1.0.0
 */
public class SendCoordinates extends Send {
    /**
     * Longitude of the location.
     */
    @NonNull
    @NotNull
    private Float longitude;

    /**
     * Latitude of the location.
     *
     */
    @NonNull
    @NotNull
    private Float latitude;

    protected SendCoordinates(String method) {
        super(method);
    }

    /**
     *
     * @return Longitude of the location
     */
    @NonNull
    public Float getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude Longitude of the location
     */
    public void setLongitude(@NonNull Float longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return Latitude of the location.
     */
    @NonNull
    public Float getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude Latitude of the location.
     */
    public void setLatitude(@NonNull Float latitude) {
        this.latitude = latitude;
    }

}
