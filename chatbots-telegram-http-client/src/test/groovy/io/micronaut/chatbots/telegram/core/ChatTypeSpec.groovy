package io.micronaut.chatbots.telegram.core

import spock.lang.Specification

class ChatTypeSpec extends Specification {

    void "ChatType::toString() returns lowercase string"(ChatType type) {
        expect:
        expected == type.toString()
        where:
        type                | expected
        ChatType.PRIVATE    | 'private'
        ChatType.GROUP      | 'group'
        ChatType.SUPERGROUP | 'supergroup'
        ChatType.CHANNEL    | 'channel'
    }
}
