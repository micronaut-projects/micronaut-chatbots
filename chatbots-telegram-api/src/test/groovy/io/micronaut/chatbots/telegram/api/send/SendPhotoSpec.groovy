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
class SendPhotoSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "SendPhoto is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(SendPhoto))

        then:
        noExceptionThrown()
    }

    void "SendPhoto is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(SendPhoto))

        then:
        noExceptionThrown()
    }

    void "SendPhoto is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(SendPhoto)

        then:
        noExceptionThrown()
    }

    void "SendPhoto::toString() does not throw NPE"() {
        when:
        new SendPhoto().toString()

        then:
        noExceptionThrown()
    }

    void "valid SendPhoto does not trigger any constraint exception"() {
        when:
        SendPhoto el = validSendPhoto()

        then:
        validator.validate(el).isEmpty()
    }

    static SendPhoto validSendPhoto() {
        SendPhoto el = new SendPhoto()
        el.chatId = "xx"
        el.photo = "xx"
        el.parseMode = null
        el.caption = null
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        SendPhoto el = validSendPhoto()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('chat_id')
    }
}
