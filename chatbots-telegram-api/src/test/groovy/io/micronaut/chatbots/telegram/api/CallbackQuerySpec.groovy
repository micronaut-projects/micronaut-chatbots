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
class CallbackQuerySpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "CallbackQuery is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(CallbackQuery))

        then:
        noExceptionThrown()
    }

    void "CallbackQuery is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(CallbackQuery))

        then:
        noExceptionThrown()
    }

    void "CallbackQuery is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(CallbackQuery)

        then:
        noExceptionThrown()
    }

    void "CallbackQuery::toString() does not throw NPE"() {
        when:
        new CallbackQuery().toString()

        then:
        noExceptionThrown()
    }

    void "valid CallbackQuery does not trigger any constraint exception"() {
        when:
        CallbackQuery el = validCallbackQuery()

        then:
        validator.validate(el).isEmpty()
    }

    static CallbackQuery validCallbackQuery() {
        new CallbackQuery().tap {
            id = "1"
            from = validUser()
            chatInstance = "1"
            message = null
            inlineMessageId = null
            data = null
            data = null
            gameShortName = null
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
