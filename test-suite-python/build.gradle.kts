plugins {
    id("java-library")
    id("io.micronaut.build.internal.java-base")
    id("io.micronaut.build.internal.python")
}
repositories {
    mavenCentral()
}

dependencies {
    testRuntimeOnly(mnLogging.logback.classic)
    testRuntimeOnly(libs.junit.engine)
    testRuntimeOnly(mnTest.junit.platform.launcher)
    // The Python compiler (micronaut-inject-python) takes the (jar-resolved) compile classpath as its
    // annotation processor path, so the processors are testImplementation (not testAnnotationProcessor).
    testImplementation(mn.micronaut.inject.python.test)
    testImplementation(mn.micronaut.context.python)
    testImplementation(mnTest.micronaut.test.junit5)
    testImplementation(mnValidation.micronaut.validation.processor)
    testImplementation(mnValidation.micronaut.validation)
    testImplementation(mnSerde.micronaut.serde.processor)
    testImplementation(mnSerde.micronaut.serde.jackson)
    testImplementation(projects.micronautChatbotsBasecampCore)
    testImplementation(projects.micronautChatbotsTelegramCore)
}
tasks.withType<Test> {
    useJUnitPlatform()
    systemProperty("micronaut.python.pool.enabled", "false")
}
