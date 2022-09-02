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
class OrderInfoSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "OrderInfo is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(OrderInfo))

        then:
        noExceptionThrown()
    }

    void "OrderInfo is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(OrderInfo))

        then:
        noExceptionThrown()
    }

    void "OrderInfo is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(OrderInfo)

        then:
        noExceptionThrown()
    }

    void "OrderInfo::toString() does not throw NPE"() {
        when:
        new OrderInfo().toString()

        then:
        noExceptionThrown()
    }

    void "valid OrderInfo does not trigger any constraint exception"() {
        when:
        OrderInfo el = validOrderInfo()

        then:
        validator.validate(el).isEmpty()
    }

    static OrderInfo validOrderInfo() {
        OrderInfo el = new OrderInfo()
        el.name = null
        el.phoneNumber = null
        el.email = null
        el.shippingAddress = null
        el
    }
}
