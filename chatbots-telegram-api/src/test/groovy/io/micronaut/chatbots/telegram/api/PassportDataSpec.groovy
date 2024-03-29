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
class PassportDataSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "PassportData is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(PassportData))

        then:
        noExceptionThrown()
    }

    void "PassportData is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(PassportData))

        then:
        noExceptionThrown()
    }

    void "PassportData is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(PassportData)

        then:
        noExceptionThrown()
    }

    void "PassportData::toString() does not throw NPE"() {
        when:
        new PassportData().toString()

        then:
        noExceptionThrown()
    }

    void "valid PassportData does not trigger any constraint exception"() {
        when:
        PassportData el = validPassportData()

        then:
        validator.validate(el).isEmpty()
    }

    static PassportData validPassportData() {
        new PassportData().tap {
            data = []
            credentials = validEncryptedCredentials()
        }
    }

    static EncryptedCredentials validEncryptedCredentials() {
        new EncryptedCredentials().tap {
            data = "x"
            hash = "x"
            secret = "x"
        }
    }
}
