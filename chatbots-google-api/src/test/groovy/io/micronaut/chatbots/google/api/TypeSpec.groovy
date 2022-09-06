package io.micronaut.chatbots.google.api

import spock.lang.Specification

class TypeSpec extends Specification {

    void "Type::toString() return enum name"(Type type, String expected) {
        expect:
        expected == type.toString()

        where:
        type                  | expected
        Type.ROOM             | 'ROOM'
        Type.DM               | 'DM'
        Type.TYPE_UNSPECIFIED | 'TYPE_UNSPECIFIED'

    }
}
