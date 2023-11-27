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
class CreatorSpec extends Specification {

    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Creator is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Creator))

        then:
        noExceptionThrown()
    }

    void "Creator is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Creator))

        then:
        noExceptionThrown()
    }

    void "Creator is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Creator)

        then:
        noExceptionThrown()
    }

    void "Creator::toString() does not throw NPE"() {
        when:
        new Creator().toString()

        then:
        noExceptionThrown()
    }

    void "valid Creator does not trigger any constraint exception"() {
        when:
        Creator el = validCreator()

        then:
        validator.validate(el).isEmpty()
    }

    void "snake case is used for Json serialization"() {
        given:
        Creator el = validCreator()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains("id")
        json.contains("name")
        !json.contains("attachableSgid")
        json.contains("attachable_sgid")
        !json.contains("emailAddress")
        json.contains("email_address")
        !json.contains("personableType")
        json.contains("personable_type")
        !json.contains("createdAt")
        json.contains("created_at")
        !json.contains("updatedAt")
        json.contains("updated_at")
        json.contains("admin")
        json.contains("owner")
        json.contains("client")
        !json.contains("timeZone")
        json.contains("time_zone")
        !json.contains("avatarUrl")
        json.contains("avatar_url")
        !json.contains("avatarKind")
        json.contains("avatar_kind")
    }

    static Creator validCreator() {
        new Creator().tap {
            id = 2975233
            name = "GoT"
            id= 38769516
            attachableSgid= "CCh7CEkiCGdpZAY6BkVUSSIpZ2lkOi8vYmMzL1BlcnNvbi8zODc2OTUxNj9leLLpcmVzX2luBjsAVEkiDHB1cnBvc2UGOwBUSSIPYXR0YWNoYWJsZQY7AFRJIg9leHBpcmVzX2F0BjsAVDA=--4ea255787306c901a68a3365023c6378ac5551bb"
            name= "John Snow"
            emailAddress= "johnsnow@example.com"
            personableType= "User"
            title= null
            bio= ""
            location= ""
            createdAt= "2022-03-04T16:53:05.749+01:00"
            updatedAt= "2022-06-16T10:53:51.826+02:00"
            admin= true
            owner= true
            client= false
            timeZone= "Europe/Madrid"
            avatarUrl= "https://bc3-production-assets-cdn.basecamp-static.com/5317339/people/CChpLLyTTwI=--60b1d50b9aed688dd10758ccad51320edcccad3f/avatar-64-x4?v=1"
            avatarKind = "custom"
            company = validCompany()
        }
    }
    static Company validCompany() {
        new Company().tap {
            id = 2975233
            name = "GoT"
        }
    }
}
