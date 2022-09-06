package io.micronaut.chatbots.google.api

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
class SlashCommandSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SlashCommand is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SlashCommand))

        then:
        noExceptionThrown()
    }

    void "SlashCommand is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SlashCommand))

        then:
        noExceptionThrown()
    }

    void "SlashCommand is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SlashCommand)

        then:
        noExceptionThrown()
    }

    void "SlashCommand::toString() does not throw NPE"() {
        when:
        new SlashCommand().toString()

        then:
        noExceptionThrown()
    }

    void "valid SlashCommand does not trigger any constraint exception"() {
        when:
        SlashCommand el = validSlashCommand()

        then:
        validator.validate(el).isEmpty()
    }

    void "lower Kebap case is used in Json serialization"() {
        given:
        SlashCommand el = validSlashCommand()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains("commandId")
    }

    static SlashCommand validSlashCommand() {
        SlashCommand el = new SlashCommand()
        el.commandId = "xxxx"
        el
    }
}
