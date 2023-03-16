plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    api(projects.micronautChatbotsCore)
    api(projects.micronautChatbotsTelegramApi)

    testImplementation(mnSerde.micronaut.serde.api)
}

