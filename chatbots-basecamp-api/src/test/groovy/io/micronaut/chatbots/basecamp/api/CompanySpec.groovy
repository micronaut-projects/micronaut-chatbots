package io.micronaut.chatbots.basecamp.api

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
class CompanySpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Company is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Company))

        then:
        noExceptionThrown()
    }

    void "Company is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Company))

        then:
        noExceptionThrown()
    }

    void "Company is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Company)

        then:
        noExceptionThrown()
    }

    void "Company::toString() does not throw NPE"() {
        when:
        new Company().toString()

        then:
        noExceptionThrown()
    }

    void "valid Company does not trigger any constraint exception"() {
        when:
        Company el = validCompany()

        then:
        validator.validate(el).isEmpty()
    }

    static Company validCompany() {
        new Company().tap {
            id = 2975233
            name = "GoT"
        }
    }
}
