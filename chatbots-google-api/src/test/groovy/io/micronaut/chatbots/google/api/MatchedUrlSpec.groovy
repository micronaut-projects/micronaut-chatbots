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
class MatchedUrlSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "MatchedUrl is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(MatchedUrl))

        then:
        noExceptionThrown()
    }

    void "MatchedUrl is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(MatchedUrl))

        then:
        noExceptionThrown()
    }

    void "MatchedUrl is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(MatchedUrl)

        then:
        noExceptionThrown()
    }

    void "MatchedUrl::toString() does not throw NPE"() {
        when:
        new MatchedUrl().toString()

        then:
        noExceptionThrown()
    }

    void "valid MatchedUrl does not trigger any constraint exception"() {
        when:
        MatchedUrl el = validMatchedUrl()

        then:
        validator.validate(el).isEmpty()
    }

    void "lower Kebab case is used in Json serialization"() {
        given:
        MatchedUrl el = validMatchedUrl()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains("url")
    }

    static MatchedUrl validMatchedUrl() {
        new MatchedUrl().tap {
            url = "https://micronaut.io"
        }
    }
}
