package io.micronaut.chatbots.telegram.api

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.context.BeanContext
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.annotation.Nullable
import io.micronaut.core.beans.BeanIntrospection
import io.micronaut.core.type.Argument
import io.micronaut.serde.ObjectMapper
import io.micronaut.serde.SerdeIntrospections
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import jakarta.validation.Valid
import jakarta.validation.Validator
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@MicronautTest(startApplication = false)
class StickerSetSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "StickerSet is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(StickerSet))

        then:
        noExceptionThrown()
    }

    void "StickerSet is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(StickerSet))

        then:
        noExceptionThrown()
    }

    void "StickerSet is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(StickerSet)

        then:
        noExceptionThrown()
    }

    void "StickerSet::toString() does not throw NPE"() {
        when:
        new StickerSet().toString()

        then:
        noExceptionThrown()
    }

    void "valid StickerSet does not trigger any constraint exception"() {
        when:
        StickerSet el = validStickerSet()

        then:
        validator.validate(el).isEmpty()
    }

    static StickerSet validStickerSet() {
        new StickerSet().tap {
            name = 'x'
            title = 'x'
            animated = false
            containsMasks = false
            stickers = []
            thumb = null
        }
    }
}
