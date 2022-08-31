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
class PreCheckoutQuerySpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "PreCheckoutQuery is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(PreCheckoutQuery))

        then:
        noExceptionThrown()
    }

    void "PreCheckoutQuery is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(PreCheckoutQuery))

        then:
        noExceptionThrown()
    }

    void "PreCheckoutQuery is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(PreCheckoutQuery)

        then:
        noExceptionThrown()
    }

    void "PreCheckoutQuery::toString() does not throw NPE"() {
        when:
        new PreCheckoutQuery().toString()

        then:
        noExceptionThrown()
    }
}
