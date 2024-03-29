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
class GameSpec extends Specification {
    @Inject
    ObjectMapper objectMapper

    @Inject
    Validator validator

    @Inject
    BeanContext beanContext

    void "Game is annotated with @Serdeable.Deserializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getDeserializableIntrospection(Argument.of(Game))

        then:
        noExceptionThrown()
    }

    void "Game is annotated with @Serdeable.Serializable"() {
        given:
        SerdeIntrospections serdeIntrospections = beanContext.getBean(SerdeIntrospections)

        when:
        serdeIntrospections.getSerializableIntrospection(Argument.of(Game))

        then:
        noExceptionThrown()
    }

    void "Game is annotated with Introspected"() {
        when:
        BeanIntrospection.getIntrospection(Game)

        then:
        noExceptionThrown()
    }

    void "Game::toString() does not throw NPE"() {
        when:
        new Game().toString()

        then:
        noExceptionThrown()
    }

    void "valid Game does not trigger any constraint exception"() {
        when:
        Game el = validGame()

        then:
        validator.validate(el).isEmpty()
    }

    static Game validGame() {
        new Game().tap {
            title = "x"
            description = "x"
            photo = []
            text = null
            textEntities = null
            animation = null
        }
    }
}
