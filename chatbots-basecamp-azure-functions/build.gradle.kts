plugins {
    id("io.micronaut.build.internal.chatbots-azure-functions")
}
dependencies {
    implementation(mnSerde.micronaut.serde.api)
    api(projects.micronautChatbotsBasecampCore)

    testRuntimeOnly(mn.snakeyaml)
}
