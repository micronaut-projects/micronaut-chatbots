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
class FileSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "File is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(File))

        then:
        noExceptionThrown()
    }

    void "File is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(File))

        then:
        noExceptionThrown()
    }

    void "File is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(File)

        then:
        noExceptionThrown()
    }

    void "File::toString() does not throw NPE"() {
        when:
        new File().toString()

        then:
        noExceptionThrown()
    }

    void "valid File does not trigger any constraint exception"() {
        when:
        File el = validFile()

        then:
        validator.validate(el).isEmpty()
    }

    static File validFile() {
        File el = new File()
        el.fileId = "x"
        el.fileUniqueId = "y"
        el.filePath = null
        el.fileSize = null
        el
    }

    void "snake case is used for Json serialization"() {
        given:
        File el = validFile()

        when:
        String json = objectMapper.writeValueAsString(el)

        then:
        json.contains('file_id')
        json.contains('file_unique_id')
    }
}
