plugins {
    id("io.micronaut.build.internal.chatbots-http")
}

dependencies {
    api(projects.micronautChatbotsHttp)
    api(projects.micronautChatbotsTelegramCore)
}
