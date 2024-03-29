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
class InputMediaDocumentSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "InputMediaDocument is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(InputMediaDocument))

        then:
        noExceptionThrown()
    }

    void "InputMediaDocument is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(InputMediaDocument))

        then:
        noExceptionThrown()
    }

    void "InputMediaDocument is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(InputMediaDocument)

        then:
        noExceptionThrown()
    }

    void "InputMediaDocument::toString() does not throw NPE"() {
        when:
        new InputMediaDocument().toString()

        then:
        noExceptionThrown()
    }
}
