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
class StickerSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Sticker is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Sticker))

        then:
        noExceptionThrown()
    }

    void "Sticker is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Sticker))

        then:
        noExceptionThrown()
    }

    void "Sticker is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Sticker)

        then:
        noExceptionThrown()
    }

    void "Sticker::toString() does not throw NPE"() {
        when:
        new Sticker().toString()

        then:
        noExceptionThrown()
    }

    void "valid Sticker does not trigger any constraint exception"() {
        when:
        Sticker el = validSticker()

        then:
        validator.validate(el).isEmpty()
    }

    static Sticker validSticker() {
        new Sticker().tap {
            fileId = "xxx"
            fileUniqueId = "xxx.yyy"
            width = 1
            height = 1
            animated = true
            thumb = null
            emoji = null
            name = null
            maskPosition = null
            fileSize = null
        }
    }
}
