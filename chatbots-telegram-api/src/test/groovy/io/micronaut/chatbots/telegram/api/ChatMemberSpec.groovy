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
class ChatMemberSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ChatMember is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ChatMember))

        then:
        noExceptionThrown()
    }

    void "ChatMember is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ChatMember))

        then:
        noExceptionThrown()
    }

    void "ChatMember is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ChatMember)

        then:
        noExceptionThrown()
    }

    void "ChatMember::toString() does not throw NPE"() {
        when:
        new ChatMember().toString()

        then:
        noExceptionThrown()
    }

    void "valid ChatMember does not trigger any constraint exception"() {
        when:
        ChatMember el = validChatMember()

        then:
        validator.validate(el).isEmpty()
    }

    static ChatMember validChatMember() {
        new ChatMember().tap {
            user = validUser()
            status = "member"
            customTitle = null
            untilDate = null
            canBeEdited = null
            canPostMessages = null
            canEditMessages = null
            canDeleteMessages = null
            canRestrictMembers = null
            canPromoteMembers = null
            canChangeInfo = null
            canInviteUsers = null
            canPinMessages = null
            member = null
            canSendMessages = null
            canSendMediaMessages = null
            canSendPolls = null
            canSendOtherMessages = null
            canAddWebPagePreviews = null
        }
    }

    static User validUser() {
        new User().tap {
            id = 1L
            bot = false
            firstName = "foo"
        }
    }
}
