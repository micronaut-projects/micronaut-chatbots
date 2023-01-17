plugins {
    id("io.micronaut.build.internal.chatbots-module")
}

dependencies {
    api(projects.chatbotsCore)
    api(mnAws.micronaut.function.aws)
    api(mnAws.aws.lambda.events)
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
            .using(module("io.micronaut.serde:micronaut-serde-jackson:${libs.versions.micronaut.serde}"))
    }
}

