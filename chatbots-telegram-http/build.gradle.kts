plugins {
    id("io.micronaut.build.internal.chatbots-http")
}

dependencies {
    api(projects.chatbotsHttp)
    api(projects.chatbotsTelegramCore)
}
