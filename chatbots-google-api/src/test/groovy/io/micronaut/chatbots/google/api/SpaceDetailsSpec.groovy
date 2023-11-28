package io.micronaut.chatbots.google.api

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
class SpaceDetailsSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SpaceDetails is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SpaceDetails))

        then:
        noExceptionThrown()
    }

    void "SpaceDetails is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SpaceDetails))

        then:
        noExceptionThrown()
    }

    void "SpaceDetails is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SpaceDetails)

        then:
        noExceptionThrown()
    }

    void "SpaceDetails::toString() does not throw NPE"() {
        when:
        new SpaceDetails().toString()

        then:
        noExceptionThrown()
    }

    void "valid SpaceDetails does not trigger any constraint exception"() {
        when:
        SpaceDetails el = validSpaceDetails()

        then:
        validator.validate(el).isEmpty()
    }

    void "lower Kebab case is used in Json serialization"() {
        given:
        SpaceDetails el = validSpaceDetails()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains("description")
        json.contains("guidelines")
    }

    static SpaceDetails validSpaceDetails() {
        new SpaceDetails().tap {
            description = "x"
            guidelines = "v"
        }
    }
}
