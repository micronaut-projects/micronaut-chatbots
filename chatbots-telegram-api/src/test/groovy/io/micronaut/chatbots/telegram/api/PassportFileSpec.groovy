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
class PassportFileSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "PassportFile is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(PassportFile))

        then:
        noExceptionThrown()
    }

    void "PassportFile is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(PassportFile))

        then:
        noExceptionThrown()
    }

    void "PassportFile is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(PassportFile)

        then:
        noExceptionThrown()
    }

    void "PassportFile::toString() does not throw NPE"() {
        when:
        new PassportFile().toString()

        then:
        noExceptionThrown()
    }

    void "valid PassportFile does not trigger any constraint exception"() {
        when:
        PassportFile el = validPassportFile()

        then:
        validator.validate(el).isEmpty()
    }

    static PassportFile validPassportFile() {
        PassportFile el = new PassportFile()
        el.fileId = "xxx"
        el.fileUniqueId = "xxx.yyy"
        el.fileSize = 20
        el.fileDate = 20
        el
    }
}
