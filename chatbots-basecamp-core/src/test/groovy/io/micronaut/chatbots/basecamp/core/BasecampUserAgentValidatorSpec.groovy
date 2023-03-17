package io.micronaut.chatbots.basecamp.core

import spock.lang.Specification

class BasecampUserAgentValidatorSpec extends Specification {

    void "validate user-agent"(String userAgent) {
        expect:
        expected == BasecampUserAgentValidator.validateUserAgent(userAgent)

        where:
        userAgent               || expected
        null                    || false
        ''                      || false
        'Basecamp request'      || true
        'Foobar'                || false
        'foo Basecamp request'  || true

    }
}
