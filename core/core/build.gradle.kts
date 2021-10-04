
dependencies {

    api(kotlin("reflect"))
    api(kotlin("stdlib-jdk8"))

    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.3")
    api("org.springframework.boot:spring-boot-starter-web")



    implementation("org.mapstruct:mapstruct:1.4.1.Final")
    kapt("org.mapstruct:mapstruct-processor:1.4.1.Final")


    api("com.fasterxml.jackson.core:jackson-databind:2.12.5")

    api("io.reactivex.rxjava2:rxkotlin:2.4.0")

    api("com.google.code.gson:gson:2.8.5")
    runtimeOnly("mysql:mysql-connector-java")
    runtimeOnly ("com.h2database:h2")


    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.mockk:mockk:1.9.3")

}

tasks.register("prepareKotlinBuildScriptModel") {}