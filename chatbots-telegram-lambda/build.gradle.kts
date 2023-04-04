plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    annotationProcessor(mnSerde.micronaut.serde.processor)
    implementation(mnSerde.micronaut.serde.jackson)
    api(projects.micronautChatbotsLambda)
    api(projects.micronautChatbotsTelegramCore)
    testImplementation(libs.jsonassert)
}
