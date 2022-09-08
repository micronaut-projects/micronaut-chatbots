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
package io.micronaut.chatbots.telegram.core;

import io.micronaut.chatbots.core.ChatbotsConfiguration;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link EachProperty} implementation of {@link TelegramBotConfiguration}.
 * @author Sergio del Amo
 * @since 1.0.0
 *  */
@EachProperty(TelegramBotConfigurationProperties.PREFIX)
public class TelegramBotConfigurationProperties implements TelegramBotConfiguration {
    public static final String PREFIX = ChatbotsConfiguration.PREFIX + ".telegram.bots";
    private static final boolean DEFAULT_ENABLED = true;

    @NonNull
    @NotBlank
    private String token;

    @NonNull
    private final String name;

    @NotBlank
    @NonNull
    private String atUsername;

    private boolean enabled = DEFAULT_ENABLED;

    @NonNull
    private Map<String, String> commands = new HashMap<>();

    public TelegramBotConfigurationProperties(@Parameter String name) {
        this.name = name;
    }

    /**
     *
     * @return bot username prefixed with @
     */
    @NonNull
    public String getAtUsername() {
        return atUsername;
    }

    /**
     *
     * @param atUsername bot username prefixed with @
     */
    public void setAtUsername(@NonNull String atUsername) {
        this.atUsername = atUsername;
    }

    /**
     *
     * @return Telegram's token
     */
    @NonNull
    @Override
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token Telegram's token
     */
    public void setToken(@NonNull String token) {
        this.token = token;
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
