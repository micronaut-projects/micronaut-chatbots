plugins {
    id("io.micronaut.build.internal.kotlin-base")
    id("io.micronaut.build.internal.kotlin-kapt")
}

repositories {
    mavenCentral()
}

dependencies {
    kaptTest(mn.micronaut.inject.java)
    testRuntimeOnly(mnLogging.logback.classic)
    testRuntimeOnly(libs.junit.engine)
    testRuntimeOnly(mnTest.junit.platform.launcher)
    testAnnotationProcessor(mn.micronaut.inject.java)
    testImplementation(mnTest.micronaut.test.junit5)
    testAnnotationProcessor(mnValidation.micronaut.validation.processor)
    testImplementation(mnValidation.micronaut.validation)
    testAnnotationProcessor(mnSerde.micronaut.serde.processor)
    testImplementation(mnSerde.micronaut.serde.jackson)
    testImplementation(projects.micronautChatbotsBasecampCore)
    testImplementation(projects.micronautChatbotsTelegramCore)
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

