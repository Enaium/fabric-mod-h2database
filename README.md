# Fabric Database H2

[![Version](https://img.shields.io/github/v/tag/Enaium/fabric-mod-h2database?label=version&style=flat-square&logo=github)](https://github.com/Enaium/fabric-mod-h2database/releases)
[![CurseForge Downloads](https://img.shields.io/curseforge/dt/1278174?style=flat-square&logo=curseforge)](https://www.curseforge.com/minecraft/mc-mods/fabric-database-h2)
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/AWt0yK0m?style=flat-square&logo=modrinth)](https://modrinth.com/mod/fabric-database-h2)

This is a mod that enables the use of the H2 database for Fabric mods.

Note: This does not add content! This is a dependency that other mods use for compatibility.

This mod works independently of the Minecraft version used, as it only requires Fabric Loader to be available.

## Installation Guide

### For Development (Mod Developers)

To use Fabric Database H2 as a dependency in your Fabric mod:

1. Add the following to your `build.gradle` or `build.gradle.kts`:

   **Groovy (build.gradle):**
   ```groovy
   repositories {
       mavenCentral()
   }
   dependencies {
       modImplementation 'cn.enaium:fabric-database-h2:<version>'
   }
   ```
   **Kotlin DSL (build.gradle.kts):**
   ```kotlin
   repositories {
       mavenCentral()
   }
   dependencies {
       modImplementation("cn.enaium:fabric-database-h2:<version>")
   }
   ```
   Replace `<version>` with the latest version from the [releases page](https://github.com/Enaium/fabric-mod-h2database/releases).

2. Refresh your dependencies and import as usual.

### For Players

1. Download the latest release from one of the following:
   - [CurseForge](https://www.curseforge.com/minecraft/mc-mods/fabric-database-h2)
   - [Modrinth](https://modrinth.com/mod/fabric-database-h2)
   - [GitHub Releases](https://github.com/Enaium/fabric-mod-h2database/releases)

2. Place the downloaded `.jar` file into your Minecraft `mods` folder.

3. Make sure you have [Fabric Loader](https://fabricmc.net/use/) installed.

4. Launch Minecraft as usual.