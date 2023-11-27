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
class VideoNoteSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "VideoNote is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(VideoNote))

        then:
        noExceptionThrown()
    }

    void "VideoNote is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(VideoNote))

        then:
        noExceptionThrown()
    }

    void "VideoNote is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(VideoNote)

        then:
        noExceptionThrown()
    }

    void "VideoNote::toString() does not throw NPE"() {
        when:
        new VideoNote().toString()

        then:
        noExceptionThrown()
    }

    void "valid VideoNote does not trigger any constraint exception"() {
        when:
        VideoNote el = validVideoNote()

        then:
        validator.validate(el).isEmpty()
    }

    void "fileId is required"() {
        given:
        VideoNote el = validVideoNote()

        when:
        el.fileId = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "fileUniqueId is required"() {
        given:
        VideoNote el = validVideoNote()

        when:
        el.fileUniqueId = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "duration is required"() {
        given:
        VideoNote el = validVideoNote()

        when:

        el.duration = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "thumb is optional"() {
        given:
        VideoNote el = validVideoNote()

        when:
        el.thumb = null

        then:
        validator.validate(el).isEmpty()
    }

    void "fileSize is optional"() {
        given:
        VideoNote el = validVideoNote()

        when:
        el.fileSize = null

        then:
        validator.validate(el).isEmpty()
    }

    void "values are present in json"() {
        given:
        VideoNote el = new VideoNote()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.duration = 10
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('"file_id":"xxx"')
        json.contains('"file_unique_id":"xxx.yyy"')
        json.contains('"file_size":120')
        json.contains('"duration":10')
    }

    void "snake case is used for Json serialization"() {
        given:
        VideoNote el = new VideoNote()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.duration = 10
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        json.contains('file_size')
        !json.contains('fileId')
        !json.contains('fileUniqueId')
        !json.contains('fileSize')
    }

    void "only non null fields are included"() {
        given:
        VideoNote el = new VideoNote()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.duration = 200
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        json.contains('file_size')

        when:
        el.fileSize = null
        el.thumb = null
        json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        !json.contains('file_size')
    }

    static VideoNote validVideoNote() {
        new VideoNote().tap {
            fileId = "xxx"
            fileUniqueId = "xxx.yyy"
            duration = 10
            length = 20
        }
    }
}
