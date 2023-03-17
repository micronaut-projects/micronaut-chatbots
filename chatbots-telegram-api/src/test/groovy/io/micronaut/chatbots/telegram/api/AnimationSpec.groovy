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
class AnimationSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Animation is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Animation))

        then:
        noExceptionThrown()
    }

    void "Animation is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Animation))

        then:
        noExceptionThrown()
    }

    void "Animation is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Animation)

        then:
        noExceptionThrown()
    }

    void "Animation::toString() does not throw NPE"() {
        when:
        new Animation().toString()

        then:
        noExceptionThrown()
    }

    void "valid Animation does not trigger any constraint exception"() {
        when:
        Animation el = validAnimation()

        then:
        validator.validate(el).isEmpty()
    }

    void "fileId is required"() {
        given:
        Animation el = validAnimation()

        when:
        el.fileId = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "fileUniqueId is required"() {
        given:
        Animation el = validAnimation()

        when:
        el.fileUniqueId = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "width is required"() {
        given:
        Animation el = validAnimation()

        when:
        el.width = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "height is required"() {
        given:
        Animation el = validAnimation()

        when:
        el.height = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "duration is required"() {
        given:
        Animation el = validAnimation()

        when:

        el.duration = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "fileName is optional"() {
        given:
        Animation el = validAnimation()

        when:
        el.fileName = null

        then:
        validator.validate(el).isEmpty()
    }

    void "thumb is optional"() {
        given:
        Animation el = validAnimation()

        when:
        el.thumb = null

        then:
        validator.validate(el).isEmpty()
    }

    void "mimeType is optional"() {
        given:
        Animation el = validAnimation()

        when:
        el.mimeType = null

        then:
        validator.validate(el).isEmpty()
    }

    void "fileSize is optional"() {
        given:
        Animation el = validAnimation()

        when:
        el.fileSize = null

        then:
        validator.validate(el).isEmpty()
    }

    void "values are present in json"() {
        given:
        Animation el = new Animation()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.width = 200
        el.height = 300
        el.duration = 10
        el.fileName = 'foo'
        el.mimeType = "mime"
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('"file_id":"xxx"')
        json.contains('"file_unique_id":"xxx.yyy"')
        json.contains('"width":200')
        json.contains('"height":300')
        json.contains('"file_size":120')
        json.contains('"mime_type":"mime"')
        json.contains('"file_name":"foo"')
    }

    void "snake case is used for Json serialization"() {
        given:
        Animation el = new Animation()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.width = 200
        el.height = 300
        el.duration = 10
        el.fileName = 'foo'
        el.mimeType = "mime"
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        json.contains('width')
        json.contains('height')
        json.contains('file_size')
        json.contains('mime_type')
        json.contains('file_name')
        !json.contains('fileId')
        !json.contains('fileUniqueId')
        !json.contains('fileSize')
        !json.contains('mimeType')
        !json.contains('fileName')
    }

    void "only non null fields are included"() {
        given:
        Animation el = new Animation()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.width = 200
        el.height = 300
        el.duration = 10
        el.fileSize = 120
        el.fileName = 'foo'
        el.mimeType = "mime"

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        json.contains('width')
        json.contains('height')
        json.contains('file_size')
        json.contains('file_name')
        json.contains('mime_type')

        when:
        el.fileSize = null
        el.mimeType = null
        el.fileName = null
        json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        json.contains('width')
        json.contains('height')
        !json.contains('file_size')
        !json.contains('file_name')
        !json.contains('mime_type')
    }

    static Animation validAnimation() {
        Animation el = new Animation()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.width = 200
        el.height = 300
        el.duration = 10
        el
    }
}
