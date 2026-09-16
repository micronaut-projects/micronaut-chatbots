from jakarta.inject import Singleton
from java.util import Optional
from micronaut.chatbots.core import SpaceParser
from micronaut.chatbots.telegram.api import Chat, Update
from micronaut.chatbots.telegram.api.send import SendMessage
from micronaut.chatbots.telegram.core import SendMessageUtils, TelegramBotConfiguration, TelegramHandler
from micronaut.context.annotation import Executable, Requires
from micronaut.core.order import Ordered


@Requires(property="spec.name", value="telegram")
# tag::class[]
@Singleton
class UnknownCommandHandler(TelegramHandler[SendMessage]):

    def __init__(self, space_parser: SpaceParser[Update, Chat]):
        self.space_parser = space_parser

    def canHandle(self, bot: TelegramBotConfiguration | None, input: Update) -> bool:
        return True  # <1>

    def handle(self, bot: TelegramBotConfiguration | None, input: Update) -> Optional[SendMessage]:
        return SendMessageUtils.compose(self.space_parser, input, f"I don't know how to handle your query: {input.getMessage().getText()}")

    @Executable  # overrides the default getOrder() method of the Handler interface
    def getOrder(self) -> int:
        return Ordered.LOWEST_PRECEDENCE  # <2>
# end::class[]
