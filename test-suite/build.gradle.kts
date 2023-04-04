plugins {
    id("java-library")
}
repositories {
    mavenCentral()
}

dependencies {
    testRuntimeOnly(mn.logback.classic)
    testRuntimeOnly(libs.junit.engine)
    testAnnotationProcessor(mn.micronaut.inject.java)
    testImplementation(mnTest.micronaut.test.junit5)
    testAnnotationProcessor(mnValidation.micronaut.validation.processor)
    testImplementation(mnValidation.micronaut.validation)
    testAnnotationProcessor(mnSerde.micronaut.serde.processor)
    testImplementation(mnSerde.micronaut.serde.jackson)
    testImplementation(projects.micronautChatbotsBasecampCore)
    testImplementation(projects.micronautChatbotsTelegramCore)
}
tasks.withType<Test> {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}
