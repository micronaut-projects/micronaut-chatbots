plugins {
    id("io.micronaut.build.internal.module")
}
dependencies {
    implementation(libs.micronaut.serde.jackson)
    implementation(libs.micronaut.validation)
    implementation(project(":chatbots-lambda"))
    api(project(":chatbots-telegram-core"))
}

micronautBuild {
    binaryCompatibility {
        enabled.set(false)
    }
}

configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute(module("io.micronaut:micronaut-jackson-databind"))
            .using(module("io.micronaut.serde:micronaut-serde-jackson:1.3.0"))
    }
}

