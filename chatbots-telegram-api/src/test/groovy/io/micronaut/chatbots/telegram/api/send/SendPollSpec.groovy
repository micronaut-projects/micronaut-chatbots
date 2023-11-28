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
class SendPollSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendPoll is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendPoll))

        then:
        noExceptionThrown()
    }

    void "SendPoll is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendPoll))

        then:
        noExceptionThrown()
    }

    void "SendPoll is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendPoll)

        then:
        noExceptionThrown()
    }

    void "SendPoll::toString() does not throw NPE"() {
        when:
        new SendPoll().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendPoll does not trigger any constraint exception"() {
        when:
        SendPoll el = validSendPoll()

        then:
        validator.validate(el).isEmpty()
    }

    static SendPoll validSendPoll() {
        new SendPoll().tap {
            chatId = "xx"
            question = "xx"
            options = []
            closed = null
            correctOptionId = null
            allowsMultipleAnswers = null
            type = null
            anonymous = null
        }
    }

    void "snake case is used for Json serialization"() {
        given:
        SendPoll el = validSendPoll()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
