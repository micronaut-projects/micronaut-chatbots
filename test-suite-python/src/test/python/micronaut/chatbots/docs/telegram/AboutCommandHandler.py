from jakarta.inject import Singleton
from java.util import Optional
from micronaut.chatbots.core import SpaceParser, TextResourceLoader
from micronaut.chatbots.telegram.api import Chat, Update
from micronaut.chatbots.telegram.api.send import SendMessage
from micronaut.chatbots.telegram.core import (
    ParseModeUtils,
    SendMessageUtils,
    TelegramBotConfiguration,
    TelegramHandler,
    TelegramSlashCommandParser,
)
from micronaut.context.annotation import Executable, Requires


@Requires(property="spec.name", value="telegram")
# tag::class[]
@Singleton
class AboutCommandHandler(TelegramHandler[SendMessage]):

    COMMAND_ABOUT: str = "/about"

    def __init__(self,
                 slash_command_parser: TelegramSlashCommandParser,
                 text_resource_loader: TextResourceLoader,
                 space_parser: SpaceParser[Update, Chat]):
        self.slash_command_parser = slash_command_parser
        self.text_resource_loader = text_resource_loader
        self.space_parser = space_parser

    def getCommand(self) -> str:
        return AboutCommandHandler.COMMAND_ABOUT

    def canHandle(self, bot: TelegramBotConfiguration | None, input: Update) -> bool:
        command = self.slash_command_parser.parse(input)
        return command.isPresent() and command.get().startswith(self.getCommand())

    def handle(self, bot: TelegramBotConfiguration | None, input: Update) -> Optional[SendMessage]:
        command = self.slash_command_parser.parse(input)
        if not command.isPresent():
            return Optional.empty()
        response = self.text_resource_loader.composeCommandResponse(command.get())
        if not response.isPresent():
            return Optional.empty()
        parse_mode = ParseModeUtils.parseModeOfFileExtension(response.get().extension()).orElse(None)
        return SendMessageUtils.compose(self.space_parser, input, response.get().text(), parse_mode)

    @Executable  # overrides the default getOrder() method of the Handler interface
    def getOrder(self) -> int:
        return -10
# end::class[]
