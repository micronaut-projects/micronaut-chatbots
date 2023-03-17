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
class KeyboardButtonSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "KeyboardButton is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(KeyboardButton))

        then:
        noExceptionThrown()
    }

    void "KeyboardButton is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(KeyboardButton))

        then:
        noExceptionThrown()
    }

    void "KeyboardButton is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(KeyboardButton)

        then:
        noExceptionThrown()
    }

    void "KeyboardButton::toString() does not throw NPE"() {
        when:
        new KeyboardButton().toString()

        then:
        noExceptionThrown()
    }

    void "valid KeyboardButton does not trigger any constraint exception"() {
        when:
        KeyboardButton el = validKeyboardButton()

        then:
        validator.validate(el).isEmpty()
    }

    static KeyboardButton validKeyboardButton() {
        KeyboardButton el = new KeyboardButton()
        el.text = 'x'
        el.requestContact = null
        el.requestLocation = null
        el.requestPoll = null
        el.webApp = null
        el
    }
}
