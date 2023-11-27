package io.micronaut.chatbots.telegram.core

import io.micronaut.chatbots.core.*
import io.micronaut.chatbots.telegram.api.Chat
import io.micronaut.chatbots.telegram.api.Update
import io.micronaut.chatbots.telegram.api.send.ParseMode
import io.micronaut.chatbots.telegram.api.send.Send
import io.micronaut.chatbots.telegram.api.send.SendMessage
import io.micronaut.context.annotation.Property
import io.micronaut.context.annotation.Requires
import io.micronaut.serde.ObjectMapper
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import jakarta.inject.Singleton
import spock.lang.Specification

@Property(name = "spec.name", value = "CommandSpec")
@MicronautTest(startApplication = false)
class CommandSpec extends Specification {

    @Inject
    Dispatcher<TelegramBotConfiguration, Update, Send> dispatcher

    @Inject
    ObjectMapper objectMapper

    void "static command responses"() {
        given:
        File f = new File("src/test/resources/about.json")

        expect:
        f.exists()

        when:
        Update update = objectMapper.readValue(f.text, Update)

        then:
        update

        when:
        Optional<Send> response = dispatcher.dispatch(null, update)
        then:
        response.isPresent()
        response.get() instanceof SendMessage

        when:
        SendMessage sendMessage = (SendMessage) response.get()
        then:
        ParseMode.MARKDOWN.toString() == sendMessage.parseMode
        'Bot developed with  💙and the [Micronaut Framework](https://micronaut.io)\n' == sendMessage.text
        "sendMessage" == sendMessage.method
        613021175 == sendMessage.chatId

        when:
        f = new File("src/test/resources/grouphelp.json")
        update = objectMapper.readValue(f.text, Update)

        then:
        !dispatcher.dispatch(null, update).isPresent()
    }

    @Requires(property = "spec.name", value = "CommandSpec")
    @Singleton
    static class AboutHandler extends CommandHandler {
        protected AboutHandler(TelegramSlashCommandParser slashCommandParser,
                               TextResourceLoader textResourceLoader,
                               SpaceParser<Update, Chat> spaceParser) {
            super(slashCommandParser, textResourceLoader, spaceParser)
        }

        @Override
        String getCommand() {
            '/about'
        }
    }
}
