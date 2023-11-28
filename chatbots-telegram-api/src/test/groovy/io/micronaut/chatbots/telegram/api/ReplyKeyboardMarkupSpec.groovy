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
class ReplyKeyboardMarkupSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ReplyKeyboardMarkup is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ReplyKeyboardMarkup))

        then:
        noExceptionThrown()
    }

    void "ReplyKeyboardMarkup is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ReplyKeyboardMarkup))

        then:
        noExceptionThrown()
    }

    void "ReplyKeyboardMarkup is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ReplyKeyboardMarkup)

        then:
        noExceptionThrown()
    }

    void "ReplyKeyboardMarkup::toString() does not throw NPE"() {
        when:
        new ReplyKeyboardMarkup().toString()

        then:
        noExceptionThrown()
    }

    void "valid ReplyKeyboardMarkup does not trigger any constraint exception"() {
        when:
        ReplyKeyboardMarkup el = validReplyKeyboardMarkup()

        then:
        validator.validate(el).isEmpty()
    }

    static ReplyKeyboardMarkup validReplyKeyboardMarkup() {
        new ReplyKeyboardMarkup().tap {
            keyboard = []
        }
    }

    void "snake case is used for Json serialization"() {
        given:
        ReplyKeyboardMarkup el = validReplyKeyboardMarkup()

        when:
        objectMapper.writeValueAsString(el)

        then:
        noExceptionThrown()
    }
}

