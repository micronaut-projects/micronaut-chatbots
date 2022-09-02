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
class BotCommandSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "BotCommand is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(BotCommand))

        then:
        noExceptionThrown()
    }

    void "BotCommand is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(BotCommand))

        then:
        noExceptionThrown()
    }

    void "BotCommand is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(BotCommand)

        then:
        noExceptionThrown()
    }

    void "BotCommand::toString() does not throw NPE"() {
        when:
        new BotCommand().toString()

        then:
        noExceptionThrown()
    }

    void "valid BotCommand does not trigger any constraint exception"() {
        when:
        BotCommand el = validBotCommand()

        then:
        validator.validate(el).isEmpty()
    }

    static BotCommand validBotCommand() {
        BotCommand el = new BotCommand()
        el.command = 'a'
        el.description = 'aaa'
        el
    }
}
