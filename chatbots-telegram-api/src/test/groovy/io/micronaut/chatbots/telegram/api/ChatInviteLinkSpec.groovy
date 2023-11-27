package io.micronaut.chatbots.telegram.api


import io.micronaut.context.BeanContext
import io.micronaut.core.beans.BeanIntrospection
import io.micronaut.core.type.Argument
import io.micronaut.serde.ObjectMapper
import io.micronaut.serde.SerdeIntrospections
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import jakarta.validation.Validator

@MicronautTest(startApplication = false)
class ChatInviteLinkSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ChatInviteLink is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ChatInviteLink))

        then:
        noExceptionThrown()
    }

    void "ChatInviteLink is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ChatInviteLink))

        then:
        noExceptionThrown()
    }

    void "ChatInviteLink is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ChatInviteLink)

        then:
        noExceptionThrown()
    }

    void "ChatInviteLink::toString() does not throw NPE"() {
        when:
        new ChatInviteLink().toString()

        then:
        noExceptionThrown()
    }

    void "valid ChatInviteLink does not trigger any constraint exception"() {
        when:
        ChatInviteLink el = validChatInviteLink()

        then:
        validator.validate(el).isEmpty()
    }

    static ChatInviteLink validChatInviteLink() {
        new ChatInviteLink().tap {
            inviteLink = 'x'
            creator = validUser()
            createsJoinRequest = false
            primary = false
            revoked = false
            pendingJoinRequestCount = null
            memberLimit = null
            expireDate = null
            name = null
        }
    }

    static User validUser() {
        new User().tap {
            id = 1L
            bot = false
            firstName = "foo"
        }
    }

    void "snake case is used for Json serialization"() {
        given:
        ChatInviteLink el = validChatInviteLink()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('invite_link')
        json.contains('creates_join_request')
        json.contains('primary')
        json.contains('revoked')
    }
}
