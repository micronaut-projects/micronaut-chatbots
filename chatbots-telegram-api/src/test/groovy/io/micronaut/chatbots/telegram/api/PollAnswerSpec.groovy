package io.micronaut.chatbots.telegram.api

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
class PollAnswerSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "PollAnswer is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(PollAnswer))

        then:
        noExceptionThrown()
    }

    void "PollAnswer is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(PollAnswer))

        then:
        noExceptionThrown()
    }

    void "PollAnswer is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(PollAnswer)

        then:
        noExceptionThrown()
    }

    void "PollAnswer::toString() does not throw NPE"() {
        when:
        new PollAnswer().toString()

        then:
        noExceptionThrown()
    }

    void "valid PollAnswer does not trigger any constraint exception"() {
        when:
        PollAnswer el = validPollAnswer()

        then:
        validator.validate(el).isEmpty()
    }

    static PollAnswer validPollAnswer() {
        new PollAnswer().tap {
            pollId = "user"
            user = validUser()
            optionIds = [1]
        }
    }

    static User validUser() {
        new User().tap {
            id = 1L
            bot = false
            firstName = "foo"
        }
    }
}
