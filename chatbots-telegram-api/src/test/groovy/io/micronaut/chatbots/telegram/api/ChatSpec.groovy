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
class ChatSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Chat is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Chat))

        then:
        noExceptionThrown()
    }

    void "Chat is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Chat))

        then:
        noExceptionThrown()
    }

    void "Chat is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Chat)

        then:
        noExceptionThrown()
    }

    void "Chat::toString() does not throw NPE"() {
        when:
        new Chat().toString()

        then:
        noExceptionThrown()
    }

    void "valid Chat does not trigger any constraint exception"() {
        when:
        Chat el = validChat()

        then:
        validator.validate(el).isEmpty()
    }

    static Chat validChat() {
        new Chat().tap {
            id = 123
            type = "private"
        }
    }
}
