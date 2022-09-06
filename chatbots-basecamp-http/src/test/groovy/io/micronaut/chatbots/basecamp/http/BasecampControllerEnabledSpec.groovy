package io.micronaut.chatbots.basecamp.http

import io.micronaut.chatbots.http.ControllerConfiguration
import io.micronaut.context.ApplicationContext
import io.micronaut.context.exceptions.NoSuchBeanException
import io.micronaut.core.util.StringUtils
import spock.lang.Specification
import spock.lang.Unroll

class BasecampControllerEnabledSpec extends Specification {

    @Unroll("micronaut.chatbots.basecamp.endpoint.enabled=false bean [#description] is not loaded")
    void "micronaut.chatbots.basecamp.endpoint.enabled=false security related beans are not loaded"(Class clazz, String description) {
        ApplicationContext applicationContext = ApplicationContext.run(['micronaut.chatbots.basecamp.endpoint.enabled': StringUtils.FALSE])

        when:
        applicationContext.getBean(clazz)

        then:
        NoSuchBeanException e = thrown()
        e.message.contains('No bean of type ['+clazz.name+'] exists.')

        where:
        clazz << [
                BasecampController,
                ControllerConfiguration
        ]

        description = clazz.name
    }

}
