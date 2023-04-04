plugins {
    id("io.micronaut.build.internal.chatbots-azure-functions")
}
dependencies {
    annotationProcessor(mnSerde.micronaut.serde.processor)
    implementation(mnSerde.micronaut.serde.jackson)
    api(projects.micronautChatbotsBasecampCore)
    testRuntimeOnly(mn.snakeyaml)
}
