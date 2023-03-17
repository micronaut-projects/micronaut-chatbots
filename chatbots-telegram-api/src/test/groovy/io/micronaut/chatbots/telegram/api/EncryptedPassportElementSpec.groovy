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
class EncryptedPassportElementSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "io.micronaut.chatbots.telegram.core.EncryptedPassportElement is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(EncryptedPassportElement))

        then:
        noExceptionThrown()
    }

    void "io.micronaut.chatbots.telegram.core.EncryptedPassportElement is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(EncryptedPassportElement))

        then:
        noExceptionThrown()
    }

    void "io.micronaut.chatbots.telegram.core.EncryptedPassportElement is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(EncryptedPassportElement)

        then:
        noExceptionThrown()
    }

    void "io.micronaut.chatbots.telegram.core.EncryptedPassportElement::toString() does not throw NPE"() {
        when:
        new EncryptedPassportElement().toString()

        then:
        noExceptionThrown()
    }

    void "valid EncryptedPassportElement does not trigger any constraint exception"() {
        when:
        EncryptedPassportElement el = validEncryptedPassportElement()

        then:
        validator.validate(el).isEmpty()
    }

    static EncryptedPassportElement validEncryptedPassportElement() {
        EncryptedPassportElement el = new EncryptedPassportElement()
        el.type = "passport"
        el.data = null
        el.phoneNumber = null
        el.email = null
        el.files = null
        el.frontSide = null
        el.reverseSide = null
        el.selfie = null
        el.translation = null
        el.hash = "x"
        el
    }
}
