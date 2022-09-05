plugins {
    id("io.micronaut.build.internal.docs")
    id("io.micronaut.build.internal.dependency-updates")
    id("io.micronaut.build.internal.quality-reporting")
}

if (System.getenv("SONAR_TOKEN") != null) {
    sonarqube {
        properties {
            property "sonar.exclusions", "**/example/**"
        }
    }
}
