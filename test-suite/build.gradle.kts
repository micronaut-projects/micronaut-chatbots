plugins {
    id("io.micronaut.build.internal.chatbots-testsuite")

}

dependencies {
    testAnnotationProcessor(mn.micronaut.inject.java)
    testImplementation(mnTest.micronaut.test.junit5)
}
