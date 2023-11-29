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
package io.micronaut.chatbots.telegram.azurefunction;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import io.micronaut.azure.function.AzureFunction;
import io.micronaut.chatbots.core.Dispatcher;
import io.micronaut.chatbots.telegram.api.Update;
import io.micronaut.chatbots.telegram.api.send.Send;
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration;
import io.micronaut.chatbots.telegram.core.TokenValidator;
import io.micronaut.http.MediaType;
import io.micronaut.json.JsonMapper;
import jakarta.inject.Inject;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import static io.micronaut.http.HttpHeaders.CONTENT_TYPE;

/**
 * Azure function to handle Telegram Webhook.
 * @author Sergio del Amo
 * @since 1.0.0
 */
public class Handler extends AzureFunction {

    @Inject
    TokenValidator tokenValidator;

    @Inject
    Dispatcher<TelegramBotConfiguration, Update, Send> dispatcher;

    @Inject
    JsonMapper jsonMapper;

    /**
     *
     * @param request Request
     * @param context Context
     * @return Webhook response
     */
    @FunctionName("TelegramTrigger")
    public HttpResponseMessage handle(
        @HttpTrigger(
            name = "req",
            methods = {HttpMethod.POST},
            route = "{*route}",
            authLevel = AuthorizationLevel.ANONYMOUS)
        HttpRequestMessage<Update> request,
        ExecutionContext context
    ) {
        info("Executing Function: " + getClass().getName(), context);

        Map<String, String> headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        headers.putAll(request.getHeaders());

        String token = headers.get(TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN);
        if (token == null) {
            error("Token not found in header " + TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN, context);
            return request.createResponseBuilder(HttpStatus.UNAUTHORIZED).build();
        }

        Optional<TelegramBotConfiguration> botOptional = tokenValidator.validate(token);
        if (botOptional.isEmpty()) {
            info("BotConfiguration not found for header " + TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN, context);
            return request.createResponseBuilder(HttpStatus.UNAUTHORIZED).build();
        }

        TelegramBotConfiguration bot = botOptional.get();
        return dispatcher.dispatch(bot, request.getBody())
            .map(send -> getSendHttpResponseMessageFunction(send, request, context))
            .orElseGet(() -> request.createResponseBuilder(HttpStatus.OK).build());
    }

    private HttpResponseMessage getSendHttpResponseMessageFunction(Send response, HttpRequestMessage<Update> request, ExecutionContext context) {
        try {
            return request
                .createResponseBuilder(HttpStatus.OK)
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .body(jsonMapper.writeValueAsString(response))
                .build();
        } catch (IOException ex) {
            error("Error serializing response: " + ex.getMessage(), context);
            return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private void error(String message, ExecutionContext context) {
        if (context != null) {
            context.getLogger().severe(message);
        }
    }

    private void info(String message, ExecutionContext context) {
        if (context != null) {
            context.getLogger().info(message);
        }
    }
}

