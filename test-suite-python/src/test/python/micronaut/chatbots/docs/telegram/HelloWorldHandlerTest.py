from typing import Annotated

from jakarta.inject import Inject
from micronaut.chatbots.core import Dispatcher
from micronaut.chatbots.telegram.api import Update
from micronaut.chatbots.telegram.api.send import Send, SendMessage
from micronaut.chatbots.telegram.core import TelegramBotConfiguration
from micronaut.context import BeanContext
from micronaut.context.annotation import Property
from micronaut.core.io import ResourceResolver
from micronaut.json import JsonMapper
from micronaut.test.extensions.junit5.annotation import MicronautTest
from org.junit.jupiter.api import Test

from .HelloWorldHandler import HelloWorldHandler


@MicronautTest(startApplication=False)
@Property(name="spec.name", value="telegram")
class HelloWorldHandlerTest:
    ctx: Annotated[BeanContext, Inject]
    dispatcher: Annotated[Dispatcher[TelegramBotConfiguration, Update, Send], Inject]
    json_mapper: Annotated[JsonMapper, Inject]
    resource_resolver: Annotated[ResourceResolver, Inject]

    @Test
    def test_bean_of_type_hello_world_handler_exists(self):
        assert self.ctx.containsBean(HelloWorldHandler)

    @Test
    def test_about_command_handler_exists(self):
        send = self.dispatch("about.json")
        assert isinstance(send, SendMessage)
        assert send.getText().strip() == "Bot developed with 💙 using [Micronaut](https://micronaut.io)"

    @Test
    def test_hello_command_handler_exists(self):
        send = self.dispatch("hello.json")
        assert isinstance(send, SendMessage)
        assert send.getText() == "Hello World"

    @Test
    def test_unknown_command_handler_exists(self):
        send = self.dispatch("text.json")
        assert isinstance(send, SendMessage)
        assert send.getText() == "I don't know how to handle your query: some text"

    def dispatch(self, resource: str) -> Send:
        stream = self.resource_resolver.getResourceAsStream("classpath:" + resource).get()
        return self.dispatcher.dispatch(None, self.json_mapper.readValue(stream, Update)).get()
