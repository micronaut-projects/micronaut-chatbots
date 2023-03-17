plugins {
    id("io.micronaut.build.internal.chatbots-http")
}

dependencies {
    api(project(":micronaut-chatbots-http"))
    api(project(":micronaut-chatbots-telegram-core"))
}
