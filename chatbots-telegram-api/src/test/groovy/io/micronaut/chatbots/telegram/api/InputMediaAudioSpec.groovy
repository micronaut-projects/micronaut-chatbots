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
class InputMediaAudioSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "InputMediaAudio is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(InputMediaAudio))

        then:
        noExceptionThrown()
    }

    void "InputMediaAudio is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(InputMediaAudio))

        then:
        noExceptionThrown()
    }

    void "InputMediaAudio is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(InputMediaAudio)

        then:
        noExceptionThrown()
    }

    void "InputMediaAudio::toString() does not throw NPE"() {
        when:
        new InputMediaAudio().toString()

        then:
        noExceptionThrown()
    }

    void "valid InputMediaAudio does not trigger any constraint exception"() {
        when:
        InputMediaAudio el = validInputMediaAudio()

        then:
        validator.validate(el).isEmpty()
    }

    static InputMediaAudio validInputMediaAudio() {
        InputMediaAudio el = new InputMediaAudio()
        el.performer = null
        el.title = null
        el.duration = null
        el.media = 'x'
        el
    }
}
