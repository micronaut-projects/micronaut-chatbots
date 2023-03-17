package io.micronaut.chatbots.telegram.api.send

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
class SendLocationSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendLocation is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendLocation))

        then:
        noExceptionThrown()
    }

    void "SendLocation is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendLocation))

        then:
        noExceptionThrown()
    }

    void "SendLocation is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendLocation)

        then:
        noExceptionThrown()
    }

    void "SendLocation::toString() does not throw NPE"() {
        when:
        new SendLocation().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendLocation does not trigger any constraint exception"() {
        when:
        SendLocation el = validSendLocation()

        then:
        validator.validate(el).isEmpty()
    }

    static SendLocation validSendLocation() {
        SendLocation el = new SendLocation()
        el.chatId = "xx"
        el.longitude = 1f
        el.latitude = 1f
        el.livePeriod = null
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        SendLocation el = validSendLocation()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
