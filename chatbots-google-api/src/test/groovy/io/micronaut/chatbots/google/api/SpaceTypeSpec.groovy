package io.micronaut.chatbots.google.api

import spock.lang.Specification

class SpaceTypeSpec extends Specification {

    void "SpaceType::toString() return enum name"(SpaceType type, String expected) {
        expect:
        expected == type.toString()

        where:
        type                             | expected
        SpaceType.DIRECT_MESSAGE         | 'DIRECT_MESSAGE'
        SpaceType.GROUP_CHAT             | 'GROUP_CHAT'
        SpaceType.SPACE_TYPE_UNSPECIFIED | 'SPACE_TYPE_UNSPECIFIED'
        SpaceType.SPACE                  | 'SPACE'

    }
}
