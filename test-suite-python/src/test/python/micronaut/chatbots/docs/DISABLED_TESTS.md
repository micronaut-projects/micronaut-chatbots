# Python Docs Disabled Test Inventory

This file tracks Python docs examples of Micronaut Chatbots that are present but disabled, or that deviate from the
Java example because the direct port currently fails compilation or at runtime (Python compiler gaps). Use it as the
bug-fixing task list for the final migration wave.

## Reconciliation

- Last generated active `@Disabled` count: 0.
- Last generated command: `rg -n "@Disabled\(" test-suite-python/src/test/python`.
- Last full-suite command: `./gradlew :test-suite-python:test -Ppython-ci`.
- Last full-suite result: build successful, 8 tests executed (2 test classes), 0 skipped.

## Migration Rules

- Methods that implement or override a Java interface keep the Java (camelCase) name (`canHandle`, `handle`,
  `getOrder`); other methods and constructor parameters are snake_case.
- A Python class cannot extend a Java class. `io.micronaut.chatbots.docs.telegram.AboutCommandHandler` extends the
  abstract `io.micronaut.chatbots.telegram.core.CommandHandler` in Java, Kotlin and Groovy; the Python handler
  implements `TelegramHandler[SendMessage]` directly and composes the same collaborators (`TelegramSlashCommandParser`,
  `TextResourceLoader`, `SpaceParser[Update, Chat]`) with the same behaviour (order `-10`, parse mode derived from the
  file extension of the command response). The guide carries a `[.lang-python]` note.
- A method overriding a *default* method of a Java interface (`Ordered.getOrder()` inherited by `Handler`) is not
  bridged to the generated Java class unless it is annotated with `@Executable`
  (`from micronaut.context.annotation import Executable`); without it the handler keeps the default order and the
  `UnknownCommandHandler` is no longer guaranteed to be last.
- Python source files must not live in a package whose `__init__.py` the Python compiler also generates for an imported
  Java package: `micronaut/chatbots/telegram/*.py` collides with the shim of `io.micronaut.chatbots.telegram.api`
  (`Failed to write Python code to [.../micronaut/chatbots/telegram/__init__.py]: Output stream or writer has already
  been opened`). The snippet classes were therefore moved to `io.micronaut.chatbots.docs.telegram` /
  `io.micronaut.chatbots.docs.basecamp` in every language.
- No `java.type(...)` aliases are needed: the generated Python imports work as runtime type arguments here
  (`BeanContext.containsBean(HelloWorldHandler)`, `JsonMapper.readValue(stream, Update)`, `java.instanceof(send, SendMessage)`).
  The tests load the JSON test resources with the injected `micronaut.core.io.ResourceResolver`
  (`getResourceAsStream("classpath:about.json")`) instead of `getClass().getResourceAsStream(...)`, which has no Python equivalent.

## Active `@Disabled` Tests

None.

## Commented Unsupported Snippet Ports

None.

## Intentionally Unsupported Snippet Targets

None.
