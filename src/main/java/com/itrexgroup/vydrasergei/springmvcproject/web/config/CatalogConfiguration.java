package com.itrexgroup.vydrasergei.springmvcproject.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.itrexgroup.vydrasergei.springmvcproject")
@PropertySource("classpath:datasource/db_config.properties")
public class CatalogConfiguration {

    @Autowired
    Environment env;
    private final String DRIVER = "db.driver";
    private final String URL = "db.url";
    private final String USER = "db.user";
    private final String PASSWORD = "db.password";

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(env.getProperty(DRIVER));
        driverManagerDataSource.setUrl(env.getProperty(URL));
        driverManagerDataSource.setUsername(env.getProperty(USER));
        driverManagerDataSource.setPassword(env.getProperty(PASSWORD));
        return driverManagerDataSource;
    }

}
