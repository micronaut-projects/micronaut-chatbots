plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    api(project(":chatbots-core"))
    api(project(":chatbots-telegram-api"))
}
