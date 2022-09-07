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
package io.micronaut.chatbots.telegram.http;

import io.micronaut.chatbots.http.ControllerConfigurationProperties;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;

/**
 * {@link TelegramController} configuration.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Requires(property = TelegramControllerConfiguration.PREFIX + ".enabled", notEquals = StringUtils.FALSE, defaultValue = StringUtils.TRUE)
@ConfigurationProperties(TelegramControllerConfiguration.PREFIX)
public class TelegramControllerConfiguration extends ControllerConfigurationProperties {
    public static final String PREFIX = "micronaut.chatbots.telegram.endpoint";

    /**
     * The default path.
     */
    @SuppressWarnings({"WeakerAccess", "java:S1075"}) // Sonar sees this as unconfigurable, which is wrong
    public static final String DEFAULT_PATH = "/telegram";

    public TelegramControllerConfiguration() {
        super(DEFAULT_PATH);
    }
}
