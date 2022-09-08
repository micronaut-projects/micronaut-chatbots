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

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.io.ResourceResolver;
import io.micronaut.core.io.scan.ClassPathResourceLoader;
import io.micronaut.core.util.StringUtils;
import jakarta.inject.Singleton;

import javax.validation.constraints.NotBlank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Users {@link io.micronaut.core.io.ResourceLoader} to load a static resource associated with a command.
 * For a command such as /help
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Singleton
public class DefaultTextResourceLoader implements TextResourceLoader {
    private static final String SLASH = "/";
    private static final String EMPTY = "";
    private static final String DOT = ".";
    private final ConcurrentHashMap<String, String> commandText = new ConcurrentHashMap<>();
    private final ResourceResolver resourceResolver;
    private final ChatbotsConfiguration chatbotsConfiguration;

    public DefaultTextResourceLoader(ChatbotsConfiguration chatbotsConfiguration,
                                     ResourceResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
        this.chatbotsConfiguration = chatbotsConfiguration;
    }

    @Override
    @NonNull
    public Optional<CommandResponse> composeCommandResponse(@NonNull @NotBlank String command) {
        if (chatbotsConfiguration.getPossibleStaticCommandExtensions() == null) {
            return Optional.empty();
        }
        for (FileExtension fileExtension : chatbotsConfiguration.getPossibleStaticCommandExtensions()) {
            for (String ext : fileExtension.getExtensions()) {
                String path = normalizeFolder(chatbotsConfiguration.getFolder()) + removeLeadingSlash(command) + DOT + ext;
                String text = commandText.computeIfAbsent(path, s -> textFromPath(s).orElse(EMPTY));
                if (StringUtils.isNotEmpty(text)) {
                    return Optional.of(new CommandResponse(fileExtension, text));
                }
            }
        }
        return Optional.empty();
    }

    @NonNull
    private Optional<String> textFromPath(@NonNull String path) {
        return resourceResolver.getLoader(ClassPathResourceLoader.class)
                .flatMap(loader ->  loader.getResource(path))
                .flatMap(url -> {
                    try {
                        try (InputStream inputStream = url.openConnection().getInputStream()) {
                            return Optional.of(readFromInputStream(inputStream));
                        }
                    } catch (IOException e) {
                        return Optional.empty();
                    }
                });
    }

    @NonNull
    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    @NonNull
    private static String normalizeFolder(@Nullable String path) {
        if (path == null) {
            path = "";
        }
        path = path.replace( "\\", SLASH);
        path = removeLeadingSlash(path);
        if (!path.endsWith(SLASH)) {
            path = path + SLASH;
        }
        return path;
    }

    @NonNull
    private static String removeLeadingSlash(@NonNull String str) {
        return str.startsWith(SLASH) ? str.substring(1) : str;
    }
}
