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
class InputMediaVideoSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "InputMediaVideo is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(InputMediaVideo))

        then:
        noExceptionThrown()
    }

    void "InputMediaVideo is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(InputMediaVideo))

        then:
        noExceptionThrown()
    }

    void "InputMediaVideo is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(InputMediaVideo)

        then:
        noExceptionThrown()
    }

    void "InputMediaVideo::toString() does not throw NPE"() {
        when:
        new InputMediaVideo().toString()

        then:
        noExceptionThrown()
    }

    void "valid InputMediaVideo does not trigger any constraint exception"() {
        when:
        InputMediaVideo el = validInputMediaVideo()

        then:
        validator.validate(el).isEmpty()
    }

    static InputMediaVideo validInputMediaVideo() {
        InputMediaVideo el = new InputMediaVideo()
        el.thumb = null
        el.media = 'x'
        el.disableContentTypeDetection = null
        el.width = null
        el.height = null
        el.duration = null
        el.supportsStreaming = null
        el
    }
}
