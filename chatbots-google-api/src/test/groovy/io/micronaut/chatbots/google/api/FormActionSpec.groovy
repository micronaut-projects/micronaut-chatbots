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
class FormActionSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "FormAction is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(FormAction))

        then:
        noExceptionThrown()
    }

    void "FormAction is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(FormAction))

        then:
        noExceptionThrown()
    }

    void "FormAction is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(FormAction)

        then:
        noExceptionThrown()
    }

    void "FormAction::toString() does not throw NPE"() {
        when:
        new FormAction().toString()

        then:
        noExceptionThrown()
    }

    void "valid FormAction does not trigger any constraint exception"() {
        when:
        FormAction el = validFormAction()

        then:
        validator.validate(el).isEmpty()
    }

    void "lower Kebab case is used in Json serialization"() {
        given:
        FormAction el = validFormAction()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains("actionMethod")
        json.contains("parameters")
    }

    static FormAction validFormAction() {
        FormAction el = new FormAction()
        el.actionMethodName = "foo"
        el.parameters = [ActionParameterSpec.validActionParameter()]
        el
    }
}
