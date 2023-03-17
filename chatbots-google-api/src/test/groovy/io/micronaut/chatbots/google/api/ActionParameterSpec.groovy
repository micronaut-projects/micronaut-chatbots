package io.micronaut.chatbots.google.api

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
class ActionParameterSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ActionParameter is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ActionParameter))

        then:
        noExceptionThrown()
    }

    void "ActionParameter is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ActionParameter))

        then:
        noExceptionThrown()
    }

    void "ActionParameter is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ActionParameter)

        then:
        noExceptionThrown()
    }

    void "ActionParameter::toString() does not throw NPE"() {
        when:
        new ActionParameter().toString()

        then:
        noExceptionThrown()
    }

    void "valid ActionParameter does not trigger any constraint exception"() {
        when:
        ActionParameter el = validActionParameter()

        then:
        validator.validate(el).isEmpty()
    }

    void "lower Kebab case is used in Json serialization"() {
        given:
        ActionParameter el = validActionParameter()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains("key")
        json.contains("value")
    }

    static ActionParameter validActionParameter() {
        ActionParameter el = new ActionParameter()
        el.key = "x"
        el.value = "v"
        el
    }
}
