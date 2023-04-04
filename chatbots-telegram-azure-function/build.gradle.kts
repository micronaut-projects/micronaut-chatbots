plugins {
    id("io.micronaut.build.internal.chatbots-azure-functions")
}
dependencies {
    implementation(mnSerde.micronaut.serde.jackson)
    api(projects.micronautChatbotsTelegramCore)
    testRuntimeOnly(mn.snakeyaml)
}
