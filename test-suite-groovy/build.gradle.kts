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
java {
    sourceCompatibility = JavaVersion.toVersion("21")
    targetCompatibility = JavaVersion.toVersion("21")
}

//TODO remove once Micronaut Test ships Spock version compatible with Groovy 5
configurations.all {
    resolutionStrategy {
        force("org.spockframework:spock-core:2.4-M7-groovy-5.0")
    }
}
