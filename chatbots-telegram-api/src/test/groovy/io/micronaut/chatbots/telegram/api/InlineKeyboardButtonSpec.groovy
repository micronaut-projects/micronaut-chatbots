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
class InlineKeyboardButtonSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "InlineKeyboardButton is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(InlineKeyboardButton))

        then:
        noExceptionThrown()
    }

    void "InlineKeyboardButton is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(InlineKeyboardButton))

        then:
        noExceptionThrown()
    }

    void "InlineKeyboardButton is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(InlineKeyboardButton)

        then:
        noExceptionThrown()
    }

    void "InlineKeyboardButton::toString() does not throw NPE"() {
        when:
        new InlineKeyboardButton().toString()

        then:
        noExceptionThrown()
    }

    void "valid InlineKeyboardButton does not trigger any constraint exception"() {
        when:
        InlineKeyboardButton el = validInlineKeyboardButton()

        then:
        validator.validate(el).isEmpty()
    }

    static InlineKeyboardButton validInlineKeyboardButton() {
        new InlineKeyboardButton().tap {
            text = "x"
            url = null
            callbackData = null
            webApp = null
            loginUrl = null
            switchInlineQuery = null
            switchInlineQueryCurrentChat = null
            callbackGame = null
            pay = null
        }
    }
}
