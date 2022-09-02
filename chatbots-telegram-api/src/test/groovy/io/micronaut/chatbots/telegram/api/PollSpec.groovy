package io.micronaut.chatbots.telegram.api

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.context.BeanContext
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.beans.BeanIntrospection
import io.micronaut.core.type.Argument
import io.micronaut.serde.ObjectMapper
import io.micronaut.serde.SerdeIntrospections
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import javax.validation.Validator
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

@MicronautTest(startApplication = false)
class PollSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Poll is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Poll))

        then:
        noExceptionThrown()
    }

    void "Poll is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Poll))

        then:
        noExceptionThrown()
    }

    void "Poll is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Poll)

        then:
        noExceptionThrown()
    }

    void "Poll::toString() does not throw NPE"() {
        when:
        new Poll().toString()

        then:
        noExceptionThrown()
    }



    void "valid Poll does not trigger any constraint exception"() {
        when:
        Poll el = validPoll()

        then:
        validator.validate(el).isEmpty()
    }

    static Poll validPoll() {
        Poll el = new Poll()
        el.id = 'x'
        el.question = 'x'
        el.options = []
        el.totalVoterCount = 1
        el.closed = false
        el.anonymous = false
        el.type = 'regular'
        el.allowsMultipleAnswers = false
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        Poll el = validPoll()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('question')
        json.contains('total_voter_count')
        json.contains('id')
        json.contains('is_closed')
        json.contains('is_anonymous')
        json.contains('type')
        json.contains('allows_multiple_answers')
    }

}
