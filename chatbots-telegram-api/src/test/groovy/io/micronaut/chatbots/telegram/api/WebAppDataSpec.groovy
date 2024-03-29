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
class WebAppDataSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "WebAppData is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(WebAppData))

        then:
        noExceptionThrown()
    }

    void "WebAppData is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(WebAppData))

        then:
        noExceptionThrown()
    }

    void "WebAppData is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(WebAppData)

        then:
        noExceptionThrown()
    }

    void "WebAppData::toString() does not throw NPE"() {
        when:
        new WebAppData().toString()

        then:
        noExceptionThrown()
    }

    void "valid WebAppData does not trigger any constraint exception"() {
        when:
        WebAppData el = validWebAppData()

        then:
        validator.validate(el).isEmpty()
    }

    static WebAppData validWebAppData() {
        new WebAppData().tap {
            data = "1"
            buttonText = "2"
        }
    }
}
