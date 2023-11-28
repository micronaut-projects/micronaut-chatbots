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
package io.micronaut.chatbots.telegram.lambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
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
import java.util.Optional;

/**
 * AWS Lambda Handler for a Telegram Bot Webhook.
 * @author Sergio del Amo
 * @since 1.0.0
 */
public class Handler extends AbstractHandler<TelegramBotConfiguration, Update, Send> {
    private static final Logger LOG = LoggerFactory.getLogger(Handler.class);
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
    protected boolean validate(@NonNull APIGatewayProxyRequestEvent request) {
        return parseBot(request).isPresent();
    }

    @Override
    @NonNull
    protected Optional<TelegramBotConfiguration> parseBot(@NonNull APIGatewayProxyRequestEvent request) {
        Optional<String> tokenOptional = parseToken(request);
        if (tokenOptional.isEmpty()) {
            if (LOG.isTraceEnabled()) {
                LOG.trace("not token found");
            }
            return Optional.empty();
        }
        String token = tokenOptional.get();
        Optional<TelegramBotConfiguration> botOptional = tokenValidator.validate(token);
        if (botOptional.isEmpty()) {
            if (LOG.isTraceEnabled()) {
                LOG.trace("not bot with token that matches token {}", token);
            }
            return Optional.empty();
        }
        return botOptional;
    }

    @NonNull
    @Override
    protected APIGatewayProxyResponseEvent okSerializer(@NonNull Object body) {
        return okJson(body);
    }

    /**
     *
     * @param request The API Gateway Request
     * @return The Token
     */
    @NonNull
    protected Optional<String> parseToken(@NonNull APIGatewayProxyRequestEvent request) {
        return parseHeader(request, TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN);
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
