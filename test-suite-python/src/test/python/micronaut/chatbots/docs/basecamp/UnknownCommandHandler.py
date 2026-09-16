from jakarta.inject import Singleton
from java.util import Optional
from micronaut.chatbots.basecamp.api import Query
from micronaut.chatbots.basecamp.core import BasecampBotConfiguration, BasecampHandler
from micronaut.context.annotation import Executable, Requires
from micronaut.core.order import Ordered


@Requires(property="spec.name", value="basecamp")
# tag::class[]
@Singleton
class UnknownCommandHandler(BasecampHandler):

    def canHandle(self, bot: BasecampBotConfiguration | None, input: Query) -> bool:
        return True  # <1>

    def handle(self, bot: BasecampBotConfiguration | None, input: Query) -> Optional[str]:
        return Optional.of(f"I don't know how to handle your query: {input.getCommand()}")

    @Executable  # overrides the default getOrder() method of the Handler interface
    def getOrder(self) -> int:
        return Ordered.LOWEST_PRECEDENCE  # <2>
# end::class[]
