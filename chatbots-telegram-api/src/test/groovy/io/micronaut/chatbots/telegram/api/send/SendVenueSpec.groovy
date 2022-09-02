package io.micronaut.chatbots.telegram.api.send

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
class SendVenueSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendVenue is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendVenue))

        then:
        noExceptionThrown()
    }

    void "SendVenue is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendVenue))

        then:
        noExceptionThrown()
    }

    void "SendVenue is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendVenue)

        then:
        noExceptionThrown()
    }

    void "SendVenue::toString() does not throw NPE"() {
        when:
        new SendVenue().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendVenue does not trigger any constraint exception"() {
        when:
        SendVenue el = validSendVenue()

        then:
        validator.validate(el).isEmpty()
    }

    static SendVenue validSendVenue() {
        SendVenue el = new SendVenue()
        el.chatId = "xx"
        el.latitude = 1f
        el.longitude = 2f
        el.address = "x"
        el.title = "x"
        el.foursquareId = null
        el.foursquareType = null
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        SendVenue el = validSendVenue()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
