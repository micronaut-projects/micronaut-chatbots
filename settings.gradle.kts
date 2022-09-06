pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("io.micronaut.build.shared.settings") version "5.3.14"
}

rootProject.name = "chatbots-parent"
include("chatbots-google-api")
include("chatbots-basecamp-api")
include("chatbots-basecamp-core")
include("chatbots-basecamp-lambda")
include("chatbots-telegram-api")
include("chatbots-telegram-core")
include("chatbots-telegram-lambda")
include("chatbots-lambda")
include("chatbots-core")
include("chatbots-bom")

configure<io.micronaut.build.MicronautBuildSettingsExtension> {
    importMicronautCatalog()
}
