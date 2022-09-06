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
class UserSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "User is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(User))

        then:
        noExceptionThrown()
    }

    void "User is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(User))

        then:
        noExceptionThrown()
    }

    void "User is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(User)

        then:
        noExceptionThrown()
    }

    void "User::toString() does not throw NPE"() {
        when:
        new User().toString()

        then:
        noExceptionThrown()
    }

    void "valid User does not trigger any constraint exception"() {
        when:
        User el = validUser()

        then:
        validator.validate(el).isEmpty()
    }

    void "lower Kebab case is used in Json serialization"() {
        given:
        User el = validUser()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains("name")
    }

    static User validUser() {
        User el = new User()
        el.name = "foo"
        el
    }
}
