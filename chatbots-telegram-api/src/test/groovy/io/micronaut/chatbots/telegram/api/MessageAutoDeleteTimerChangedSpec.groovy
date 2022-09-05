package io.micronaut.chatbots.telegram.api

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
class MessageAutoDeleteTimerChangedSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "MessageAutoDeleteTimerChanged is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(MessageAutoDeleteTimerChanged))

        then:
        noExceptionThrown()
    }

    void "MessageAutoDeleteTimerChanged is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(MessageAutoDeleteTimerChanged))

        then:
        noExceptionThrown()
    }

    void "MessageAutoDeleteTimerChanged is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(MessageAutoDeleteTimerChanged)

        then:
        noExceptionThrown()
    }

    void "MessageAutoDeleteTimerChanged::toString() does not throw NPE"() {
        when:
        new MessageAutoDeleteTimerChanged().toString()

        then:
        noExceptionThrown()
    }

    void "valid MessageAutoDeleteTimerChanged does not trigger any constraint exception"() {
        when:
        MessageAutoDeleteTimerChanged el = validMessageAutoDeleteTimerChanged()

        then:
        validator.validate(el).isEmpty()
    }

    static MessageAutoDeleteTimerChanged validMessageAutoDeleteTimerChanged() {
        MessageAutoDeleteTimerChanged el = new MessageAutoDeleteTimerChanged()
        el.messageAutoDeleteTime = 12
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        MessageAutoDeleteTimerChanged el = validMessageAutoDeleteTimerChanged()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('message_auto_delete_time')
    }
}

