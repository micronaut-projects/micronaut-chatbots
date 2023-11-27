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
class ProximityAlertTriggeredSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ProximityAlertTriggered is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ProximityAlertTriggered))

        then:
        noExceptionThrown()
    }

    void "ProximityAlertTriggered is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ProximityAlertTriggered))

        then:
        noExceptionThrown()
    }

    void "ProximityAlertTriggered is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ProximityAlertTriggered)

        then:
        noExceptionThrown()
    }

    void "ProximityAlertTriggered::toString() does not throw NPE"() {
        when:
        new ProximityAlertTriggered().toString()

        then:
        noExceptionThrown()
    }

    void "valid ProximityAlertTriggered does not trigger any constraint exception"() {
        when:
        ProximityAlertTriggered el = validProximityAlertTriggered()

        then:
        validator.validate(el).isEmpty()
    }

    static ProximityAlertTriggered validProximityAlertTriggered() {
        new ProximityAlertTriggered().tap {
            distance = 12
            watcher = validUser()
            traveler = validUser()
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

