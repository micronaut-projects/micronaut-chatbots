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
class VideoChatScheduledSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "VideoChatScheduled is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(VideoChatScheduled))

        then:
        noExceptionThrown()
    }

    void "VideoChatScheduled is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(VideoChatScheduled))

        then:
        noExceptionThrown()
    }

    void "VideoChatScheduled is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(VideoChatScheduled)

        then:
        noExceptionThrown()
    }

    void "VideoChatScheduled::toString() does not throw NPE"() {
        when:
        new VideoChatScheduled().toString()

        then:
        noExceptionThrown()
    }

    void "valid VideoChatScheduled does not trigger any constraint exception"() {
        when:
        VideoChatScheduled el = validVideoChatScheduled()

        then:
        validator.validate(el).isEmpty()
    }

    static VideoChatScheduled validVideoChatScheduled() {
        VideoChatScheduled el = new VideoChatScheduled()
        el.startDate = 12
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        VideoChatScheduled el = validVideoChatScheduled()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('start_date')
    }
}
