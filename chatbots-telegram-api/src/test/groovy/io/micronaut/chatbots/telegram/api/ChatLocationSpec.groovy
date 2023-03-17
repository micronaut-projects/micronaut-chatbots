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
class ChatLocationSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ChatLocation is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ChatLocation))

        then:
        noExceptionThrown()
    }

    void "ChatLocation is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ChatLocation))

        then:
        noExceptionThrown()
    }

    void "ChatLocation is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ChatLocation)

        then:
        noExceptionThrown()
    }

    void "ChatLocation::toString() does not throw NPE"() {
        when:
        new ChatLocation().toString()

        then:
        noExceptionThrown()
    }

    void "valid ChatLocation does not trigger any constraint exception"() {
        when:
        ChatLocation el = validChatLocation()

        then:
        validator.validate(el).isEmpty()
    }

    static ChatLocation validChatLocation() {
        ChatLocation el = new ChatLocation()
        el.location = validLocation()
        el.address = "home"
        el
    }

    static Location validLocation() {
        Location el = new Location()
        el.longitude = 1.2
        el.latitude = 2.5
        el
    }
}
