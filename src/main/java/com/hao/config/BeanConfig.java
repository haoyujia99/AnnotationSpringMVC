package com.hao.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * com.hao.config
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 9:45
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "com.hao.*")
@PropertySource(value = "classpath:jdbc.properties")
public class BeanConfig {

    private static final Logger logger = LoggerFactory.getLogger(BeanConfig.class);

    @Value(value = "${jdbc.driver}")
    private String driver;

    @Value(value = "${jdbc.url}")
    private String url;

    @Value(value = "${jdbc.username}")
    private String username;

    @Value(value = "${jdbc.password}")
    private String password;

    @Bean
    public DataSource getDataSource() {

        logger.info("##### GENERATE DATASOURCE BEAN #####");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {

        logger.info("##### GENERATE JDBC TEMPLATE BEAN #####");
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public PlatformTransactionManager getPlatformTransactionManager() {

        logger.info("##### GENERATE TRANSACTION BEAN #####");
        return new DataSourceTransactionManager(getDataSource());
    }

}
