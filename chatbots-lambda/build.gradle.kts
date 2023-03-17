plugins {
    id("io.micronaut.build.internal.chatbots-module")
}

dependencies {
    annotationProcessor(mnValidation.micronaut.validation.processor)
    implementation(mnValidation.micronaut.validation)

    api(project(":micronaut-chatbots-core"))
    api(mnSerde.micronaut.serde.api)
    api(mnAws.micronaut.function.aws)
    api(mnAws.aws.lambda.events)
}

micronautBuild {
    binaryCompatibility {
        enabled.set(false)
    }
}

