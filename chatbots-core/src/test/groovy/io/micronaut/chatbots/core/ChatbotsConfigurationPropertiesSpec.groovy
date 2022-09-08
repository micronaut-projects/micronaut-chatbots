package io.micronaut.chatbots.core

import spock.lang.Specification

class ChatbotsConfigurationPropertiesSpec extends Specification {

    void "ChatbotsConfiguration defaults"() {
        given:
        ChatbotsConfigurationProperties conf = new ChatbotsConfigurationProperties()

        expect:
        conf.enabled
        [FileExtension.MARKDOWN, FileExtension.HTML, FileExtension.TXT] == conf.possibleStaticCommandExtensions
    }
}
