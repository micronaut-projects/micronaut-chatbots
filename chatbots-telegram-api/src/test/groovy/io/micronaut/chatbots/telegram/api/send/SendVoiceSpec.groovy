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
class SendVoiceSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendVoice is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendVoice))

        then:
        noExceptionThrown()
    }

    void "SendVoice is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendVoice))

        then:
        noExceptionThrown()
    }

    void "SendVoice is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendVoice)

        then:
        noExceptionThrown()
    }

    void "SendVoice::toString() does not throw NPE"() {
        when:
        new SendVoice().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendVoice does not trigger any constraint exception"() {
        when:
        SendVoice el = validSendVoice()

        then:
        validator.validate(el).isEmpty()
    }

    static SendVoice validSendVoice() {
        new SendVoice().tap {
            chatId = "xx"
            voice = "x"
            duration = null
            parseMode = null
            caption = null
        }
    }

    void "snake case is used for Json serialization"() {
        given:
        SendVoice el = validSendVoice()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
