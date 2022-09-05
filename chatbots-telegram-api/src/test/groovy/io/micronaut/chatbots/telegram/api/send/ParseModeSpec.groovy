package io.micronaut.chatbots.telegram.api.send

import spock.lang.Specification

class ParseModeSpec extends Specification {

    void "Parse mode returns correct casing"() {
        expect:
        'HTML' == ParseMode.HTML.toString()
        'Markdown' == ParseMode.MARKDOWN.toString()
    }
}
