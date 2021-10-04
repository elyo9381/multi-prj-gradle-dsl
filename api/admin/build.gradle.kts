
dependencies {

    implementation(project(":core-core"))


    implementation ("org.springframework.boot:spring-boot-starter-cache")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.3")
    implementation("mysql:mysql-connector-java:8.0.22")




    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.mockk:mockk:1.9.3")

}


springBoot.buildInfo { properties { } }

configurations {
    val archivesBaseName = "movv-admin"
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    layered()
}

tasks.register("prepareKotlinBuildScriptModel") {}
