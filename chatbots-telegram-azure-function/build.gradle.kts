plugins {
    id("io.micronaut.build.internal.chatbots-azure-functions")
}
dependencies {
    implementation(mnSerde.micronaut.serde.jackson)
    api(project(":micronaut-chatbots-telegram-core"))
}

