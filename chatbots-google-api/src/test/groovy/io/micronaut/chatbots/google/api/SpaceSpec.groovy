package io.micronaut.chatbots.google.api

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
class SpaceSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Space is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Space))

        then:
        noExceptionThrown()
    }

    void "Space is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Space))

        then:
        noExceptionThrown()
    }

    void "Space is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Space)

        then:
        noExceptionThrown()
    }

    void "Space::toString() does not throw NPE"() {
        when:
        new Space().toString()

        then:
        noExceptionThrown()
    }

    void "valid Space does not trigger any constraint exception"() {
        when:
        Space el = validSpace()

        then:
        validator.validate(el).isEmpty()
    }

    void "lower Kebab case is used in Json serialization"() {
        given:
        Space el = validSpace()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains("name")
    }

    static Space validSpace() {
        Space el = new Space()
        el.name = "foo"
        el
    }
}
