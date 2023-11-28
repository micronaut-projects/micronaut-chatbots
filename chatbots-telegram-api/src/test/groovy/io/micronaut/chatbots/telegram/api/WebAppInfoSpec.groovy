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
class WebAppInfoSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "WebAppInfo is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(WebAppInfo))

        then:
        noExceptionThrown()
    }

    void "WebAppInfo is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(WebAppInfo))

        then:
        noExceptionThrown()
    }

    void "WebAppInfo is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(WebAppInfo)

        then:
        noExceptionThrown()
    }

    void "WebAppInfo::toString() does not throw NPE"() {
        when:
        new WebAppInfo().toString()

        then:
        noExceptionThrown()
    }

    void "valid WebAppInfo does not trigger any constraint exception"() {
        when:
        WebAppInfo el = validWebAppInfo()

        then:
        validator.validate(el).isEmpty()
    }

    static WebAppInfo validWebAppInfo() {
        new WebAppInfo().tap {
            url = "x"
        }
    }

    void "snake case is used for Json serialization"() {
        given:
        WebAppInfo el = validWebAppInfo()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('url')
    }
}
