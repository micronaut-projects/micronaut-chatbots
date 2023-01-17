plugins {
    id("io.micronaut.build.internal.chatbots-module")
}

dependencies {
    implementation(mnSerde.micronaut.serde.api)
    api(projects.chatbotsLambda)
    api(projects.chatbotsTelegramCore)
}

