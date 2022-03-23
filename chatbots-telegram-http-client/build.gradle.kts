plugins {
    id("io.micronaut.build.internal.module")
}
dependencies {
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    api("io.micronaut.serde:micronaut-serde-api")
    api("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-validation")
}

configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute(module("io.micronaut:micronaut-jackson-databind"))
            .using(module("io.micronaut.serde:micronaut-serde-jackson:1.0.0"))
    }
}

