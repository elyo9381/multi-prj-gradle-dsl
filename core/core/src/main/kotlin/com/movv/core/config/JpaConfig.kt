package com.movv.core.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.*
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jmx.export.MBeanExporter
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.support.TransactionTemplate
import javax.sql.DataSource

@Configuration
@ComponentScan(basePackages = [
    "com.movv.core.repository"
])
@EnableJpaRepositories(
    basePackages = ["com.movv.core"]
)
@EntityScan("com.movv.core")
@PropertySource("classpath:application-core.\${spring.profiles.active}.properties")
class JpaConfig() {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "movv.jpa")
    fun movvjpaProperties() = JpaProperties()


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "movv.datasource")
    fun movvHikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    @Primary
    fun movvHibernateSettings(): HibernateSettings {
        return HibernateSettings()
    }

    @Bean
    @Primary
    fun movvdataSource(): DataSource {
        val source = HikariDataSource(movvHikariConfig())
        return source
    }

}