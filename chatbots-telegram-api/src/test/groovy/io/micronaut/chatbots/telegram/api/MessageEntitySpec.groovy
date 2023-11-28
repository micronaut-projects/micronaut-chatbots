package io.micronaut.chatbots.telegram.api

import io.micronaut.chatbots.telegram.api.send.SendMessage
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
class MessageEntitySpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "MessageEntity is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(MessageEntity))

        then:
        noExceptionThrown()
    }

    void "MessageEntity is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(MessageEntity))

        then:
        noExceptionThrown()
    }

    void "MessageEntity is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(MessageEntity)

        then:
        noExceptionThrown()
    }

    void "MessageEntity::toString() does not throw NPE"() {
        when:
        new MessageEntity().toString()

        then:
        noExceptionThrown()
    }

    void "valid MessageEntity does not trigger any constraint exception"() {
        when:
        MessageEntity el = validMessageEntity()

        then:
        validator.validate(el).isEmpty()
    }

    static MessageEntity validMessageEntity() {
        new MessageEntity().tap {
            type = "x"
            offset = 1
            length = 1
            url = null
            user = null
            language= null
            customEmojiId = null
        }
    }
}
