package io.micronaut.chatbots.telegram.api

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
class InlineQuerySpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "InlineQuery is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(InlineQuery))

        then:
        noExceptionThrown()
    }

    void "InlineQuery is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(InlineQuery))

        then:
        noExceptionThrown()
    }

    void "InlineQuery is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(InlineQuery)

        then:
        noExceptionThrown()
    }

    void "InlineQuery::toString() does not throw NPE"() {
        when:
        new InlineQuery().toString()

        then:
        noExceptionThrown()
    }

    void "valid InlineQuery does not trigger any constraint exception"() {
        when:
        InlineQuery el = validInlineQuery()

        then:
        validator.validate(el).isEmpty()
    }

    static InlineQuery validInlineQuery() {
        InlineQuery el = new InlineQuery()
        el.id = "x"
        el.from = validUser()
        el.query = "foo"
        el.offset = "f"
        el.chatType = null
        el.location = null
        el
    }

    static User validUser() {
        User el = new User()
        el.id = 1L
        el.bot = false
        el.firstName = "foo"
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        InlineQuery el = validInlineQuery()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('id')
        json.contains('bot')
        json.contains('first_name')
    }
}
