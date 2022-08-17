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
import javax.validation.constraints.NotBlank;

/**
 * Describes a Web App.
 * <a href="https://core.telegram.org/bots/api#webappinfo">WebAppInfo</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class WebAppInfo {
    /**
     * An HTTPS URL of a Web App to be opened with additional data as specified in Initializing Web Apps.
     */
    @NonNull
    @NotBlank
    private String url;

    /**
     *
     * @return An HTTPS URL of a Web App to be opened with additional data as specified in Initializing Web Apps
     */
    @NonNull
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url An HTTPS URL of a Web App to be opened with additional data as specified in Initializing Web Apps
     */
    public void setUrl(@NonNull String url) {
        this.url = url;
    }
}
