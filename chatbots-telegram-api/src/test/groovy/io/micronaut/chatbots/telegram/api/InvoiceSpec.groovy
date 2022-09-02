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
class InvoiceSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Invoice is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Invoice))

        then:
        noExceptionThrown()
    }

    void "Invoice is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Invoice))

        then:
        noExceptionThrown()
    }

    void "Invoice is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Invoice)

        then:
        noExceptionThrown()
    }

    void "Invoice::toString() does not throw NPE"() {
        when:
        new Invoice().toString()

        then:
        noExceptionThrown()
    }

    void "valid Invoice does not trigger any constraint exception"() {
        when:
        Invoice el = validInvoice()

        then:
        validator.validate(el).isEmpty()
    }

    static Invoice validInvoice() {
        Invoice el = new Invoice()
        el.title = "x"
        el.description = "x"
        el.startParameter = "x"
        el.currency = "USD"
        el.totalAmount = 1
        el
    }
}
