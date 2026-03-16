plugins {
    id("groovy")
}
repositories {
    mavenCentral()
}
dependencies {
    testRuntimeOnly(mnLogging.logback.classic)
    testRuntimeOnly(libs.junit.engine)
    testRuntimeOnly(mnTest.junit.platform.launcher)
    testCompileOnly(mn.micronaut.inject.groovy)
    testAnnotationProcessor(mnValidation.micronaut.validation.processor)
    testImplementation(mnValidation.micronaut.validation)
    testImplementation(mnTest.micronaut.test.spock)
    testAnnotationProcessor(mnSerde.micronaut.serde.processor)
    testImplementation(mnSerde.micronaut.serde.jackson)
    testImplementation(projects.micronautChatbotsBasecampCore)
    testImplementation(projects.micronautChatbotsTelegramCore)
}
tasks.withType<Test> {
    useJUnitPlatform()
}
