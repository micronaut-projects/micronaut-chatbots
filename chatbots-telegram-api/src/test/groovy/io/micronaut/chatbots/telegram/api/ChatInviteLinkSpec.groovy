package io.micronaut.chatbots.telegram.api

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.context.BeanContext
import io.micronaut.core.beans.BeanIntrospection
import io.micronaut.core.type.Argument
import io.micronaut.serde.ObjectMapper
import io.micronaut.serde.SerdeIntrospections
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import javax.validation.Valid
import javax.validation.Validator
import javax.validation.constraints.NotNull

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
        ChatInviteLink el = new ChatInviteLink()
        el.inviteLink = 'x'
        el.creator = validUser()
        el.createsJoinRequest = false
        el.primary = false
        el.revoked = false
        el
    }

    static User validUser() {
        User el = new User()
        el.id = 1L
        el.bot = false
        el.firstName = "foo"
        el
    }
}
