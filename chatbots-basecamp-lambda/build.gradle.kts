plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    annotationProcessor(mnSerde.micronaut.serde.processor)
    implementation(mnSerde.micronaut.serde.jackson)
    implementation(project(":micronaut-chatbots-lambda"))
    api(project(":micronaut-chatbots-basecamp-core"))
}

