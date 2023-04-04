plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    api(project(":micronaut-chatbots-core"))
    api(project(":micronaut-chatbots-basecamp-api"))
}
