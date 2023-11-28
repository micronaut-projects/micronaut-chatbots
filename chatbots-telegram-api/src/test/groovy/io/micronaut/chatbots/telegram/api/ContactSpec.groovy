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
class ContactSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Contact is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Contact))

        then:
        noExceptionThrown()
    }

    void "Contact is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Contact))

        then:
        noExceptionThrown()
    }

    void "Contact is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Contact)

        then:
        noExceptionThrown()
    }

    void "Contact::toString() does not throw NPE"() {
        when:
        new Contact().toString()

        then:
        noExceptionThrown()
    }

    void "valid Contact does not trigger any constraint exception"() {
        when:
        Contact el = validContact()

        then:
        validator.validate(el).isEmpty()
    }

    void "phoneNumber is required"() {
        given:
        Contact el = validContact()

        when:
        el.phoneNumber = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "firstName is required"() {
        given:
        Contact el = validContact()

        when:
        el.firstName = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "lastName is optional"() {
        given:
        Contact el = validContact()

        when:
        el.lastName = null

        then:
        validator.validate(el).isEmpty()
    }

    void "userId is optional"() {
        given:
        Contact el = validContact()

        when:
        el.userId = null

        then:
        validator.validate(el).isEmpty()
    }

    void "vcard is optional"() {
        given:
        Contact el = validContact()

        when:

        el.vcard = null

        then:
        validator.validate(el).isEmpty()
    }


    void "values are present in json"() {
        given:
        Contact el = new Contact()
        el.phoneNumber = '+34630444444'
        el.firstName = 'Sergio'
        el.lastName = 'del Amo'
        el.userId = 12345
        el.vcard = 'BEGIN:VCARD'

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('"phone_number":"+34630444444"')
        json.contains('"first_name":"Sergio"')
        json.contains('"last_name":"del Amo"')
        json.contains('"user_id":12345')
        json.contains('"vcard":"BEGIN:VCARD"')
    }

    void "snake case is used for Json serialization"() {
        given:
        Contact el = new Contact()
        el.phoneNumber = '+34630444444'
        el.firstName = 'Sergio'
        el.lastName = 'del Amo'
        el.userId = 12345
        el.vcard = 'BEGIN:VCARD'

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('phone_number')
        json.contains('first_name')
        json.contains('last_name')
        json.contains('user_id')
        !json.contains('phoneNumber')
        !json.contains('firstName')
        !json.contains('lastName')
        !json.contains('userId')
    }

    void "only non null fields are included"() {
        given:
        Contact el = new Contact()
        el.phoneNumber = '+34630444444'
        el.firstName = 'Sergio'
        el.lastName = 'del Amo'
        el.userId = 12345
        el.vcard = 'BEGIN:VCARD'

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('phone_number')
        json.contains('first_name')
        json.contains('last_name')
        json.contains('user_id')

        when:
        el.phoneNumber = null
        el.firstName = null
        el.lastName = null
        el.userId = null
        el.vcard = null
        json = objectMapper.writeValueAsString(el)

        then:
        !json.contains('phone_number')
        !json.contains('first_name')
        !json.contains('last_name')
        !json.contains('user_id')
    }

    static Contact validContact() {
        new Contact().tap {
            phoneNumber = '+34630444444'
            firstName = 'Sergio'
        }
    }
}
