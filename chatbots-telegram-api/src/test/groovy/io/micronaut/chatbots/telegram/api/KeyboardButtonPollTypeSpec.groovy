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
class KeyboardButtonPollTypeSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "KeyboardButtonPollType is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(KeyboardButtonPollType))

        then:
        noExceptionThrown()
    }

    void "KeyboardButtonPollType is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(KeyboardButtonPollType))

        then:
        noExceptionThrown()
    }

    void "KeyboardButtonPollType is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(KeyboardButtonPollType)

        then:
        noExceptionThrown()
    }

    void "KeyboardButtonPollType::toString() does not throw NPE"() {
        when:
        new KeyboardButtonPollType().toString()

        then:
        noExceptionThrown()
    }
}
