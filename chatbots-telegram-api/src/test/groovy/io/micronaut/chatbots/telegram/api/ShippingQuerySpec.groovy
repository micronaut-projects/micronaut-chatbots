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
class ShippingQuerySpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ShippingQuery is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ShippingQuery))

        then:
        noExceptionThrown()
    }

    void "ShippingQuery is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ShippingQuery))

        then:
        noExceptionThrown()
    }

    void "ShippingQuery is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ShippingQuery)

        then:
        noExceptionThrown()
    }

    void "ShippingQuery::toString() does not throw NPE"() {
        when:
        new ShippingQuery().toString()

        then:
        noExceptionThrown()
    }

    void "valid ShippingQuery does not trigger any constraint exception"() {
        when:
        ShippingQuery el = validShippingQuery()

        then:
        validator.validate(el).isEmpty()
    }

    static ShippingQuery validShippingQuery() {
        new ShippingQuery().tap {
            id = "user"
            from = validUser()
            invoicePayload = 'z'
            shippingAddress = validShippingAddress()
        }
    }

    static User validUser() {
        new User().tap {
            id = 1L
            bot = false
            firstName = "foo"
        }
    }

    static ShippingAddress validShippingAddress() {
        new ShippingAddress().tap {
            countryCode = "es"
            state = "es"
            city = "x"
            streetLine1 = "x"
            streetLine2 = "x"
            postCode = "x"
        }
    }
}

