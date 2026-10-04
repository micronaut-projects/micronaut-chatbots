from jakarta.inject import Singleton
from java.util import Optional
from micronaut.chatbots.core import SpaceParser
from micronaut.chatbots.telegram.api import Chat, Update
from micronaut.chatbots.telegram.api.send import SendMessage
from micronaut.chatbots.telegram.core import SendMessageUtils, TelegramBotConfiguration, TelegramHandler
from micronaut.context.annotation import Requires


@Requires(property="spec.name", value="telegram")
# tag::class[]
@Singleton
class HelloWorldHandler(TelegramHandler[SendMessage]):

    def __init__(self, space_parser: SpaceParser[Update, Chat]):
        self.space_parser = space_parser

    def canHandle(self, bot: TelegramBotConfiguration | None, input: Update) -> bool:
        return "hello" in input.getMessage().getText()

    def handle(self, bot: TelegramBotConfiguration | None, input: Update) -> Optional[SendMessage]:
        return SendMessageUtils.compose(self.space_parser, input, "Hello World")
# end::class[]
