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
package io.micronaut.chatbots.basecamp.googlecloud;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import io.micronaut.chatbots.basecamp.api.Query;
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration;
import io.micronaut.chatbots.core.Dispatcher;
import io.micronaut.function.executor.FunctionInitializer;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * {@link HttpFunction} for Basecamp Bot webhook.
 * @author Sergio del Amo
 * @since 1.0.0
 */
public class Handler extends FunctionInitializer implements HttpFunction {
    private static final Logger LOG = LoggerFactory.getLogger(Handler.class);

    @Inject
    Dispatcher<BasecampBotConfiguration, Query, String> dispatcher;

    @Inject
    ObjectMapper objectMapper;

    @Override
    public void service(HttpRequest request, HttpResponse response) throws Exception {
        Query query = objectMapper.readValue(request.getInputStream(), Query.class);
        int statusCode;
        if (query == null) {
            LOG.warn("could not serialize request to Query");
            statusCode = HttpStatus.UNPROCESSABLE_ENTITY.getCode();
        } else {
            Optional<String> htmlOptional = dispatcher.dispatch(null, query);
            if (htmlOptional.isPresent()) {
                String html = htmlOptional.get();
                response.setContentType(MediaType.TEXT_HTML);
                response.getOutputStream().write(html.getBytes(StandardCharsets.UTF_8));
            }
            statusCode = HttpStatus.OK.getCode();
        }
        response.setStatusCode(statusCode);
    }
}
