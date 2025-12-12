plugins {
    id("io.micronaut.build.internal.chatbots-testsuite")
    id("groovy")
}

dependencies {
    testCompileOnly(mn.micronaut.inject.groovy)
    testImplementation(mnTest.micronaut.test.spock)
}
