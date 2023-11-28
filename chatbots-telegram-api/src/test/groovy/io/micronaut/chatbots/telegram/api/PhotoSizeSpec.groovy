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
class PhotoSizeSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "PhotoSize is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(PhotoSize))

        then:
        noExceptionThrown()
    }

    void "PhotoSize is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(PhotoSize))

        then:
        noExceptionThrown()
    }

    void "PhotoSize is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(PhotoSize)

        then:
        noExceptionThrown()
    }

    void "PhotoSize::toString() does not throw NPE"() {
        when:
        new PhotoSize().toString()

        then:
        noExceptionThrown()
    }

    void "valid PhotoSize does not trigger any constraint exception"() {
        when:
        PhotoSize el = validPhotoSize()

        then:
        validator.validate(el).isEmpty()
    }

    void "fileId is required"() {
        given:
        PhotoSize el = validPhotoSize()

        when:
        el.fileId = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "fileUniqueId is required"() {
        given:
        PhotoSize el = validPhotoSize()

        when:
        el.fileUniqueId = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "width is required"() {
        given:
        PhotoSize el = validPhotoSize()

        when:
        el.width = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "height is required"() {
        given:
        PhotoSize el = validPhotoSize()

        when:
        el.height = null

        then:
        !validator.validate(el).isEmpty()
    }

    void "fileSize is optional"() {
        given:
        PhotoSize el = validPhotoSize()

        when:
        el.fileSize = null

        then:
        validator.validate(el).isEmpty()
    }

    void "values are present in json"() {
        given:
        PhotoSize el = new PhotoSize()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.width = 200
        el.height = 300
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('"file_id":"xxx"')
        json.contains('"file_unique_id":"xxx.yyy"')
        json.contains('"width":200')
        json.contains('"height":300')
        json.contains('"file_size":120')
    }

    void "snake case is used for Json serialization"() {
        given:
        PhotoSize el = new PhotoSize()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.width = 200
        el.height = 300
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        json.contains('width')
        json.contains('height')
        json.contains('file_size')
        !json.contains('fileId')
        !json.contains('fileUniqueId')
        !json.contains('fileSize')
    }

    void "only non null fields are included"() {
        given:
        PhotoSize el = new PhotoSize()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.width = 200
        el.height = 300
        el.fileSize = 120

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        json.contains('width')
        json.contains('height')
        json.contains('file_size')

        when:
        el.fileSize = null
        json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
        json.contains('width')
        json.contains('height')
        !json.contains('file_size')
    }

    static PhotoSize validPhotoSize() {
        new PhotoSize().tap {
            fileId = "xxx"
            fileUniqueId = "xxx.yyy"
            width = 200
            height = 300
        }
    }
}
