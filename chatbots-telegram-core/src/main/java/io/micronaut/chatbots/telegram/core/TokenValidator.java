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

import io.micronaut.context.annotation.DefaultImplementation;
import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

/**
 * API to validate a token provided the Bot Father and return the Bot's configuration.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@DefaultImplementation(DefaultTokenValidator.class)
@FunctionalInterface
public interface TokenValidator {
    String X_TELEGRAM_BOT_API_SECRET_TOKEN = "X-Telegram-Bot-Api-Secret-Token";

    /**
     *
     * @param token Telegram Token as returned by the Bot Father.
     * @return Returns the {@link TelegramBotConfiguration} associated to the token. If the token is not associated with any Telegram bot an empty optional is returned.
     */
    @NonNull
    Optional<TelegramBotConfiguration> validate(@NonNull @NotBlank String token);
}
