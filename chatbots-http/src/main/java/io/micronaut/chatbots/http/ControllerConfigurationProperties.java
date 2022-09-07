/*
 * Copyright 2017-2020 original authors
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
package io.micronaut.chatbots.http;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.util.StringUtils;

/**
 * Default implementation of {@link ControllerConfiguration}.
 * @author Sergio del Amo
 * @since 1.0
 */
public class ControllerConfigurationProperties implements ControllerConfiguration {
    /**
     * The default enable value.
     */
    @SuppressWarnings("WeakerAccess")
    public static final boolean DEFAULT_ENABLED = true;

    private boolean enabled = DEFAULT_ENABLED;
    private String path;

    public ControllerConfigurationProperties(String path) {
        this.path = path;
    }

    /**
     * @return true if you want to enable the Controller.
     */
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    @NonNull
    public String getPath() {
        return this.path;
    }

    /**
     * Enables the controller. Default value {@value #DEFAULT_ENABLED}
     * @param enabled True if it is enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Path to the controller. Default value {@value #DEFAULT_PATH}
     * @param path The path
     */
    public void setPath(String path) {
        if (StringUtils.isNotEmpty(path)) {
            this.path = path;
        }
    }
}
