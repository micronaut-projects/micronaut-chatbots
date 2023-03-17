plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    implementation(mnSerde.micronaut.serde.api)
    implementation(project(":micronaut-chatbots-lambda"))
    api(project(":micronaut-chatbots-basecamp-core"))
}

