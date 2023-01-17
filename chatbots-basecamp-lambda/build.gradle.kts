plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    implementation(mnSerde.micronaut.serde.jackson)
    implementation(projects.chatbotsLambda)
    api(projects.chatbotsBasecampCore)
}

configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute(module("io.micronaut:micronaut-jackson-databind"))
            .using(module("io.micronaut.serde:micronaut-serde-jackson:${libs.versions.micronaut.serde}"))
    }
}

