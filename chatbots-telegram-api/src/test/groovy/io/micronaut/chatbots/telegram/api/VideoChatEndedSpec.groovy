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
class VideoChatEndedSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "VideoChatEnded is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(VideoChatEnded))

        then:
        noExceptionThrown()
    }

    void "VideoChatEnded is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(VideoChatEnded))

        then:
        noExceptionThrown()
    }

    void "VideoChatEnded is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(VideoChatEnded)

        then:
        noExceptionThrown()
    }

    void "VideoChatEnded::toString() does not throw NPE"() {
        when:
        new VideoChatEnded().toString()

        then:
        noExceptionThrown()
    }

    void "valid VideoChatEnded does not trigger any constraint exception"() {
        when:
        VideoChatEnded el = validVideoChatEnded()

        then:
        validator.validate(el).isEmpty()
    }

    static VideoChatEnded validVideoChatEnded() {
        VideoChatEnded el = new VideoChatEnded()
        el.duration = 12
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        VideoChatEnded el = validVideoChatEnded()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('duration')
    }
}
