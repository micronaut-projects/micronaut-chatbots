plugins {
    id("io.micronaut.build.internal.chatbots-module")
}

dependencies {
    implementation(mnSerde.micronaut.serde.api)
    api(project(":micronaut-chatbots-lambda"))
    api(project(":micronaut-chatbots-telegram-core"))
}

