
val api : Project = parent!!.project(":SpongeCommon:SpongeAPI")
extra["api"] = api
val common : Project = parent!!.project("SpongeCommon")
extra["common"] = common

apply(from = api.file("gradle/sponge.gradle.kts"))

val compileOnly by configurations

plugins {
    java
}

dependencies {
    compileOnly(api)
    if (parent is JavaPluginConvention) {
        var javaPlugin = parent as JavaPluginConvention
        compileOnly(javaPlugin.sourceSets["main"].compileClasspath)
    }

}
