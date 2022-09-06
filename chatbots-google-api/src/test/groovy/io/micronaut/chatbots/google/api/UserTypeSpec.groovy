package io.micronaut.chatbots.google.api

import spock.lang.Specification

class UserTypeSpec extends Specification {

    void "UserType::toString() return enum name"(UserType type, String expected) {
        expect:
        expected == type.toString()

        where:
        type                      | expected
        UserType.BOT              | 'BOT'
        UserType.HUMAN            | 'HUMAN'
        UserType.TYPE_UNSPECIFIED | 'TYPE_UNSPECIFIED'

    }
}
