pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

plugins {
    id("io.micronaut.build.shared.settings") version "6.4.4"
}

rootProject.name = "chatbots-parent"
include("chatbots-google-api")
include("chatbots-basecamp-api")
include("chatbots-basecamp-core")
include("chatbots-basecamp-lambda")
include("chatbots-basecamp-http")
include("chatbots-basecamp-gcp-function")
include("chatbots-basecamp-azure-function")
include("chatbots-telegram-http")
include("chatbots-telegram-api")
include("chatbots-telegram-core")
include("chatbots-telegram-lambda")
include("chatbots-telegram-azure-function")
include("chatbots-telegram-gcp-function")
include("chatbots-http")
include("chatbots-lambda")
include("chatbots-core")
include("chatbots-bom")
include("test-suite")
include("test-suite-groovy")
include("test-suite-kotlin")
configure<io.micronaut.build.MicronautBuildSettingsExtension> {
    useStandardizedProjectNames.set(true)
    addSnapshotRepository()
    importMicronautCatalog()
    importMicronautCatalog("micronaut-serde")
    importMicronautCatalog("micronaut-validation")
    importMicronautCatalog("micronaut-azure")
    importMicronautCatalog("micronaut-gcp")
    importMicronautCatalog("micronaut-aws")
}
