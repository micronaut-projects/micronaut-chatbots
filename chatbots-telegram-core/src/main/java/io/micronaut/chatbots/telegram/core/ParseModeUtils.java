/*
 * Copyright 2017-2023 original authors
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

import io.micronaut.chatbots.core.FileExtension;
import io.micronaut.chatbots.telegram.api.send.ParseMode;
import io.micronaut.core.annotation.NonNull;

import java.util.Optional;

/**
 * Utility methods for {@link ParseMode}.
 * @author Sergio del Amo
 * @since 1.0.0
 */
public final class ParseModeUtils {

    private ParseModeUtils() {
    }

    /**
     * Returns a ParseMode for a FileExtension.
     * @param fileExtension File Extension
     * @return a Telegram ParseMode
     */
    @NonNull
    public static Optional<ParseMode> parseModeOfFileExtension(@NonNull FileExtension fileExtension) {
        if (fileExtension == FileExtension.HTML) {
            return Optional.of(ParseMode.HTML);
        }
        return Optional.of(ParseMode.MARKDOWN);
    }
}
