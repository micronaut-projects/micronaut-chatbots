plugins {
    id("groovy-gradle-plugin")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven { setUrl("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
}
