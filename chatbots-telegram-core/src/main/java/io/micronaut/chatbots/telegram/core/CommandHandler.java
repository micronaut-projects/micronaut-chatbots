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
import io.micronaut.chatbots.core.TextResourceLoader;
import io.micronaut.chatbots.telegram.api.Chat;
import io.micronaut.chatbots.telegram.api.Update;
import io.micronaut.chatbots.telegram.api.send.SendMessage;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Abstract class to make easy to respond static content for a Telegram Bot command.
 * @author Sergio del Amo
 * @since 1.0.0
 */
public abstract class CommandHandler implements TelegramHandler<SendMessage> {

    private final TelegramSlashCommandParser slashCommandParser;
    private final TextResourceLoader textResourceLoader;
    private final SpaceParser<Update, Chat> spaceParser;

    protected CommandHandler(TelegramSlashCommandParser slashCommandParser,
                             TextResourceLoader textResourceLoader,
                             SpaceParser<Update, Chat> spaceParser) {
        this.slashCommandParser = slashCommandParser;
        this.textResourceLoader = textResourceLoader;
        this.spaceParser = spaceParser;
    }

    /**
     *
     * @return A slash command. E.g. /help
     */
    @NonNull
    public abstract String getCommand();

    @Override
    public boolean canHandle(@Nullable TelegramBotConfiguration bot,
                             @NonNull @NotNull Update input) {
        return slashCommandParser.parse(input)
                .filter(command -> command.startsWith(getCommand()))
                .isPresent();
    }

    @Override
    @NonNull
    public Optional<SendMessage> handle(@Nullable TelegramBotConfiguration bot,
                                        @NonNull @NotNull Update input) {
        return slashCommandParser.parse(input)
                .flatMap(textResourceLoader::composeCommandResponse)
                .flatMap(commandResponse ->
                    SendMessageUtils.compose(spaceParser,
                        input,
                        commandResponse.getText(),
                        ParseModeUtils.parseModeOfFileExtension(commandResponse.getExtension()).orElse(null)));
    }

    @Override
    public int getOrder() {
        return -10;
    }
}
