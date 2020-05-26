package com.caner.issuemanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

public class MyAppConfig {


    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/issuemanagment");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        return dataSource;
    }
/*	@Bean
	@DependsOn("liquibase")
	public SpringLiquibase liquibaserelease(DataSource dataSource) {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setDataSource(dataSource);
		liquibase.setChangeLog("classpath:changelog-v1.0.xml");
		return liquibase;
	}*/

    @Bean
    @DependsOn("liquibase")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean liquibase = new LocalContainerEntityManagerFactoryBean();
       /* liquibase.setDataSource(dataSource());
        liquibase.setPackagesToScan("src/main/java/com/caner/issuemanagement/entity/Issue.java");
        liquibase.setPersistenceUnitName("Issue");*/
        return liquibase;
    }
}
