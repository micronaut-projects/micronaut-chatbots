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
package io.micronaut.chatbots.basecamp.core;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.chatbots.core.ChatbotsConfiguration;

/**
 * {@link EachProperty} implementation of {@link BasecampBotConfiguration}.
 * @author Sergio del Amo
 * @since 1.0.0
 *  */
@EachProperty(BasecampBotConfigurationProperties.PREFIX)
public class BasecampBotConfigurationProperties implements BasecampBotConfiguration {
    /**
     * Basecamp Configuration prefix.
     */
    public static final String PREFIX = ChatbotsConfiguration.PREFIX + ".basecamp.bots";
    private static final boolean DEFAULT_ENABLED = true;

    @NonNull
    private final String name;
    private boolean enabled = DEFAULT_ENABLED;

    public BasecampBotConfigurationProperties(@Parameter String name) {
        this.name = name;
    }

    @Override
    @NonNull
    public String getName() {
        return name;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets whether this configuration is enabled. Default {@value #DEFAULT_ENABLED}.
     *
     * @param enabled The enabled setting
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
