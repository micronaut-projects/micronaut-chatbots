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
class ShippingAddressSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ShippingAddress is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ShippingAddress))

        then:
        noExceptionThrown()
    }

    void "ShippingAddress is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ShippingAddress))

        then:
        noExceptionThrown()
    }

    void "ShippingAddress is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ShippingAddress)

        then:
        noExceptionThrown()
    }

    void "ShippingAddress::toString() does not throw NPE"() {
        when:
        new ShippingAddress().toString()

        then:
        noExceptionThrown()
    }

    void "valid ShippingAddress does not trigger any constraint exception"() {
        when:
        ShippingAddress el = validShippingAddress()

        then:
        validator.validate(el).isEmpty()
    }

    static ShippingAddress validShippingAddress() {
        ShippingAddress el = new ShippingAddress()
        el.countryCode = "es"
        el.state = "es"
        el.city = "x"
        el.streetLine1 = "x"
        el.streetLine2 = "x"
        el.postCode = "x"
        el
    }
}
