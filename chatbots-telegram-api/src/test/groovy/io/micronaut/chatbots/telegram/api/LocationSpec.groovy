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
class LocationSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Location is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Location))

        then:
        noExceptionThrown()
    }

    void "Location is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Location))

        then:
        noExceptionThrown()
    }

    void "Location is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Location)

        then:
        noExceptionThrown()
    }

    void "Location::toString() does not throw NPE"() {
        when:
        new Location().toString()

        then:
        noExceptionThrown()
    }

    void "valid Location does not trigger any constraint exception"() {
        when:
        Location el = validLocation()

        then:
        validator.validate(el).isEmpty()
    }

    void "longitude is required"() {
        given:
        Location el = validLocation()

        when:
        el.longitude = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "latitude is required"() {
        given:
        Location el = validLocation()

        when:
        el.latitude = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "horizontalAccuracy is optional"() {
        given:
        Location el = validLocation()

        when:
        el.horizontalAccuracy = null

        then:
        validator.validate(el).isEmpty()
    }

    void "livePeriod is optional"() {
        given:
        Location el = validLocation()

        when:
        el.livePeriod = null

        then:
        validator.validate(el).isEmpty()
    }

    void "heading is optional"() {
        given:
        Location el = validLocation()

        when:
        el.heading = null

        then:
        validator.validate(el).isEmpty()
    }

    void "proximityAlertRadius is optional"() {
        given:
        Location el = validLocation()

        when:
        el.proximityAlertRadius = null

        then:
        validator.validate(el).isEmpty()
    }

    void "values are present in json"() {
        given:
        Location el = new Location()
        el.longitude = 2
        el.latitude = 2
        el.horizontalAccuracy =2
        el.livePeriod = 2
        el.heading = 2
        el.proximityAlertRadius = 2

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('"longitude":2')
        json.contains('"latitude":2')
        json.contains('"horizontal_accuracy":2')
        json.contains('"live_period":2')
        json.contains('"heading":2')
        json.contains('"proximity_alert_radius":2')
    }

    void "snake case is used for Json serialization"() {
        given:
        Location el = new Location()
        el.longitude = 2
        el.latitude = 2
        el.horizontalAccuracy =2
        el.livePeriod = 2
        el.heading = 2
        el.proximityAlertRadius = 2

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains("longitude")
        json.contains("latitude")
        json.contains("horizontal_accuracy")
        json.contains("live_period")
        json.contains("heading")
        json.contains("proximity_alert_radius")

        !json.contains("horizontalAccuracy")
        !json.contains("livePeriod")
        !json.contains("proximityAlertRadius")
    }

    void "only non null fields are included"() {
        given:
        Location el = new Location()
        el.longitude = 2
        el.latitude = 2
        el.horizontalAccuracy =2
        el.livePeriod = 2
        el.heading = 2
        el.proximityAlertRadius = 2

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains("longitude")
        json.contains("latitude")
        json.contains("horizontal_accuracy")
        json.contains("live_period")
        json.contains("heading")
        json.contains("proximity_alert_radius")

        when:
        el.horizontalAccuracy = null
        el.livePeriod = null
        el.heading = null
        el.proximityAlertRadius = null
        json = objectMapper.writeValueAsString(el)

        then:
        json.contains("longitude")
        json.contains("latitude")
        !json.contains("horizontal_accuracy")
        !json.contains("live_period")
        !json.contains("heading")
        !json.contains("proximity_alert_radius")
    }

    static Location validLocation() {
        new Location().tap {
            longitude = 1.2
            latitude = 2.5
        }
    }
}
