plugins {
    id("io.micronaut.build.internal.module")
}
dependencies {
    api(projects.micronautChatbotsCore)
    api(mnAws.micronaut.function.aws)
    api(mnAws.aws.lambda.events)

    annotationProcessor(mnSerde.micronaut.serde.processor)
    implementation(mnSerde.micronaut.serde.jackson)

    annotationProcessor(mnValidation.micronaut.validation.processor)
    implementation(mnValidation.micronaut.validation)
}

micronautBuild {
    binaryCompatibility {
        enabled.set(false)
    }
}

