import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.5.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.10.RELEASE" apply false

    kotlin("plugin.spring") version "1.3.72" apply false
    kotlin("plugin.jpa") version "1.3.72" apply false
    kotlin("jvm") version "1.3.72"
    kotlin("kapt") version "1.3.72" apply false
}


allprojects {
    group = "com.movv"
    version = "0.0.1-SNAPSHOT"
//    var tag = SimpleDateFormat("MMddHHmm").format(Date())

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}


subprojects {
    repositories {
        mavenCentral()
    }
    apply {
        plugin("kotlin")
        plugin("kotlin-spring")
        plugin("kotlin-kapt")
        plugin("kotlin-jpa")
        plugin("idea")
        plugin("eclipse")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("kotlin-allopen")
    }

}

//
//rootProject.subprojects.forEach { subproject ->
//    "api-".filter { !subproject.name.startsWith(it) }.map { subproject.tasks["bootJar"].enabled = false }
//}
//

