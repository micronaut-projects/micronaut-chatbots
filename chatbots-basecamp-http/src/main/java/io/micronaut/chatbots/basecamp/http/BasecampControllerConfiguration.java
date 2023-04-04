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
package io.micronaut.chatbots.basecamp.http;

import io.micronaut.chatbots.http.ControllerConfigurationProperties;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.chatbots.core.ChatbotsConfiguration;

/**
 * {@link BasecampController} configuration.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Requires(property = BasecampControllerConfiguration.PREFIX + ".enabled", notEquals = StringUtils.FALSE, defaultValue = StringUtils.TRUE)
@ConfigurationProperties(BasecampControllerConfiguration.PREFIX)
public class BasecampControllerConfiguration extends ControllerConfigurationProperties {

    /**
     * Basecamp Controller configuration prefix.
     */
    public static final String PREFIX = ChatbotsConfiguration.PREFIX + ".basecamp.endpoint";

    /**
     * The default path.
     */
    @SuppressWarnings({"WeakerAccess", "java:S1075"}) // Sonar sees this as unconfigurable, which is wrong
    public static final String DEFAULT_PATH = "/basecamp";

    public BasecampControllerConfiguration() {
        super(DEFAULT_PATH);
    }

    /**
     * Enables the controller. Default value true.
     * @param enabled True if it is enabled
     */
    @Override
    @SuppressWarnings("java:S1185") // This method is overridden to appear in configuration reference documentation
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

    /**
     * Path to the controller. Default value {@value #DEFAULT_PATH}.
     * @param path The path
     */
    @Override
    @SuppressWarnings("java:S1185") // This method is overridden to appear in configuration reference documentation
    public void setPath(String path) {
        super.setPath(path);
    }
}
