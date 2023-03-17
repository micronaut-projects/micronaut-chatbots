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
class SendAnimationSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendAnimation is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendAnimation))

        then:
        noExceptionThrown()
    }

    void "SendAnimation is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendAnimation))

        then:
        noExceptionThrown()
    }

    void "SendAnimation is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendAnimation)

        then:
        noExceptionThrown()
    }

    void "SendAnimation::toString() does not throw NPE"() {
        when:
        new SendAnimation().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendAnimation does not trigger any constraint exception"() {
        when:
        SendAnimation el = validSendAnimation()

        then:
        validator.validate(el).isEmpty()
    }

    static SendAnimation validSendAnimation() {
        SendAnimation el = new SendAnimation()
        el.chatId = "xx"
        el.animation = "hello world"
        el.parseMode = null
        el.caption = null
        el.thumb = null
        el.height = null
        el.width = null
        el.duration = null
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        SendAnimation el = validSendAnimation()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
