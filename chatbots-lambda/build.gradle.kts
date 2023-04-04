plugins {
    id("io.micronaut.build.internal.chatbots-module")
}
dependencies {
    api(projects.micronautChatbotsCore)
    api(mnAws.micronaut.function.aws)
    api(mnAws.aws.lambda.events)

    annotationProcessor(mnSerde.micronaut.serde.processor)
    implementation(mnSerde.micronaut.serde.jackson)
}

micronautBuild {
    binaryCompatibility {
        enabled.set(false)
    }
}

