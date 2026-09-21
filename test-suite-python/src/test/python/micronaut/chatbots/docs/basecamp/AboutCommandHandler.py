from jakarta.inject import Singleton
from java.util import Optional
from micronaut.chatbots.basecamp.api import Query
from micronaut.chatbots.basecamp.core import BasecampBotConfiguration, BasecampHandler
from micronaut.chatbots.core import TextResourceLoader
from micronaut.context.annotation import Requires


@Requires(property="spec.name", value="basecamp")
# tag::class[]
@Singleton
class AboutCommandHandler(BasecampHandler):

    ABOUT: str = "about"

    def __init__(self, text_resource_loader: TextResourceLoader):
        self.text_resource_loader = text_resource_loader

    def canHandle(self, bot: BasecampBotConfiguration | None, input: Query) -> bool:
        return input.getCommand().lower() == "/" + AboutCommandHandler.ABOUT

    def handle(self, bot: BasecampBotConfiguration | None, input: Query) -> Optional[str]:
        return (self.text_resource_loader
                .composeCommandResponse(AboutCommandHandler.ABOUT)
                .map(lambda response: response.text()))
# end::class[]
