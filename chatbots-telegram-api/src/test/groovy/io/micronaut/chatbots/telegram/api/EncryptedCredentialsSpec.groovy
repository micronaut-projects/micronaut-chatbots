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
class EncryptedCredentialsSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "EncryptedCredentials is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(EncryptedCredentials))

        then:
        noExceptionThrown()
    }

    void "EncryptedCredentials is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(EncryptedCredentials))

        then:
        noExceptionThrown()
    }

    void "EncryptedCredentials is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(EncryptedCredentials)

        then:
        noExceptionThrown()
    }

    void "EncryptedCredentials::toString() does not throw NPE"() {
        when:
        new EncryptedCredentials().toString()

        then:
        noExceptionThrown()
    }

    void "valid EncryptedCredentials does not trigger any constraint exception"() {
        when:
        EncryptedCredentials el = validEncryptedCredentials()

        then:
        validator.validate(el).isEmpty()
    }

    static EncryptedCredentials validEncryptedCredentials() {
        EncryptedCredentials el = new EncryptedCredentials()
        el.data = "x"
        el.hash = "x"
        el.secret = "x"
        el
    }
}
