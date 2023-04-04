plugins {
    id("io.micronaut.build.internal.chatbots-google-cloud-function")
}

dependencies {
    api(project(":micronaut-chatbots-telegram-core"))
    testRuntimeOnly(mn.snakeyaml)
    testImplementation(libs.jsonassert)
}
