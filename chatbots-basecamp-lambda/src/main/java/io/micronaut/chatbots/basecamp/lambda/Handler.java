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
package io.micronaut.chatbots.basecamp.lambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.micronaut.chatbots.basecamp.api.Query;
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration;
import io.micronaut.chatbots.core.Dispatcher;
import io.micronaut.chatbots.lambda.AbstractHandler;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.ApplicationContextBuilder;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpHeaders;
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
public class Handler extends AbstractHandler<BasecampBotConfiguration, Query, String> {
    private static final Logger LOG = LoggerFactory.getLogger(Handler.class);
    @Inject
    ObjectMapper objectMapper;

    @Inject
    Dispatcher<BasecampBotConfiguration, Query, String> dispatcher;

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
        return parseHeader(request, HttpHeaders.USER_AGENT)
            .map(value -> {
                boolean result = value.contains("Basecamp");
                if (result) {
                    LOG.trace("HTTP Header {}: {}", HttpHeaders.USER_AGENT, value);
                } else {
                    LOG.warn("Rejecting request because HTTP Header {}: {} does not contain the word Basecamp", HttpHeaders.USER_AGENT, value);
                }
                return result;
            })
        .orElseGet( () -> {
                LOG.warn("Rejecting request because HTTP Header {} not present", HttpHeaders.USER_AGENT);
                return false;
            });
    }

    @Override
    @NonNull
    protected Optional<BasecampBotConfiguration> parseBot(@NonNull APIGatewayProxyRequestEvent request) {
        return Optional.empty();
    }

    @NonNull
    @Override
    protected APIGatewayProxyResponseEvent okSerializer(@NonNull Object body) {
        return okHtml(body);
    }

    @Override
    @NonNull
    protected ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override
    @NonNull
    protected Dispatcher<BasecampBotConfiguration, Query, String> getDispatcher() {
        return this.dispatcher;
    }

}
