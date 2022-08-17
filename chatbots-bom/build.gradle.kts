plugins {
    id("io.micronaut.build.internal.bom")
}
micronautBuild {
    // new module, so no binary check
    binaryCompatibility {
        enabled.set(false)
    }
}
tasks.named("checkVersionCatalogCompatibility").configure { enabled = false }
