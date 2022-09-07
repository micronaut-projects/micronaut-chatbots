plugins {
    id("io.micronaut.build.internal.module")
}
dependencies {
    api(project(":chatbots-core"))
    api(mn.micronaut.function.aws)
    api(libs.aws.lambda.java.events)
    implementation(mn.micronaut.validation)
}

micronautBuild {
    binaryCompatibility {
        enabled.set(false)
    }
}

configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute(module("io.micronaut:micronaut-jackson-databind"))
            .using(module("io.micronaut.serde:micronaut-serde-jackson:${mn.versions.micronaut.serialization.get()}"))
    }
}

