package com.itrexgroup.vydrasergei.springmvcproject.web.config;

import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Objects;
import java.util.Properties;

import static org.hibernate.cfg.Environment.*;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.itrexgroup.vydrasergei.springmvcproject")
@PropertySource("classpath:db_config.properties")
public class AppConfig {

    @Autowired
    Environment env;

    private final String MYSQL_DRIVER = "db.driver";
    private final String MYSQL_URL = "db.url";
    private final String MYSQL_USER = "db.user";
    private final String MYSQL_PASSWORD = "db.password";

    private final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private final String HIBERNATE_DIALECT = "hibernate.dialect";

    private final String HIBERNATE_C3P0_MIN_SIZE = "hibernate.c3p0.min_size";
    private final String HIBERNATE_C3P0_MAX_SIZE = "hibernate.c3p0.max_size";
    private final String HIBERNATE_C3P0_ACQUIRE_INC = "hibernate.c3p0.acquire_increment";
    private final String HIBERNATE_C3P0_TIMEOUT = "hibernate.c3p0.timeout";
    private final String HIBERNATE_MAX_STATEMENTS = "hibernate.c3p0.max_statements";


    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties props = new Properties();

        props.put(DRIVER, Objects.requireNonNull(env.getProperty(MYSQL_DRIVER)));
        props.put(URL, Objects.requireNonNull(env.getProperty(MYSQL_URL)));
        props.put(USER, Objects.requireNonNull(env.getProperty(MYSQL_USER)));
        props.put(PASS, Objects.requireNonNull(env.getProperty(MYSQL_PASSWORD)));

        props.put(SHOW_SQL, Objects.requireNonNull(env.getProperty(HIBERNATE_SHOW_SQL)));
        props.put(HBM2DDL_AUTO, Objects.requireNonNull(env.getProperty(HIBERNATE_HBM2DDL_AUTO)));
        props.put(DIALECT, Objects.requireNonNull(env.getProperty(HIBERNATE_DIALECT)));

        props.put(C3P0_MIN_SIZE, Objects.requireNonNull(env.getProperty(HIBERNATE_C3P0_MIN_SIZE)));
        props.put(C3P0_MAX_SIZE, Objects.requireNonNull(env.getProperty(HIBERNATE_C3P0_MAX_SIZE)));
        props.put(C3P0_ACQUIRE_INCREMENT, Objects.requireNonNull(env.getProperty(HIBERNATE_C3P0_ACQUIRE_INC)));
        props.put(C3P0_TIMEOUT, Objects.requireNonNull(env.getProperty(HIBERNATE_C3P0_TIMEOUT)));
        props.put(C3P0_MAX_STATEMENTS, Objects.requireNonNull(env.getProperty(HIBERNATE_MAX_STATEMENTS)));

        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(User.class, Book.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}

