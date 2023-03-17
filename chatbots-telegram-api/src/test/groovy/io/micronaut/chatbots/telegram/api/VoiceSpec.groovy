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
class VoiceSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Voice is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Voice))

        then:
        noExceptionThrown()
    }

    void "Voice is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Voice))

        then:
        noExceptionThrown()
    }

    void "Voice is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Voice)

        then:
        noExceptionThrown()
    }

    void "Voice::toString() does not throw NPE"() {
        when:
        new Voice().toString()

        then:
        noExceptionThrown()
    }

    void "valid Voice does not trigger any constraint exception"() {
        when:
        Voice el = validVoice()

        then:
        validator.validate(el).isEmpty()
    }

    void "fileId is required"() {
        given:
        Voice el = validVoice()

        when:
        el.fileId = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "fileUniqueId is required"() {
        given:
        Voice el = validVoice()

        when:
        el.fileUniqueId = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "duration is required"() {
        given:
        Voice el = validVoice()

        when:

        el.duration = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "mimeType is optional"() {
        given:
        Voice el = validVoice()

        when:
        el.mimeType = null

        then:
        validator.validate(el).isEmpty()
    }

    void "fileSize is optional"() {
        given:
        Voice el = validVoice()

        when:
        el.fileSize = null

        then:
        validator.validate(el).isEmpty()
    }

    void "values are present in json"() {
        given:
        Voice el = new Voice()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.duration = 10
        el.mimeType = "mime"
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('"file_id":"xxx"')
        json.contains('"file_unique_id":"xxx.yyy"')
        json.contains('"file_size":120')
        json.contains('"mime_type":"mime"')
        json.contains('"duration":10')
    }

    void "snake case is used for Json serialization"() {
        given:
        Voice el = new Voice()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.duration = 10
        el.mimeType = "mime"
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        json.contains('file_size')
        json.contains('mime_type')
        !json.contains('fileId')
        !json.contains('fileUniqueId')
        !json.contains('fileSize')
        !json.contains('mimeType')
        !json.contains('fileName')
    }

    void "only non null fields are included"() {
        given:
        Voice el = new Voice()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.duration = 200
        el.fileSize = 120
        el.mimeType = "mime"

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        json.contains('file_size')
        json.contains('mime_type')

        when:
        el.fileSize = null
        el.mimeType = null
        json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        !json.contains('file_size')
        !json.contains('mime_type')
    }

    static Voice validVoice() {
        Voice el = new Voice()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.duration = 10
        el
    }
}
