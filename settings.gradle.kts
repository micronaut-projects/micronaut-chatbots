pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("io.micronaut.build.shared.settings") version "6.2.0"
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "chatbots-parent"

include("chatbots-google-api")
include("chatbots-basecamp-api")
include("chatbots-basecamp-core")
include("chatbots-basecamp-lambda")
include("chatbots-basecamp-http")
include("chatbots-basecamp-azure-functions")
include("chatbots-telegram-http")
include("chatbots-telegram-api")
include("chatbots-telegram-core")
include("chatbots-telegram-lambda")
include("chatbots-telegram-azure-functions")
include("chatbots-telegram-google-cloud-http-function")
include("chatbots-http")
include("chatbots-lambda")
include("chatbots-core")
include("chatbots-bom")

configure<io.micronaut.build.MicronautBuildSettingsExtension> {
    addSnapshotRepository()
    importMicronautCatalog()
    importMicronautCatalog("micronaut-aws")
    importMicronautCatalog("micronaut-azure")
    importMicronautCatalog("micronaut-gcp")
    importMicronautCatalog("micronaut-serde")
}
