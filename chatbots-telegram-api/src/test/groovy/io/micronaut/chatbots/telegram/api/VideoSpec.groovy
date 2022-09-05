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
class VideoSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Video is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Video))

        then:
        noExceptionThrown()
    }

    void "Video is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Video))

        then:
        noExceptionThrown()
    }

    void "Video is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Video)

        then:
        noExceptionThrown()
    }

    void "Video::toString() does not throw NPE"() {
        when:
        new Video().toString()

        then:
        noExceptionThrown()
    }

    void "valid Video does not trigger any constraint exception"() {
        when:
        Video el = validVideo()

        then:
        validator.validate(el).isEmpty()
    }

    static Video validVideo() {
        Video el = new Video()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.width = 1
        el.height = 1
        el.duration = 1
        el.thumb = null
        el.mimeType = null
        el.fileSize = null
        el
    }
}
