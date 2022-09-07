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
package io.micronaut.chatbots.basecamp.http;

import io.micronaut.chatbots.basecamp.api.Query;
import io.micronaut.chatbots.basecamp.core.BasecampBotConfiguration;
import io.micronaut.chatbots.core.Dispatcher;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

/**
 * Defines a route to handle the Basecamp Chatbot webhook.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Requires(beans = {Dispatcher.class})
@Requires(property = BasecampControllerConfiguration.PREFIX + ".enabled", notEquals = StringUtils.FALSE, defaultValue = StringUtils.TRUE)
@Controller("${" + BasecampControllerConfiguration.PREFIX + ".path:" + BasecampControllerConfiguration.DEFAULT_PATH + "}")
public class BasecampController {
    private final Dispatcher<BasecampBotConfiguration, Query, String> dispatcher;

    /**
     * Constructor.
     * @param dispatcher Message dispatcher
     */
    public BasecampController(Dispatcher<BasecampBotConfiguration, Query, String> dispatcher) {
        this.dispatcher = dispatcher;
    }

    /**
     * @param update Basecamp Message
     * @return HTTP Response. It could 200 OK with an empty body if the request is handle asynchronously or a 200 with the response payload if the request is handled synchronously.
     */
    @Produces(MediaType.TEXT_HTML)
    @Post
    public HttpResponse<String> callback(@Body Query update) {
        return dispatcher.dispatch(null, update)
            .map(HttpResponse::ok)
            .orElseGet(HttpResponse::ok);
    }
}
