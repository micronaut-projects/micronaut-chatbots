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
class QuerySpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Query is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Query))

        then:
        noExceptionThrown()
    }

    void "Query is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Query))

        then:
        noExceptionThrown()
    }

    void "Query is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Query)

        then:
        noExceptionThrown()
    }

    void "Query::toString() does not throw NPE"() {
        when:
        new Query().toString()

        then:
        noExceptionThrown()
    }

    void "valid Query does not trigger any constraint exception"() {
        when:
        Query el = validQuery()

        then:
        validator.validate(el).isEmpty()
    }

    void "command is required"() {
        given:
        Query el = validQuery()

        when:
        el.command = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "callbackUrl is required"() {
        given:
        Query el = validQuery()

        when:
        el.callbackUrl = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "snake case is used for Json serialization"() {
        given:
        Query el = validQuery()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('command')
        json.contains('callback_url')
        !json.contains('callbackUrl')

    }

    static Query validQuery() {
        new Query().tap {
            command = 'Hello World'
            creator = CreatorSpec.validCreator()
            callbackUrl =  "https://3.basecamp.com/5317339/integrations/3QpCCCnvQzDbW6VBByq3Y87o/buckets/26555285/chats/4701195812/lines"
        }
    }
}
