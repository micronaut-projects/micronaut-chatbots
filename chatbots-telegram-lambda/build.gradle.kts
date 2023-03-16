plugins {
    id("io.micronaut.build.internal.chatbots-module")
}

dependencies {
    implementation(mnSerde.micronaut.serde.api)
    api(projects.micronautChatbotsLambda)
    api(projects.micronautChatbotsTelegramCore)
}

