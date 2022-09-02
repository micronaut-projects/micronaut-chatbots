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
package io.micronaut.chatbots.lambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.micronaut.chatbots.core.BotConfiguration;
import io.micronaut.chatbots.core.Dispatcher;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.ApplicationContextBuilder;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.reflect.GenericTypeUtils;
import io.micronaut.core.util.ArrayUtils;
import io.micronaut.function.aws.MicronautRequestHandler;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.serde.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

/**
 * Abstract class to handle a Chatbots webhook in an AWS Lambda Handler.
 * @author Sergio del Amo
 * @param <B> The Bot configuration
 * @param <I> input type.
 * @since 1.0.0
 */
public abstract class AbstractHandler<B extends BotConfiguration, I>
    extends MicronautRequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractHandler.class);

    @SuppressWarnings("unchecked")
    private final Class<I> inputType = initTypeArgument(1);

    /**
     * Default constructor; will initialize a suitable ApplicationContext for Lambda deployment.
     */
    protected AbstractHandler() {
        super();
    }

    /**
     * Constructor used to inject a preexisting {@link ApplicationContext}.
     * @param applicationContext the application context
     */
    protected AbstractHandler(ApplicationContext applicationContext) {
        super(applicationContext);
    }

    /**
     * Constructor used to inject a preexisting {@link ApplicationContextBuilder}.
     * @param applicationContextBuilder the application context builder
     */
    protected AbstractHandler(ApplicationContextBuilder applicationContextBuilder) {
        super(applicationContextBuilder);
    }

    @Override
    public APIGatewayProxyResponseEvent execute(APIGatewayProxyRequestEvent request) {
        if (LOG.isTraceEnabled()) {
            LOG.trace("{}", request);
        }
        return validate(request).map(bot -> {
            try {
                return getDispatcher().dispatch(bot, getObjectMapper().readValue(request.getBody(), inputType))
                    .map(this::okJson)
                    .orElseGet(this::ok);
            } catch (Exception e) {
                if (LOG.isErrorEnabled()) {
                    LOG.error("exception dispatching update", e);
                }
                return serverError();
            }
        }).orElseGet(this::unauthorized);

    }

    /**
     *
     * @param request API Gateway Request
     * @return The Bot associated to the request
     */
    @NonNull
    protected abstract Optional<B> validate(@NonNull APIGatewayProxyRequestEvent request);

    /**
     *
     * @return The Object Mapper
     */
    @NonNull
    protected abstract ObjectMapper getObjectMapper();

    /**
     *
     * @return The Dispatcher
     */
    @NonNull
    protected abstract Dispatcher<B, I, ?> getDispatcher();

    /**
     *
     * @return Returns a 200 response
     */
    @NonNull
    protected APIGatewayProxyResponseEvent ok() {
        return response(HttpStatus.OK);
    }

    /**
     *
     * @return Returns a 401 response
     */
    @NonNull
    protected APIGatewayProxyResponseEvent unauthorized() {
        return response(HttpStatus.UNAUTHORIZED);
    }

    /**
     *
     * @return Returns a 500 response
     */
    @NonNull
    protected APIGatewayProxyResponseEvent serverError() {
        return response(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param httpStatus HTTP Status
     * @return Returns a 500 response
     */
    protected APIGatewayProxyResponseEvent response(HttpStatus httpStatus) {
        APIGatewayProxyResponseEvent apiGatewayProxyResponseEvent = new APIGatewayProxyResponseEvent();
        apiGatewayProxyResponseEvent.setStatusCode(httpStatus.getCode());
        return apiGatewayProxyResponseEvent;
    }

    /**
     *
     * @param body The Body to be serialized as JSoN
     * @return Returns a 200 response
     */
    @NonNull
    protected APIGatewayProxyResponseEvent okJson(@NonNull Object body) {
        try {
            APIGatewayProxyResponseEvent response = response(HttpStatus.OK);
            response.setHeaders(Collections.singletonMap(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
            response.setBody(getObjectMapper().writeValueAsString(body));
            return response;
        } catch (IOException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("Error serializing response to JSON", e);
            }
            return serverError();
        }
    }

    @NonNull
    private Class initTypeArgument(int index) {
        final Class[] args = GenericTypeUtils.resolveSuperTypeGenericArguments(
            getClass(),
            AbstractHandler.class
        );
        if (ArrayUtils.isNotEmpty(args) && args.length > index) {
            return args[index];
        } else {
            return Object.class;
        }
    }
}
