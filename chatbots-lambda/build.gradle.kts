plugins {
    id("io.micronaut.build.internal.module")
}
dependencies {
    implementation(mn.micronaut.validation)
    implementation(project(":chatbots-core"))
    api(mn.micronaut.function.aws)
    api(libs.aws.lambda.java.events)
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

