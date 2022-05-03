plugins {
    id("io.micronaut.build.internal.module")
}
dependencies {
    annotationProcessor(libs.micronaut.serde.processor)
    api(libs.micronaut.serde.api)
    api(libs.micronaut.http.client)
    implementation(libs.micronaut.validation)
}

configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute(module("io.micronaut:micronaut-jackson-databind"))
            .using(module("io.micronaut.serde:micronaut-serde-jackson:1.0.0"))
    }
}

