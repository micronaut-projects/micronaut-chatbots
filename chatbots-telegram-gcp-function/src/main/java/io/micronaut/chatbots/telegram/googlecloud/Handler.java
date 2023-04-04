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
package io.micronaut.chatbots.telegram.googlecloud;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import io.micronaut.chatbots.core.Dispatcher;
import io.micronaut.chatbots.telegram.api.Update;
import io.micronaut.chatbots.telegram.api.send.Send;
import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration;
import io.micronaut.chatbots.telegram.core.TokenValidator;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.function.executor.FunctionInitializer;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * {@link HttpFunction} for Telegram Bot webhook.
 * @author Sergio del Amo
 * @since 1.0.0
 */
public class Handler extends FunctionInitializer implements HttpFunction {
    private static final Logger LOG = LoggerFactory.getLogger(Handler.class);

    @Inject
    TokenValidator tokenValidator;

    @Inject
    Dispatcher<TelegramBotConfiguration, Update, Send> dispatcher;

    @Inject
    ObjectMapper objectMapper;

    @Override
    public void service(HttpRequest request, HttpResponse response) throws Exception {
        Optional<List<String>> headerValues = parseHeader(request, TokenValidator.X_TELEGRAM_BOT_API_SECRET_TOKEN);
        int statusCode = HttpStatus.UNAUTHORIZED.getCode();
        if (headerValues.isPresent()) {
            for (String token : headerValues.get()) {
                Optional<TelegramBotConfiguration> botOptional = tokenValidator.validate(token);
                if (botOptional.isPresent()) {
                    TelegramBotConfiguration bot = botOptional.get();
                    try {
                        Update update = objectMapper.readValue(request.getInputStream(), Update.class);
                        if (update == null) {
                            LOG.warn("could not serialize request to Update");
                            statusCode = HttpStatus.UNPROCESSABLE_ENTITY.getCode();
                            break;
                        }
                        Optional<Send> sendOptional = dispatcher.dispatch(bot, update);
                        if (sendOptional.isPresent()) {
                            Send send = sendOptional.get();
                            response.setContentType(MediaType.APPLICATION_JSON);
                            OutputStream outputStream = response.getOutputStream();
                            objectMapper.writeValue(outputStream, send);
                        }
                        statusCode = HttpStatus.OK.getCode();
                        break;
                    } catch (IOException e) {
                        LOG.error("IOException serialiazing/deserializaing", e);
                        statusCode = HttpStatus.INTERNAL_SERVER_ERROR.getCode();
                        break;
                    }
                }
            }
        }
        response.setStatusCode(statusCode);
    }

    /**
     * Retrieves a header value using the supplied header name as the key and the lower case variation of the header name parameter.
     * @param request The API Gateway Request
     * @param headerName HTTP Header Name
     * @return The Header Value
     */
    @NonNull
    private Optional<List<String>> parseHeader(@NonNull HttpRequest request,
                                                 @NonNull String headerName) {
        if (request.getHeaders() == null) {
            return Optional.empty();
        }
        List<String> header = request.getHeaders().get(headerName);
        if (header != null) {
            return Optional.of(header);
        }
        return Optional.ofNullable(request.getHeaders().get(headerName.toLowerCase(Locale.ROOT)));
    }

}
