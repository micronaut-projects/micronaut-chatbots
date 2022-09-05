package io.micronaut.chatbots.telegram.api.send

import io.micronaut.context.BeanContext
import io.micronaut.core.beans.BeanIntrospection
import io.micronaut.core.type.Argument
import io.micronaut.serde.ObjectMapper
import io.micronaut.serde.SerdeIntrospections
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import javax.validation.Validator

@MicronautTest(startApplication = false)
class SendVideoNoteSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendVideoNote is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendVideoNote))

        then:
        noExceptionThrown()
    }

    void "SendVideoNote is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendVideoNote))

        then:
        noExceptionThrown()
    }

    void "SendVideoNote is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendVideoNote)

        then:
        noExceptionThrown()
    }

    void "SendVideoNote::toString() does not throw NPE"() {
        when:
        new SendVideoNote().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendVideoNote does not trigger any constraint exception"() {
        when:
        SendVideoNote el = validSendVideoNote()

        then:
        validator.validate(el).isEmpty()
    }

    static SendVideoNote validSendVideoNote() {
        SendVideoNote el = new SendVideoNote()
        el.chatId = "xx"
        el.videoNote = "x"
        el.disableNotification = null
        el.thumb = null
        el.length = null
        el.duration = null
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        SendVideoNote el = validSendVideoNote()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
