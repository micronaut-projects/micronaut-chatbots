package io.micronaut.chatbots.telegram.api.send

import io.micronaut.context.BeanContext
import io.micronaut.core.beans.BeanIntrospection
import io.micronaut.core.type.Argument
import io.micronaut.serde.ObjectMapper
import io.micronaut.serde.SerdeIntrospections
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import javax.validation.Validator

@MicronautTest(startApplication = false)
class SendContactSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendContact is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendContact))

        then:
        noExceptionThrown()
    }

    void "SendContact is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendContact))

        then:
        noExceptionThrown()
    }

    void "SendContact is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendContact)

        then:
        noExceptionThrown()
    }

    void "SendContact::toString() does not throw NPE"() {
        when:
        new SendContact().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendContact does not trigger any constraint exception"() {
        when:
        SendContact el = validSendContact()

        then:
        validator.validate(el).isEmpty()
    }

    static SendContact validSendContact() {
        SendContact el = new SendContact()
        el.chatId = "xx"
        el.firstName = "xx"
        el.phoneNumber = "12345"
        el.vcard = null
        el.lastName = null
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        SendContact el = validSendContact()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
