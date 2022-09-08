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
package io.micronaut.chatbots.core;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.util.StringUtils;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.List;

/**
 * {@link ConfigurationProperties} implementation of {@link ChatbotsConfiguration}.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@ConfigurationProperties(ChatbotsConfiguration.PREFIX)
public class ChatbotsConfigurationProperties implements ChatbotsConfiguration {
    /**
     * The default BOT commands folder.
     */
    public static final String DEFAULT_FOLDER = "botcommands";

    /**
     * The default enable value.
     */
    @SuppressWarnings("WeakerAccess")
    public static final boolean DEFAULT_ENABLED = true;

    private boolean enabled = DEFAULT_ENABLED;

    @NonNull
    @NotBlank
    private String folder = DEFAULT_FOLDER;

    @Nullable
    private List<FileExtension> possibleStaticCommandExtensions = Arrays.asList(FileExtension.values());

    /**
     * enabled getter.
     *
     * @return boolean flag indicating whether the chatbots features are enabled.
     */
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * @return The Bot Commands' folder where views should be searched for. By default {@value #DEFAULT_FOLDER}
     */
    @Override
    @NonNull
    public String getFolder() {
        return folder;
    }

    /**
     * Whether chatbots is enabled. Default value ({@value #DEFAULT_ENABLED}).
     *
     * @param enabled True if view rendering is enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * The folder to look for bot commands.
     *
     * @param folder The folder
     */
    public void setFolder(String folder) {
        if (StringUtils.isNotEmpty(folder)) {
            this.folder = folder;
        }
    }

    @Override
    @Nullable
    public List<FileExtension> getPossibleStaticCommandExtensions() {
        return possibleStaticCommandExtensions;
    }

    /**
     * Possible static command file extensions. Default values MARKDOWN HTML TXT
     * @param possibleStaticCommandExtensions Possible static command file extensions.
     */
    public void setPossibleStaticCommandExtensions(@Nullable List<FileExtension> possibleStaticCommandExtensions) {
        this.possibleStaticCommandExtensions = possibleStaticCommandExtensions;
    }
}
