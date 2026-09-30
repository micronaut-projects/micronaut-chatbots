from typing import Annotated

from jakarta.inject import Inject
from micronaut.chatbots.basecamp.api import Query
from micronaut.chatbots.basecamp.core import BasecampBotConfiguration
from micronaut.chatbots.core import Dispatcher
from micronaut.context import BeanContext
from micronaut.context.annotation import Property
from micronaut.core.io import ResourceResolver
from micronaut.json import JsonMapper
from micronaut.test.extensions.junit5.annotation import MicronautTest
from org.junit.jupiter.api import Test

from .HelloWorldHandler import HelloWorldHandler


@MicronautTest(startApplication=False)
@Property(name="spec.name", value="basecamp")
class HelloWorldHandlerTest:
    ctx: Annotated[BeanContext, Inject]
    dispatcher: Annotated[Dispatcher[BasecampBotConfiguration, Query, str], Inject]
    json_mapper: Annotated[JsonMapper, Inject]
    resource_resolver: Annotated[ResourceResolver, Inject]

    @Test
    def test_bean_of_type_hello_world_handler_exists(self):
        assert self.ctx.containsBean(HelloWorldHandler)

    @Test
    def test_about_command_handler_exists(self):
        assert self.dispatch("basecampAbout.json").strip() == "Bot developed with 💙 using [Micronaut](https://micronaut.io)"

    @Test
    def test_hello_command_handler_exists(self):
        assert self.dispatch("basecampHello.json") == "Hello World"

    @Test
    def test_unknown_command_handler_exists(self):
        assert self.dispatch("basecampText.json") == "I don't know how to handle your query: some text"

    def dispatch(self, resource: str) -> str:
        stream = self.resource_resolver.getResourceAsStream("classpath:" + resource).get()
        return self.dispatcher.dispatch(None, self.json_mapper.readValue(stream, Query)).get()
