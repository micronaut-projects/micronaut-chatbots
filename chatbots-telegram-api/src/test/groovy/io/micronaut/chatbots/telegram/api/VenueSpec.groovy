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
class VenueSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Venue is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Venue))

        then:
        noExceptionThrown()
    }

    void "Venue is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Venue))

        then:
        noExceptionThrown()
    }

    void "Venue is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Venue)

        then:
        noExceptionThrown()
    }

    void "Venue::toString() does not throw NPE"() {
        when:
        new Venue().toString()

        then:
        noExceptionThrown()
    }

    void "valid Venue does not trigger any constraint exception"() {
        when:
        Venue el = validVenue()

        then:
        validator.validate(el).isEmpty()
    }

    static Venue validVenue() {
        new Venue().tap {
            location = validLocation()
            title = "xxx.yyy"
            address = "x"
            foursquareId = null
            foursquareType = null
            googlePlaceId = null
            googlePlaceType = null
        }
    }

    static Location validLocation() {
        new Location().tap {
            longitude = 1.2
            latitude = 2.5
        }
    }
}
