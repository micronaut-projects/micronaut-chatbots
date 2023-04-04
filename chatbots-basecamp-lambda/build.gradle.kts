plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    annotationProcessor(mnSerde.micronaut.serde.processor)
    implementation(mnSerde.micronaut.serde.jackson)
    implementation(projects.micronautChatbotsLambda)
    api(projects.micronautChatbotsBasecampCore)
}

