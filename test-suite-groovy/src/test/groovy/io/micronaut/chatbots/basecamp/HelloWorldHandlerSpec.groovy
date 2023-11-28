package io.micronaut.chatbots.basecamp

import io.micronaut.context.BeanContext
import io.micronaut.context.annotation.Property
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest(startApplication = false)
@Property(name = "spec.name", value = "basecamp")
class HelloWorldHandlerSpec extends Specification {

    @Inject
    BeanContext ctx

    void "bean of type HelloWorldHandler exists"() {
        expect:
        ctx.containsBean(HelloWorldHandler)
    }
}
