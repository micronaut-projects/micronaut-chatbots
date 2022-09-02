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
class ResponseParametersSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "ResponseParameters is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(ResponseParameters))

        then:
        noExceptionThrown()
    }

    void "ResponseParameters is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(ResponseParameters))

        then:
        noExceptionThrown()
    }

    void "ResponseParameters is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(ResponseParameters)

        then:
        noExceptionThrown()
    }

    void "ResponseParameters::toString() does not throw NPE"() {
        when:
        new ResponseParameters().toString()

        then:
        noExceptionThrown()
    }

    void "valid ResponseParameters does not trigger any constraint exception"() {
        when:
        ResponseParameters el = validResponseParameters()

        then:
        validator.validate(el).isEmpty()
    }

    static ResponseParameters validResponseParameters() {
        ResponseParameters el = new ResponseParameters()
        el.migrateToChatId = null
        el.retryAfter = null
        el
    }
}

