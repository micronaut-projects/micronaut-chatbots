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
class SuccessfulPaymentSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SuccessfulPayment is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SuccessfulPayment))

        then:
        noExceptionThrown()
    }

    void "SuccessfulPayment is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SuccessfulPayment))

        then:
        noExceptionThrown()
    }

    void "SuccessfulPayment is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SuccessfulPayment)

        then:
        noExceptionThrown()
    }

    void "SuccessfulPayment::toString() does not throw NPE"() {
        when:
        new SuccessfulPayment().toString()

        then:
        noExceptionThrown()
    }

    void "valid SuccessfulPayment does not trigger any constraint exception"() {
        when:
        SuccessfulPayment el = validSuccessfulPayment()

        then:
        validator.validate(el).isEmpty()
    }

    static SuccessfulPayment validSuccessfulPayment() {
        SuccessfulPayment el = new SuccessfulPayment()
        el.currency = "USD"
        el.totalAmount = 1
        el.invoicePayload = "x"
        el.shippingOptionId = null
        el.orderInfo = null
        el.telegramPaymentChargeId = "1"
        el.providerPaymentChargeId = "1"
        el
    }
}
