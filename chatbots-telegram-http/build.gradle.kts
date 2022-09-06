plugins {
    id("io.micronaut.build.internal.chatbots-http")
}

dependencies {
    api(project(":chatbots-http"))
    api(project(":chatbots-telegram-core"))
}
