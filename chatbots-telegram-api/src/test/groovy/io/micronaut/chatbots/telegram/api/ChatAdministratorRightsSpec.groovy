package io.micronaut.chatbots.telegram.api

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.context.BeanContext
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.beans.BeanIntrospection
import io.micronaut.core.type.Argument
import io.micronaut.serde.ObjectMapper
import io.micronaut.serde.SerdeIntrospections
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import javax.validation.Validator
import javax.validation.constraints.NotNull

@MicronautTest(startApplication = false)
class ChatAdministratorRightsSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ChatAdministratorRights is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ChatAdministratorRights))

        then:
        noExceptionThrown()
    }

    void "ChatAdministratorRights is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ChatAdministratorRights))

        then:
        noExceptionThrown()
    }

    void "ChatAdministratorRights is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ChatAdministratorRights)

        then:
        noExceptionThrown()
    }

    void "ChatAdministratorRights::toString() does not throw NPE"() {
        when:
        new ChatAdministratorRights().toString()

        then:
        noExceptionThrown()
    }

    void "valid ChatAdministratorRights does not trigger any constraint exception"() {
        when:
        ChatAdministratorRights el = validChatAdministratorRights()

        then:
        validator.validate(el).isEmpty()
    }

    static ChatAdministratorRights validChatAdministratorRights() {
        ChatAdministratorRights el = new ChatAdministratorRights()
        el.anonymous = false
        el.canManageChat = false
        el.canDeleteMessages = false
        el.canManageVideoChats = false
        el.canRestrictMembers = false
        el.canPromoteMembers = false
        el.canChangeInfo = false
        el.canInviteUsers = false
        el
    }
}
