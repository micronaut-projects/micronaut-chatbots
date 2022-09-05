package io.micronaut.chatbots.basecamp.api

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
        Creator el = new Creator()
        el.id = 2975233
        el.name = "GoT"
        el.id= 38769516
        el.attachableSgid= "CCh7CEkiCGdpZAY6BkVUSSIpZ2lkOi8vYmMzL1BlcnNvbi8zODc2OTUxNj9leLLpcmVzX2luBjsAVEkiDHB1cnBvc2UGOwBUSSIPYXR0YWNoYWJsZQY7AFRJIg9leHBpcmVzX2F0BjsAVDA=--4ea255787306c901a68a3365023c6378ac5551bb"
        el.name= "John Snow"
        el.emailAddress= "johnsnow@example.com"
        el.personableType= "User"
        el.title= null
        el.bio= ""
        el.location= ""
        el.createdAt= "2022-03-04T16:53:05.749+01:00"
        el.updatedAt= "2022-06-16T10:53:51.826+02:00"
        el.admin= true
        el.owner= true
        el.client= false
        el.timeZone= "Europe/Madrid"
        el.avatarUrl= "https://bc3-production-assets-cdn.basecamp-static.com/5317339/people/CChpLLyTTwI=--60b1d50b9aed688dd10758ccad51320edcccad3f/avatar-64-x4?v=1"
        el.avatarKind = "custom"
        el.company = validCompany()
        el
    }
    static Company validCompany() {
        Company el = new Company()
        el.id = 2975233
        el.name = "GoT"
        el
    }
}
