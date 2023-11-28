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
class SendDocumentSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendDocument is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendDocument))

        then:
        noExceptionThrown()
    }

    void "SendDocument is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendDocument))

        then:
        noExceptionThrown()
    }

    void "SendDocument is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendDocument)

        then:
        noExceptionThrown()
    }

    void "SendDocument::toString() does not throw NPE"() {
        when:
        new SendDocument().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendDocument does not trigger any constraint exception"() {
        when:
        SendDocument el = validSendDocument()

        then:
        validator.validate(el).isEmpty()
    }

    static SendDocument validSendDocument() {
        new SendDocument().tap {
            chatId = "xx"
            document = "xx"
            parseMode = null
            caption = null
            thumb = null
            replyMarkup = null
            disableNotification = null
            replyToMessageId = null
        }
    }

    void "snake case is used for Json serialization"() {
        given:
        SendDocument el = validSendDocument()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
