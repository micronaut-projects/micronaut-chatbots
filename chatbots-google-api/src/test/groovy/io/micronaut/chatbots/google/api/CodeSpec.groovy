package io.micronaut.chatbots.google.api

import spock.lang.Specification
import spock.lang.Unroll

class CodeSpec extends Specification {

    @Unroll("#code => #expected")
    void "HTTP Representation Code"(Code code, int expected) {
        expect:
        expected == code.toHttpStatusCode()

        where:
        code                        | expected
        Code.OK                     | 200
        Code.CANCELLED              | 499
        Code.UNKNOWN                | 500
        Code.INVALID_ARGUMENT       | 400
        Code.DEADLINE_EXCEEDED      | 504
        Code.NOT_FOUND              | 404
        Code.ALREADY_EXISTS         | 409
        Code.PERMISSION_DENIED      | 403
        Code.UNAUTHENTICATED        | 401
        Code.RESOURCE_EXHAUSTED     | 429
        Code.FAILED_PRECONDITION    | 400
        Code.ABORTED                | 409
        Code.OUT_OF_RANGE           | 400
        Code.UNIMPLEMENTED          | 501
        Code.INTERNAL               | 500
        Code.UNAVAILABLE            | 503
        Code.DATA_LOSS              | 500
    }
}
