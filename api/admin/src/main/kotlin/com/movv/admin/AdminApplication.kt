package com.movv.admin

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.movv.core"])
class AdminApplication


fun main(args: Array<String>) {

    runApplication<AdminApplication>(*args){
        setBannerMode(Banner.Mode.OFF)
    }
}
