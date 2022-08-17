package io.micronaut.chatbots.telegram.core

import io.micronaut.chatbots.telegram.core.TokenValidator
import io.micronaut.context.annotation.Property
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@Property(name = "micronaut.chatbots.telegram.bots.c3po.token", value = "ZZZ")
@Property(name = "micronaut.chatbots.telegram.bots.c3po.at-username", value = "@C3P0")
@Property(name = "micronaut.chatbots.telegram.bots.r2d2.token", value = "XXX")
@Property(name = "micronaut.chatbots.telegram.bots.r2d2.at-username", value = "@R2D2")
@MicronautTest(startApplication = false)
class TokenValidatorSpec extends Specification {

    @Inject
    TokenValidator validator

    void "for invalid token empty optional is returned"() {
        expect:
        !validator.validate("YYY").isPresent()
        'r2d2' == validator.validate("XXX").get().name
    }
}
