package io.micronaut.chatbots.telegram.api

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
class InlineKeyboardMarkupSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "InlineKeyboardMarkup is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(InlineKeyboardMarkup))

        then:
        noExceptionThrown()
    }

    void "InlineKeyboardMarkup is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(InlineKeyboardMarkup))

        then:
        noExceptionThrown()
    }

    void "InlineKeyboardMarkup is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(InlineKeyboardMarkup)

        then:
        noExceptionThrown()
    }

    void "InlineKeyboardMarkup::toString() does not throw NPE"() {
        when:
        new Invoice().toString()

        then:
        noExceptionThrown()
    }

    void "valid InlineKeyboardMarkup does not trigger any constraint exception"() {
        when:
        InlineKeyboardMarkup el = validInlineKeyboardMarkup()

        then:
        validator.validate(el).isEmpty()
    }

    static InlineKeyboardMarkup validInlineKeyboardMarkup() {
        InlineKeyboardMarkup el = new InlineKeyboardMarkup()
        el.inlineKeyboard = []
        el
    }
}
