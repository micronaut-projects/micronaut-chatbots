plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.kapt)
}

repositories {
    mavenCentral()
}

dependencies {
    kaptTest(mn.micronaut.inject.java)
    testRuntimeOnly(mnLogging.logback.classic)
    testRuntimeOnly(libs.junit.engine)
    testAnnotationProcessor(mn.micronaut.inject.java)
    testImplementation(mnTest.micronaut.test.junit5)
    testAnnotationProcessor(mnValidation.micronaut.validation.processor)
    testImplementation(mnValidation.micronaut.validation)
    testAnnotationProcessor(mnSerde.micronaut.serde.processor)
    testImplementation(mnSerde.micronaut.serde.jackson)
    testImplementation(projects.micronautChatbotsBasecampCore)
    testImplementation(projects.micronautChatbotsTelegramCore)

    testImplementation(libs.kotlin.stdlib.jdk8)
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
