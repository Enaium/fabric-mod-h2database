import me.modmuss50.mpp.PublishModTask
import org.gradle.kotlin.dsl.withType

plugins {
    alias(libs.plugins.loom)
    alias(libs.plugins.publish)
    alias(libs.plugins.maven)
}

group = "cn.enaium"
version = "1.0.1+h2.${libs.versions.h2.get()}"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val includeAndExpose: Configuration by configurations.creating

configurations {
    include {
        extendsFrom(includeAndExpose)
    }
}

dependencies {
    minecraft(libs.minecraft)
    implementation(libs.fabric.loader)
    includeAndExpose(libs.h2)
}

tasks.processResources {
    inputs.property("version", version)
    filesMatching("fabric.mod.json") {
        expand("version" to version)
    }
}

publishMods {
    file = tasks.jar.get().archiveFile.get()
    type = STABLE
    displayName = "Fabric Database H2 ${project.version}"
    changelog = ""
    modLoaders.add("fabric")

    curseforge {
        projectId = "1278174"
        accessToken = providers.gradleProperty("curseforge.token")
        minecraftVersionRange {
            start = "1.14"
            end = "latest"
        }
    }

    modrinth {
        projectId = "AWt0yK0m"
        accessToken = providers.gradleProperty("modrinth.token")
        minecraftVersionRange {
            start = "1.14"
            end = "latest"
        }
    }

    github {
        repository = "Enaium/fabric-mod-h2database"
        accessToken = providers.gradleProperty("github.token")
        commitish = "master"
    }
}

tasks.withType<PublishModTask>().configureEach {
    dependsOn(tasks.named("jar"))
}

mavenPublishing {

    publishToMavenCentral(automaticRelease = true)

    signAllPublications()

    coordinates(
        groupId = project.group.toString(),
        artifactId = project.name,
        version = project.version.toString()
    )

    pom {
        name = "Fabric H2 Database"
        description = "Minecraft Database Library"
        url = "https://github.com/Enaium/fabric-mod-h2database"
        licenses {
            license {
                name = "Mozilla Public License Version 2.0"
                url = "https://www.mozilla.org/en-US/MPL/2.0/"
            }
        }
        developers {
            developer {
                name = "Enaium"
                url = "https://github.com/Enaium"
            }
        }
        scm {
            connection.set("scm:git:git://github.com/Enaium/fabric-mod-h2database.git")
            developerConnection.set("scm:git:ssh://github.com/Enaium/fabric-mod-h2database.git")
            url.set("https://github.com/Enaium/fabric-mod-h2database")
        }
    }
}