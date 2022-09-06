package io.micronaut.chatbots.http

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Property
import io.micronaut.context.annotation.Requires
import io.micronaut.core.util.StringUtils
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@Property(name = "spec.name", value = "SetterControllerConfigurationSpec")
@Property(name = "foo.enabled", value = StringUtils.TRUE)
@Property(name = "foo.path", value = "/mooo")
@MicronautTest
class SetterControllerConfigurationSpec extends Specification {

    @Inject
    ControllerConfiguration configuration

    void "defaults to enable"() {
        expect:
        configuration.enabled
    }

    void "defaults to path in constructor"() {
        expect:
        '/mooo' == configuration.path

        when:
        ((ControllerConfigurationProperties) configuration).path = '/foo'

        then:
        '/foo' == configuration.path

        when:
        ((ControllerConfigurationProperties) configuration).enabled = false

        then:
        !configuration.enabled
    }

    @Requires(property = "spec.name", value = "SetterControllerConfigurationSpec")
    @ConfigurationProperties("foo")
    static class FooConfiguration extends ControllerConfigurationProperties {

        FooConfiguration() {
            super("/bar")
        }
    }
}
