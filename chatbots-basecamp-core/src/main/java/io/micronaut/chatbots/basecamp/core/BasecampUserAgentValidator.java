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
package io.micronaut.chatbots.basecamp.core;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to validate the {@link HttpHeaders#USER_AGENT} for a Basecamp chatbot webhook.
 * @author Sergio del Amo
 * @since 1.0.0
 */
public final class BasecampUserAgentValidator {
    private static final Logger LOG = LoggerFactory.getLogger(BasecampUserAgentValidator.class);
    private static final String BASECAMP = "Basecamp";

    private BasecampUserAgentValidator() {
    }

    /**
     *
     * @param userAgent HTTP Header User Agent value
     * @return {@literal true} if the User Agent HTTP Header value contains {@value #BASECAMP}.
     */
    public static boolean validateUserAgent(@Nullable String userAgent) {
        if (StringUtils.isEmpty(userAgent)) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("{} not present", HttpHeaders.USER_AGENT);
            }
            return false;
        }
        if (!userAgent.contains(BASECAMP)) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("Rejecting request because HTTP Header {}: {} does not contain the word Basecamp", HttpHeaders.USER_AGENT, userAgent);
            }
            return false;
        }
        if (LOG.isTraceEnabled()) {
            LOG.trace("HTTP Header {}: {}", HttpHeaders.USER_AGENT, userAgent);
        }
        return true;
    }
}
