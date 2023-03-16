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
class MaskPositionSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "MaskPosition is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(MaskPosition))

        then:
        noExceptionThrown()
    }

    void "MaskPosition is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(MaskPosition))

        then:
        noExceptionThrown()
    }

    void "MaskPosition is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(MaskPosition)

        then:
        noExceptionThrown()
    }

    void "MaskPosition::toString() does not throw NPE"() {
        when:
        new MaskPosition().toString()

        then:
        noExceptionThrown()
    }

    void "valid MaskPosition does not trigger any constraint exception"() {
        when:
        MaskPosition el = validMaskPosition()

        then:
        validator.validate(el).isEmpty()
    }

    static MaskPosition validMaskPosition() {
        MaskPosition el = new MaskPosition()
        el.point = MaskPositionPoint.CHIN
        el.xshift = 1f
        el.yshift = 2f
        el.scale  = 1f
        el
    }
}
