from jakarta.inject import Singleton
from micronaut.chatbots.core import SpaceParser, TextResourceLoader
from micronaut.chatbots.telegram.api import Chat, Update
from micronaut.chatbots.telegram.core import CommandHandler, TelegramSlashCommandParser
from micronaut.context.annotation import Requires


@Requires(property="spec.name", value="telegram")
# tag::class[]
@Singleton
class AboutCommandHandler(CommandHandler):

    COMMAND_ABOUT: str = "/about"

    def __init__(self,
                 slash_command_parser: TelegramSlashCommandParser,
                 text_resource_loader: TextResourceLoader,
                 space_parser: SpaceParser[Update, Chat]):
        super().__init__(slash_command_parser, text_resource_loader, space_parser)

    def getCommand(self) -> str:
        return AboutCommandHandler.COMMAND_ABOUT
# end::class[]
