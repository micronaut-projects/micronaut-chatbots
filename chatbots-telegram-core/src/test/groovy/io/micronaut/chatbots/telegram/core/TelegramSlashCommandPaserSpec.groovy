package io.micronaut.chatbots.telegram.core

import io.micronaut.chatbots.core.SlashCommandParser
import io.micronaut.chatbots.telegram.api.Update
import io.micronaut.serde.ObjectMapper
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.lang.Unroll

@MicronautTest(startApplication = false)
class TelegramSlashCommandPaserSpec extends Specification {

    @Inject
    SlashCommandParser<Update> slashCommandParser

    @Inject
    ObjectMapper objectMapper

    @Unroll
    void "can parse bot commands"(String fileName, String command) {
        given:
        File f = new File("src/test/resources/$fileName")

        expect:
        f.exists()

        when:
        Update update = getObjectMapper().readValue(f.text, Update)

        then:
        update

        when:
        Optional<String> result = slashCommandParser.parse(update)
        then:

        result.isPresent()
        command == result.get()

        where:
        fileName         | command
        'about.json'     | '/about'
        'grouphelp.json' | '/help'
    }

    @Unroll
    void "empty optional if not command"(String fileName) {
        given:
        File f = new File("src/test/resources/$fileName")

        expect:
        f.exists()

        when:
        Update update = getObjectMapper().readValue(f.text, Update)

        then:
        update

        when:
        Optional<String> result = slashCommandParser.parse(update)

        then:
        !result.isPresent()

        where:
        fileName << ['text.json']
    }
}
