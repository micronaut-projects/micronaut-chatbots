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
package io.micronaut.chatbots.telegram.http;

import io.micronaut.chatbots.core.Dispatcher;
import io.micronaut.chatbots.telegram.api.Update;
import io.micronaut.chatbots.telegram.api.send.Send;
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration;
import io.micronaut.chatbots.telegram.core.TokenValidator;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Defines a route to handle the Telegram Chatbot webhook.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Requires(beans = {TokenValidator.class, Dispatcher.class, TelegramBotConfiguration.class})
@Requires(property = TelegramControllerConfiguration.PREFIX + ".enabled", notEquals = StringUtils.FALSE, defaultValue = StringUtils.TRUE)
@Controller("${" + TelegramControllerConfiguration.PREFIX + ".path:" + TelegramControllerConfiguration.DEFAULT_PATH + "}")
public class TelegramController {
    private static final Logger LOG = LoggerFactory.getLogger(TelegramController.class);
    private final TokenValidator tokenValidator;
    private final Dispatcher<TelegramBotConfiguration, Update, Send> dispatcher;

    /**
     *
     * @param tokenValidator TokenValidator
     * @param dispatcher Message dispatcher
     */
    public TelegramController(TokenValidator tokenValidator,
                              Dispatcher<TelegramBotConfiguration, Update, Send> dispatcher) {
        this.tokenValidator = tokenValidator;
        this.dispatcher = dispatcher;
    }

    /**
     * @see <a href="https://core.telegram.org/bots/api#setwebhook">setWebhook</a>
     * @param apiSecretToken A secret token to be sent in a header “X-Telegram-Bot-Api-Secret-Token” in every webhook request.
     * @param update Telegram Message
     * @return HTTP Response. It could 200 OK with an empty body if the request is handle asynchronously or a 200 with the response payload if the request is handled synchronously.
     */
    @Post
    public HttpResponse<Send> callback(@Header(TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN) String apiSecretToken,
                                    @Body Update update) {
        Optional<TelegramBotConfiguration> botOptional = tokenValidator.validate(apiSecretToken);
        if (botOptional.isEmpty()) {
            LOG.trace("not bot with token that matches token");
            return HttpResponse.unauthorized();
        }
        return dispatcher.dispatch(botOptional.get(), update)
            .map(HttpResponse::ok)
            .orElseGet(HttpResponse::ok);
    }
}
