plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    implementation(mnSerde.micronaut.serde.api)
    implementation(projects.chatbotsLambda)
    api(projects.chatbotsBasecampCore)
}

