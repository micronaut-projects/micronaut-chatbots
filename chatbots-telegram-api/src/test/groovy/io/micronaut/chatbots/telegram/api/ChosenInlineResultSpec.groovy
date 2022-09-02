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
class ChosenInlineResultSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ChosenInlineResult is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ChosenInlineResult))

        then:
        noExceptionThrown()
    }

    void "ChosenInlineResult is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ChosenInlineResult))

        then:
        noExceptionThrown()
    }

    void "ChosenInlineResult is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ChosenInlineResult)

        then:
        noExceptionThrown()
    }

    void "Invoice::toString() does not throw NPE"() {
        when:
        new Invoice().toString()

        then:
        noExceptionThrown()
    }

    void "valid ChosenInlineResult does not trigger any constraint exception"() {
        when:
        ChosenInlineResult el = validChosenInlineResult()

        then:
        validator.validate(el).isEmpty()
    }

    static ChosenInlineResult validChosenInlineResult() {
        ChosenInlineResult el = new ChosenInlineResult()
        el.resultId = "x"
        el.from = validUser()
        el.query = "foo"
        el
    }

    static User validUser() {
        User el = new User()
        el.id = 1L
        el.bot = false
        el.firstName = "foo"
        el
    }
}

