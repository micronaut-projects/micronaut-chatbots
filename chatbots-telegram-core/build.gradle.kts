plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    api(projects.chatbotsCore)
    api(projects.chatbotsTelegramApi)

    testImplementation(mnSerde.micronaut.serde.jackson)
}

