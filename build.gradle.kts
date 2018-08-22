buildscript {
    repositories {
        mavenCentral()
        jcenter()
        maven("https://plugins.gradle.org/m2")
        maven("https://repo.spongepowered.org/maven")
        maven("http://files.minecraftforge.net/maven")
    }

    dependencies {
        classpath("gradle.plugin.net.minecrell:vanillagradle:2.2-5")
        classpath("net.minecraftforge.gradle:ForgeGradle:2.3-SNAPSHOT")
        classpath("com.github.jengelman.gradle.plugins:shadow:1.2.4")
        // VanillaGradle contains a custom ForgeGradle extension for SpongeCommon (see below)
    }

}

val forgeBuild: String by properties

extra["minecraftVersion"] = Integer.parseInt(forgeBuild)
// test mods declaration
val testmods = project("testmods")
extra["testmods"] = testmods
// common declaration
val common = project(":SpongeCommon")
extra["common"] = common

apply(from = common.file("gradle/implementation.gradle.kts"))

//version = "$minecraft.version-$forgeBuild-$apiSuffix-$buildNumber"


