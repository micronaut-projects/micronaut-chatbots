plugins {
    id("io.micronaut.build.internal.chatbots-module")
}

dependencies {
    api(projects.chatbotsCore)
    api(mnSerde.micronaut.serde.api)
    api(mnAws.micronaut.function.aws)
    api(mnAws.aws.lambda.events)
    implementation(mn.micronaut.validation)
}

micronautBuild {
    binaryCompatibility {
        enabled.set(false)
    }
}

