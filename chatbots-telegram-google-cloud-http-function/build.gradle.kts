plugins {
    id("io.micronaut.build.internal.chatbots-google-cloud-function")
}

dependencies {
    api(project(":chatbots-telegram-core"))
}
