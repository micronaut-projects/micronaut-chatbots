plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    api(projects.micronautChatbotsCore)
    api(projects.micronautChatbotsBasecampApi)
}
