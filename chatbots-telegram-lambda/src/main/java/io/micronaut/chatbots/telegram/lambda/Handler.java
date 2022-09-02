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
package io.micronaut.chatbots.telegram.lambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import io.micronaut.chatbots.core.Dispatcher;
import io.micronaut.chatbots.lambda.AbstractHandler;
import io.micronaut.chatbots.telegram.api.Update;
import io.micronaut.chatbots.telegram.api.send.Send;
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration;
import io.micronaut.chatbots.telegram.core.TokenValidator;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.ApplicationContextBuilder;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Optional;

/**
 * AWS Lambda Handler for a Telegram Bot Webhook.
 * @author Sergio del Amo
 * @since 1.0.0
 */
public class Handler extends AbstractHandler<TelegramBotConfiguration, Update, Send> {
    private static final Logger LOG = LoggerFactory.getLogger(Handler.class);
    private static final String X_TELEGRAM_BOT_API_SECRET_TOKEN = "X-Telegram-Bot-Api-Secret-Token";

    @Inject
    TokenValidator tokenValidator;

    @Inject
    ObjectMapper objectMapper;

    @Inject
    Dispatcher<TelegramBotConfiguration, Update, Send> dispatcher;

    /**
     * Default constructor; will initialize a suitable ApplicationContext for Lambda deployment.
     */
    public Handler() {
        super();
    }

    /**
     * Constructor used to inject a preexisting {@link ApplicationContext}.
     * @param applicationContext the application context
     */
    public Handler(ApplicationContext applicationContext) {
        super(applicationContext);
    }

    /**
     * Constructor used to inject a preexisting {@link ApplicationContextBuilder}.
     * @param applicationContextBuilder the application context builder
     */
    public Handler(ApplicationContextBuilder applicationContextBuilder) {
        super(applicationContextBuilder);
    }

    @Override
    @NonNull
    protected Optional<TelegramBotConfiguration> validate(@NonNull APIGatewayProxyRequestEvent request) {
        Optional<String> tokenOptional = parseToken(request);
        if (!tokenOptional.isPresent()) {
            if (LOG.isTraceEnabled()) {
                LOG.trace("not token found");
            }
            return Optional.empty();
        }
        String token = tokenOptional.get();
        Optional<TelegramBotConfiguration> botOptional = tokenValidator.validate(token);
        if (!botOptional.isPresent()) {
            if (LOG.isTraceEnabled()) {
                LOG.trace("not bot with token that matches token {}", token);
            }
            return Optional.empty();
        }
        return botOptional;
    }

    /**
     *
     * @param request The API Gateway Request
     * @return The Token
     */
    @NonNull
    protected Optional<String> parseToken(@NonNull APIGatewayProxyRequestEvent request) {
        if (request.getHeaders() == null) {
            return Optional.empty();
        }
        String header = request.getHeaders().get(X_TELEGRAM_BOT_API_SECRET_TOKEN);
        if (header != null) {
            return Optional.of(header);
        }
        return Optional.ofNullable(request.getHeaders().get(X_TELEGRAM_BOT_API_SECRET_TOKEN.toLowerCase(Locale.ROOT)));
    }

    @Override
    @NonNull
    protected ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override
    @NonNull
    protected Dispatcher<TelegramBotConfiguration, Update, Send> getDispatcher() {
        return this.dispatcher;
    }

}
