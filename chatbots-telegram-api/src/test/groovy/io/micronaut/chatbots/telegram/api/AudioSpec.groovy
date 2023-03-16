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
class AudioSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Audio is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Audio))

        then:
        noExceptionThrown()
    }

    void "Audio is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Audio))

        then:
        noExceptionThrown()
    }

    void "Audio is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Audio)

        then:
        noExceptionThrown()
    }

    void "Audio::toString() does not throw NPE"() {
        when:
        new Audio().toString()

        then:
        noExceptionThrown()
    }

    void "valid Audio does not trigger any constraint exception"() {
        when:
        Audio el = validAudio()

        then:
        validator.validate(el).isEmpty()
    }

    void "fileId is required"() {
        given:
        Audio el = validAudio()

        when:
        el.fileId = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "fileUniqueId is required"() {
        given:
        Audio el = validAudio()

        when:
        el.fileUniqueId = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "duration is required"() {
        given:
        Audio el = validAudio()

        when:
        el.duration = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "performer is optional"() {
        given:
        Audio el = validAudio()

        when:
        el.performer = null

        then:
        validator.validate(el).isEmpty()
    }

    void "title is optional"() {
        given:
        Audio el = validAudio()

        when:

        el.title = null

        then:
        validator.validate(el).isEmpty()
    }

    void "mimeType is optional"() {
        given:
        Audio el = validAudio()

        when:
        el.mimeType = null

        then:
        validator.validate(el).isEmpty()
    }

    void "fileSize is optional"() {
        given:
        Audio el = validAudio()

        when:
        el.fileSize = null

        then:
        validator.validate(el).isEmpty()
    }

    void "thumb is optional"() {
        given:
        Audio el = validAudio()

        when:
        el.thumb = null

        then:
        validator.validate(el).isEmpty()
    }

    void "values are present in json"() {
        given:
        Audio el = new Audio()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.duration = 2
        el.performer = 'Norah Jones'
        el.title = 'Forever young'
        el.mimeType = "mime"
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('"file_id":"xxx"')
        json.contains('"file_unique_id":"xxx.yyy"')
        json.contains('"duration":2')
        json.contains('"performer":"Norah Jones"')
        json.contains('"file_size":120')
        json.contains('"mime_type":"mime"')
        json.contains('"title":"Forever young"')
    }

    void "snake case is used for Json serialization"() {
        given:
        Audio el = new Audio()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.duration = 2
        el.performer = 'Norah Jones'
        el.title = 'Forever young'
        el.mimeType = "mime"
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        json.contains('duration')
        json.contains('performer')
        json.contains('file_size')
        json.contains('mime_type')
        json.contains('title')
        !json.contains('fileId')
        !json.contains('fileUniqueId')
        !json.contains('fileSize')
        !json.contains('mimeType')
    }

    void "only non null fields are included"() {
        given:
        Audio el = new Audio()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.duration = 2
        el.performer = 'Norah Jones'
        el.title = 'Forever young'
        el.mimeType = "mime"
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        json.contains('duration')
        json.contains('performer')
        json.contains('file_size')
        json.contains('mime_type')
        json.contains('title')

        when:
        el.fileId = null
        el.fileUniqueId = null
        el.duration = null
        el.performer = null
        el.title = null
        el.mimeType = null
        el.fileSize = null
        json = objectMapper.writeValueAsString(el)

        then:
        !json.contains('file_id')
        !json.contains('file_unique_id')
        !json.contains('duration')
        !json.contains('performer')
        !json.contains('file_size')
        !json.contains('mime_type')
        !json.contains('title')
    }

    static Audio validAudio() {
        Audio el = new Audio()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.duration = 2
        el.performer = 'Norah Jones'
        el.title = 'Forever young'
        el.mimeType = "mime"
        el.fileSize = 120
        el
    }
}
