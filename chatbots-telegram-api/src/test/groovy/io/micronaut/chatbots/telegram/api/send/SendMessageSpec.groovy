package io.micronaut.chatbots.telegram.api.send

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
class SendMessageSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendMessage is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendMessage))

        then:
        noExceptionThrown()
    }

    void "SendMessage is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendMessage))

        then:
        noExceptionThrown()
    }

    void "SendMessage is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendMessage)

        then:
        noExceptionThrown()
    }

    void "SendMessage::toString() does not throw NPE"() {
        when:
        new SendMessage().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendMessage does not trigger any constraint exception"() {
        when:
        SendMessage el = validSendMessage()

        then:
        validator.validate(el).isEmpty()
    }

    static SendMessage validSendMessage() {
        new SendMessage().tap {
            chatId = "xx"
            text = "hello world"
            disableWebPagePreview = null
            parseMode = null
        }
    }

    void "snake case is used for Json serialization"() {
        given:
        SendMessage el = validSendMessage()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
