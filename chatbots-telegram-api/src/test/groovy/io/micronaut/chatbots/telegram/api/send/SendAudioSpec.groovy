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
class SendAudioSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendAudio is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendAudio))

        then:
        noExceptionThrown()
    }

    void "SendAudio is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendAudio))

        then:
        noExceptionThrown()
    }

    void "SendAudio is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendAudio)

        then:
        noExceptionThrown()
    }

    void "SendAudio::toString() does not throw NPE"() {
        when:
        new SendAudio().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendAudio does not trigger any constraint exception"() {
        when:
        SendAudio el = validSendAudio()

        then:
        validator.validate(el).isEmpty()
    }

    static SendAudio validSendAudio() {
        new SendAudio().tap {
            chatId = "xx"
            audio = "x"
            thumb = null
            title = null
            performer = null
            duration = null
            parseMode = null
            caption = null
        }
    }

    void "snake case is used for Json serialization"() {
        given:
        SendAudio el = validSendAudio()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
