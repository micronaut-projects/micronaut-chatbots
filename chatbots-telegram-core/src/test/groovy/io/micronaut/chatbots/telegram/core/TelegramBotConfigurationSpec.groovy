package io.micronaut.chatbots.telegram.core

import io.micronaut.chatbots.telegram.core.TelegramBotConfiguration
import io.micronaut.context.annotation.Property
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@Property(name = "micronaut.chatbots.telegram.bots.r2d2.token", value = "XXX")
@Property(name = "micronaut.chatbots.telegram.bots.r2d2.at-username", value = "@R2D2")
@MicronautTest(startApplication = false)
class TelegramBotConfigurationSpec extends Specification {

    @Inject
    TelegramBotConfiguration telegramBotConfiguration

    void "TelegramBotConfiguration is enabled by default"() {
        expect:
        telegramBotConfiguration.enabled
        'r2d2' == telegramBotConfiguration.name
        '@R2D2' == telegramBotConfiguration.atUsername
        'XXX' == telegramBotConfiguration.token
    }
}
