package io.micronaut.chatbots.core

import io.micronaut.context.annotation.Property
import io.micronaut.context.annotation.Requires
import io.micronaut.core.annotation.NonNull
import io.micronaut.core.annotation.Nullable
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import jakarta.inject.Singleton
import spock.lang.Specification
import jakarta.validation.constraints.NotNull

@Property(name = "spec.name", value = "CommandSpec")
@MicronautTest(startApplication = false)
class CommandSpec extends Specification {

    @Inject
    Dispatcher<BotConfiguration, String, CommandResponse> dispatcher

    void "static command responses"() {
        when:
        Optional<CommandResponse> response = dispatcher.dispatch(null, "/about")
        then:
        response.isPresent()
        FileExtension.MARKDOWN == response.get().extension
        'Bot developed with  💙and the [Micronaut Framework](https://micronaut.io)\n' == response.get().text

        and:
        !dispatcher.dispatch(null, "/help").isPresent()
    }

    @Requires(property = "spec.name", value = "CommandSpec")
    @Singleton
    static class MockHandler implements Handler<BotConfiguration, String, CommandResponse> {
        @Inject
        SlashCommandParser<String> slashCommandParser

        @Inject
        TextResourceLoader textResourceLoader

        @Override
        boolean canHandle(@Nullable BotConfiguration bot, @NonNull @NotNull String input) {
            true
        }

        @Override
        Optional<CommandResponse> handle(@Nullable BotConfiguration bot, @NonNull @NotNull String input) {
            slashCommandParser.parse(input).flatMap(textResourceLoader::composeCommandResponse)
        }
    }

    @Requires(property = "spec.name", value = "CommandSpec")
    @Singleton
    static class SlashCommandParserMock implements SlashCommandParser<String> {
        @Override
        Optional<String> parse(@NonNull String input) {
            return Optional.of(input)
        }
    }
}
