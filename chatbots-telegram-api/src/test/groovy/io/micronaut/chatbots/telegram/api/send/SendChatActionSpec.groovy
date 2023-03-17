package io.micronaut.chatbots.telegram.api.send

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
class SendChatActionSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendChatAction is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendChatAction))

        then:
        noExceptionThrown()
    }

    void "SendChatAction is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendChatAction))

        then:
        noExceptionThrown()
    }

    void "SendChatAction is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendChatAction)

        then:
        noExceptionThrown()
    }

    void "SendChatAction::toString() does not throw NPE"() {
        when:
        new SendChatAction().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendChatAction does not trigger any constraint exception"() {
        when:
        SendChatAction el = validSendChatAction()

        then:
        validator.validate(el).isEmpty()
    }

    static SendChatAction validSendChatAction() {
        SendChatAction el = new SendChatAction()
        el.chatId = "xx"
        el.action = "y"
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        SendChatAction el = validSendChatAction()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
