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
        ChatMember el = new ChatMember()
        el.user = validUser()
        el.status = "member"
        el.customTitle = null
        el.untilDate = null
        el.canBeEdited = null
        el.canPostMessages = null
        el.canEditMessages = null
        el.canDeleteMessages = null
        el.canRestrictMembers = null
        el.canPromoteMembers = null
        el.canChangeInfo = null
        el.canInviteUsers = null
        el.canPinMessages = null
        el.member = null
        el.canSendMessages = null
        el.canSendMediaMessages = null
        el.canSendPolls = null
        el.canSendOtherMessages = null
        el.canAddWebPagePreviews = null
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
