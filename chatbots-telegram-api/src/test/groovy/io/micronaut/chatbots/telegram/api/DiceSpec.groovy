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
class DiceSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Dice is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Dice))

        then:
        noExceptionThrown()
    }

    void "Dice is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Dice))

        then:
        noExceptionThrown()
    }

    void "Dice is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Dice)

        then:
        noExceptionThrown()
    }

    void "Dice::toString() does not throw NPE"() {
        when:
        new Dice().toString()

        then:
        noExceptionThrown()
    }

    void "valid Dice does not trigger any constraint exception"() {
        when:
        Dice el = validDice()

        then:
        validator.validate(el).isEmpty()
    }

    static Dice validDice() {
        new Dice().tap {
            emoji = "x"
            value = 1
        }
    }
}
