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
import javax.validation.constraints.NotNull;

/**
 * @see <a href="https://core.telegram.org/bots/api#sendlocation">SendAudio</a>
 */
@Serdeable
public class SendLocation extends SendCoordinates {

    public static final String SEND_LOCATION = "sendLocation";

    /**
     * Period in seconds for which the location will be updated.
     */
    @Nullable
    @JsonProperty("live_period")
    private Integer livePeriod;

    public SendLocation() {
        super(SEND_LOCATION);
    }

    /**
     *
     * @return Period in seconds for which the location will be updated.
     */
    @Nullable
    public Integer getLivePeriod() {
        return livePeriod;
    }

    /**
     *
     * @param livePeriod Period in seconds for which the location will be updated.
     */
    public void setLivePeriod(@Nullable Integer livePeriod) {
        this.livePeriod = livePeriod;
    }
}
