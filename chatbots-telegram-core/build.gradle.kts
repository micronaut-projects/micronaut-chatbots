plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    api(project(":micronaut-chatbots-core"))
    api(project(":micronaut-chatbots-telegram-api"))
    testImplementation(mnSerde.micronaut.serde.api)
}

