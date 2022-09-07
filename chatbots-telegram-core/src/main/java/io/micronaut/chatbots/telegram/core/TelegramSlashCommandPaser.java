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
package io.micronaut.chatbots.telegram.core;

import io.micronaut.chatbots.core.SlashCommandParser;
import io.micronaut.chatbots.telegram.api.Message;
import io.micronaut.chatbots.telegram.api.Update;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.util.StringUtils;
import jakarta.inject.Singleton;

import java.util.Optional;

/**
 * {@link SlashCommandParser} for Telegram.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Singleton
public class TelegramSlashCommandPaser implements SlashCommandParser<Update> {
    @Override
    @NonNull
    public Optional<String> parse(@NonNull Update input) {
        if (input.getMessage() != null) {
            Optional<String> result = parse(input.getMessage());
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();
    }

    @NonNull
    private Optional<String> parse(@NonNull Message message) {
        String text = message.getText();
        if (StringUtils.isNotEmpty(text)) {
            int index = text.indexOf("/");
            if (index != -1) {
                String result = text.substring(index);
                index = result.indexOf("@");
                if (index != -1) {
                    result = text.substring(0, index);
                }
                return Optional.of(result);
            }
        }
        return Optional.empty();
    }
}
