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

include("chatbots-telegram-api")
include("chatbots-telegram-core")
include("chatbots-telegram-lambda")
include("chatbots-lambda")
include("chatbots-core")
include("chatbots-bom")

configure<io.micronaut.build.MicronautBuildSettingsExtension> {
    importMicronautCatalog()
}
