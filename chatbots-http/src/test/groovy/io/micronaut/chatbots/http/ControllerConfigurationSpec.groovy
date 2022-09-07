package io.micronaut.chatbots.http

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Property
import io.micronaut.context.annotation.Requires
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@Property(name = "spec.name", value = "ControllerConfigurationSpec")
@MicronautTest
class ControllerConfigurationSpec extends Specification {

    @Inject
    ControllerConfiguration configuration

    void "defaults to enable"() {
        expect:
        configuration.enabled
    }

    void "defaults to path in constructor"() {
        expect:
        '/bar' == configuration.path
    }

    @Requires(property = "spec.name", value = "ControllerConfigurationSpec")
    @ConfigurationProperties("foo")
    static class FooConfiguration extends ControllerConfigurationProperties {

        FooConfiguration() {
            super("/bar")
        }
    }
}
