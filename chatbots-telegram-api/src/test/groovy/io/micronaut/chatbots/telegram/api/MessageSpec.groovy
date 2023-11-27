package io.micronaut.chatbots.telegram.api

import io.micronaut.chatbots.telegram.api.send.SendAudio
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
class MessageSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Message is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Message))

        then:
        noExceptionThrown()
    }

    void "Message is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Message))

        then:
        noExceptionThrown()
    }

    void "Message is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Message)

        then:
        noExceptionThrown()
    }

    void "Message::toString() does not throw NPE"() {
        when:
        new Message().toString()

        then:
        noExceptionThrown()
    }

    void "valid Message does not trigger any constraint exception"() {
        when:
        Message el = validMessage()

        then:
        validator.validate(el).isEmpty()
    }

    static Message validMessage() {
        new Message().tap {
            messageId = 123
            from = validUser()
            date = 123
            chat = validChat()
        }
    }

    static Chat validChat() {
        new Chat().tap {
            id = 123
            type = "private"
        }
    }

    static User validUser() {
        new User().tap {
            id = 1L
            bot = false
            firstName = "foo"
        }
    }
}
