plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    implementation(mn.micronaut.serde.jackson)
    api(project(":chatbots-lambda"))
    api(project(":chatbots-telegram-core"))
}


configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute(module("io.micronaut:micronaut-jackson-databind"))
            .using(module("io.micronaut.serde:micronaut-serde-jackson:${mn.versions.micronaut.serialization.get()}"))
    }
}

