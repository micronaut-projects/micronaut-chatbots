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
class ForceReplySpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ForceReply is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ForceReply))

        then:
        noExceptionThrown()
    }

    void "ForceReply is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ForceReply))

        then:
        noExceptionThrown()
    }

    void "ForceReply is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ForceReply)

        then:
        noExceptionThrown()
    }

    void "ForceReply::toString() does not throw NPE"() {
        when:
        new ForceReply().toString()

        then:
        noExceptionThrown()
    }

    void "valid ForceReply does not trigger any constraint exception"() {
        when:
        ForceReply el = validForceReply()

        then:
        validator.validate(el).isEmpty()
    }

    static ForceReply validForceReply() {
        new ForceReply().tap {
            forceReply = false
            inputFieldPlaceholder = null
            selective = null
        }
    }

    void "snake case is used for Json serialization"() {
        given:
        ForceReply el = validForceReply()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('force_reply')
    }

}
