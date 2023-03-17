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
package io.micronaut.chatbots.telegram.azurefunction;

import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import io.micronaut.azure.function.AzureFunction;
import io.micronaut.chatbots.core.Dispatcher;
import io.micronaut.chatbots.telegram.api.Update;
import io.micronaut.chatbots.telegram.api.send.Send;
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration;
import io.micronaut.chatbots.telegram.core.TokenValidator;
import jakarta.inject.Inject;

import java.util.Optional;

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
        ExecutionContext context) {
        info("Executing Function: " + getClass().getName(), context);
        if (!request.getHeaders().containsKey(TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN)) {
            info("Token not found in header " + TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN, context);
            return request.createResponseBuilder(HttpStatus.UNAUTHORIZED).build();
        }
        String token = request.getHeaders().get(TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN);
        Optional<TelegramBotConfiguration> botOptional = tokenValidator.validate(token);
        if (!botOptional.isPresent()) {
            info("BotConfiguration not found for header " + TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN, context);
            return request.createResponseBuilder(HttpStatus.UNAUTHORIZED).build();
        }
        TelegramBotConfiguration bot = botOptional.get();
        return dispatcher.dispatch(bot, request.getBody())
            .map(rsp -> request.createResponseBuilder(HttpStatus.OK).body(rsp).build())
            .orElseGet(() -> request.createResponseBuilder(HttpStatus.OK).build());
    }

    private void info(String message, ExecutionContext context) {
        if (context != null) {
            context.getLogger().info(message);
        }
    }
}

