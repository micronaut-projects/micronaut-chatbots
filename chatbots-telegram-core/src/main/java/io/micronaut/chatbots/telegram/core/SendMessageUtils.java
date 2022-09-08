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

import io.micronaut.chatbots.core.SpaceParser;
import io.micronaut.chatbots.telegram.api.Chat;
import io.micronaut.chatbots.telegram.api.Update;
import io.micronaut.chatbots.telegram.api.send.ParseMode;
import io.micronaut.chatbots.telegram.api.send.SendMessage;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;

import java.util.Optional;

/**
 *
 * @author Sergio del Amo
 * @since 1.0.0
 */
public final class SendMessageUtils {

    private SendMessageUtils() {
    }

    @NonNull
    public static Optional<SendMessage> compose(@NonNull SpaceParser<Update, Chat> spaceParser,
                                                @NonNull Update update,
                                                @NonNull String text) {
        return compose(spaceParser, update, text, null);
    }

    @NonNull
    public static Optional<SendMessage> compose(@NonNull SpaceParser<Update, Chat> spaceParser,
                                                @NonNull Update update,
                                                @NonNull String text,
                                                @Nullable ParseMode parseMode) {
        return spaceParser.parse(update)
                .map(space -> compose(space, text, parseMode));
    }

    @NonNull
    public static SendMessage compose(@NonNull Chat space,
                                      @NonNull String text,
                                      @Nullable ParseMode parseMode) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setChatId(space.getId());
        message.setParseMode(parseMode == null ? null : parseMode.toString());
        return message;
    }
}
