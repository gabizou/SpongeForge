
val common : Project by extra { parent!!.project(":SpongeCommon") }

val api : Project by extra { common.project("SpongeAPI") }
evaluationDependsOn(common.path)
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
