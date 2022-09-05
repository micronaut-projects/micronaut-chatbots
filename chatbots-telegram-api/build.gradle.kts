plugins {
    id("io.micronaut.build.internal.chatbots-module")
}

dependencies {
    annotationProcessor(mn.micronaut.serde.processor)
    api(mn.micronaut.serde.api)
    api(libs.jackson.annotations)
    implementation(mn.micronaut.validation)
}

configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute(module("io.micronaut:micronaut-jackson-databind"))
                .using(module("io.micronaut.serde:micronaut-serde-jackson:1.3.0"))
    }
}
