plugins {
    id("io.micronaut.build.internal.docs")
    id("io.micronaut.build.internal.dependency-updates")
    id("io.micronaut.build.internal.quality-reporting")
}

micronautBuild {
    sourceCompatibility.set("11")
    targetCompatibility.set("11")
}

if (System.getenv("SONAR_TOKEN") != null) {
    configure<org.sonarqube.gradle.SonarQubeExtension> {
        properties {
            // Ignore duplication on the api classes as they are DTOs for Serde serialization
            property("sonar.cpd.exclusions", "**/io/micronaut/chatbots/telegram/api/**")
        }
    }
}
