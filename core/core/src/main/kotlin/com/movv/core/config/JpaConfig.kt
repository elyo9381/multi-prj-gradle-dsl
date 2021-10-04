package com.movv.core.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.*
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.core.JdbcTemplate
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
    basePackages = ["com.movv.core.repository"], // 1. Repository 경로
    entityManagerFactoryRef = "movvEntityManagerFactory",
    transactionManagerRef = "movvTransactionManager"
)
@PropertySource("classpath:application-core.\${spring.profiles.active}.properties")
class JpaConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "movv.jpa")
    fun movvJpaProperties(): JpaProperties {
        return JpaProperties()
    }

    @Bean
    @Primary
    fun movvHibernateSettings(): HibernateSettings {
        return HibernateSettings()
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "movv.datasource")
    fun movvHikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    @Primary
    fun movvDataSource(): DataSource {
        val dataSource = HikariDataSource(movvHikariConfig())
//        mbeanExporter.addExcludedBean("movvDataSource")
        return dataSource
    }

    @Bean
    @Primary
    fun movvEntityManagerFactory(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(movvDataSource())
            .packages("com.movv.core.entity")
            .persistenceUnit("movvPersistenceUnit")
            .properties(getVendorProperties(movvDataSource()))
            .build()
    }

    private fun getVendorProperties(dataSource: DataSource): Map<String, String> {
        var properties = movvJpaProperties().properties
//        properties.put("hibernate.dialec", "org.hibernate.dialect.MySQL5InnoDBDialect")
        return properties
    }

    @Bean(name = ["movvJdbcTemplate"])
    fun movvJdbcTemplate(@Qualifier("movvDataSource") dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    @Primary
    fun movvTransactionManager(builder: EntityManagerFactoryBuilder): PlatformTransactionManager {
        return JpaTransactionManager(movvEntityManagerFactory(builder).getObject()!!)
    }

    @Bean
    @Primary
    fun movvTransactionTemplate(builder: EntityManagerFactoryBuilder): TransactionTemplate {
        return TransactionTemplate(movvTransactionManager(builder))
    }
}