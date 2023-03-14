package io.micronaut.chatbots.basecamp

import io.micronaut.context.ApplicationContext
import spock.lang.Specification

class HelloWorldHandlerSpec extends Specification {

    void "bean of type HelloWorldHandler exists"() {
        given:
        ApplicationContext ctx = ApplicationContext.run()
        expect:
        ctx.containsBean(HelloWorldHandler)
        cleanup:
        ctx.close()
    }
}
