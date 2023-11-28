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
class PreCheckoutQuerySpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "PreCheckoutQuery is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(PreCheckoutQuery))

        then:
        noExceptionThrown()
    }

    void "PreCheckoutQuery is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(PreCheckoutQuery))

        then:
        noExceptionThrown()
    }

    void "PreCheckoutQuery is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(PreCheckoutQuery)

        then:
        noExceptionThrown()
    }

    void "PreCheckoutQuery::toString() does not throw NPE"() {
        when:
        new PreCheckoutQuery().toString()

        then:
        noExceptionThrown()
    }

    void "valid PreCheckoutQuery does not trigger any constraint exception"() {
        when:
        PreCheckoutQuery el = validPreCheckoutQuery()

        then:
        validator.validate(el).isEmpty()
    }

    static PreCheckoutQuery validPreCheckoutQuery() {
        new PreCheckoutQuery().tap {
            id = 'x'
            from = validUser()
            currency = 'USD'
            totalAmount = 1
            invoicePayload = 'x'
            shippingOptionId = null
            orderInfo = null
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
