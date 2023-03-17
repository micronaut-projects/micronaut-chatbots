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
class ChatPermissionsSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ChatPermissions is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ChatPermissions))

        then:
        noExceptionThrown()
    }

    void "ChatPermissions is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ChatPermissions))

        then:
        noExceptionThrown()
    }

    void "ChatPermissions is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ChatPermissions)

        then:
        noExceptionThrown()
    }

    void "ChatPermissions::toString() does not throw NPE"() {
        when:
        new ChatPermissions().toString()

        then:
        noExceptionThrown()
    }

    void "valid ChatPermissions does not trigger any constraint exception"() {
        when:
        ChatPermissions el = validChatPermissions()

        then:
        validator.validate(el).isEmpty()
    }

    static ChatPermissions validChatPermissions() {
        ChatPermissions el = new ChatPermissions()
        el.canSendMessages = null
        el.canSendMediaMessages = null
        el.canSendPolls = null
        el.canSendOtherMessages = null
        el.canAddWebPagePreviews = null
        el.canChangeInfo = null
        el.canInviteUsers = null
        el.canPinMessages = null
        el
    }
}
