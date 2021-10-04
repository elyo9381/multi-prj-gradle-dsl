package com.movv.admin

import com.movv.core.config.JpaConfig
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = ["com.movv.core","com.movv.admin"])
//@EnableJpaRepositories(basePackages = ["com.movv.core"])
//@Import(*[JpaConfig::class])
class AdminApplication


fun main(args: Array<String>) {

    runApplication<AdminApplication>(*args){
        setBannerMode(Banner.Mode.OFF)
    }
}
