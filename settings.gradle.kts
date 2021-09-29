rootProject.name = "multi-module-prj"
pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

val GRADLE_TEXT = """

    dependencies {

    }

    """
listOf("core", "api").forEach { moduleName ->

    val compDir = File(rootDir, moduleName)
    if(!compDir.exists()){
        compDir.mkdirs()
    }

    compDir.listFiles().forEach { subDir ->

        val buildFile = File(subDir.absolutePath, "build.gradle.kts")
        if (!buildFile.exists()) {
            buildFile.writeText(GRADLE_TEXT)
        }


        listOf( "src/main/kotlin/com/movv/",
            "src/main/resources",
            "src/test/kotlin/com/movv/",
            "src/test/resources")
            .forEach {srcDir->
                val srcFolder = File(subDir.absolutePath, srcDir)
                if(!srcFolder.exists()){
                    srcFolder.mkdirs()
                }
            }

        val projectName = ":${moduleName}-${subDir.name}"
        include(projectName)
        project(projectName).projectDir = subDir

    }

}