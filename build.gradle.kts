plugins {
    alias(libs.plugins.loom)
}

group = "cn.enaium"
version = "1.0.0+h2.${libs.versions.h2.get()}"

repositories {
    mavenCentral()
}

dependencies {
    minecraft(libs.minecraft)
    mappings(libs.fabric.yarn) {
        artifact {
            classifier = "v2"
        }
    }
    modImplementation(libs.fabric.loader)
    include(libs.h2)
}

tasks.processResources {
    inputs.property("version", version)
    filesMatching("fabric.mod.json") {
        expand("version" to version)
    }
}