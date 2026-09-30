from jakarta.inject import Singleton
from java.util import Optional
from micronaut.chatbots.basecamp.api import Query
from micronaut.chatbots.basecamp.core import BasecampBotConfiguration, BasecampHandler
from micronaut.context.annotation import Requires


@Requires(property="spec.name", value="basecamp")
# tag::class[]
@Singleton
class HelloWorldHandler(BasecampHandler):

    def canHandle(self, bot: BasecampBotConfiguration | None, input: Query) -> bool:
        return "hello" in input.getCommand()

    def handle(self, bot: BasecampBotConfiguration | None, input: Query) -> Optional[str]:
        return Optional.of("Hello World")
# end::class[]
