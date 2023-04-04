plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    api(projects.micronautChatbotsCore)
    api(projects.micronautChatbotsTelegramApi)
    testAnnotationProcessor(mnSerde.micronaut.serde.processor)
    testImplementation(mnSerde.micronaut.serde.jackson)
}

