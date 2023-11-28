package io.micronaut.chatbots.telegram.api.send

import io.micronaut.chatbots.telegram.api.Animation
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
class SendVideoSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendVideo is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendVideo))

        then:
        noExceptionThrown()
    }

    void "SendVideo is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendVideo))

        then:
        noExceptionThrown()
    }

    void "SendVideo is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendVideo)

        then:
        noExceptionThrown()
    }

    void "SendVideo::toString() does not throw NPE"() {
        when:
        new SendVideo().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendVideo does not trigger any constraint exception"() {
        when:
        SendVideo el = validSendVideo()

        then:
        validator.validate(el).isEmpty()
    }

    static SendVideo validSendVideo() {
        new SendVideo().tap {
            chatId = "xx"
            video = "x"
            supportsStreaming = null
            parseMode = null
            caption = null
            thumb = null
            height = null
            width = null
            duration = null
        }
    }

    void "snake case is used for Json serialization"() {
        given:
        SendVideo el = validSendVideo()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
