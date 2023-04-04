plugins {
    id("io.micronaut.build.internal.chatbots-google-cloud-function")
}

dependencies {
    api(projects.micronautChatbotsTelegramCore)
    testRuntimeOnly(mn.snakeyaml)
    testImplementation(libs.jsonassert)
}
