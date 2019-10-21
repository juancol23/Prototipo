package com.example.prototipo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;
/*
@Configuration
public class Database {

    private static final Logger logger = LogManager.getLogger();
    private static HikariDataSource datasource;
    static Properties prop = new Properties();
    static Connection con;

    @Bean(name = "dataSource", destroyMethod = "close")
    public static DataSource datasource() {

        if (datasource == null) {
            final HikariConfig config = new HikariConfig();
            config.setDriverClassName(System.getenv("TDP_FIJA_DB_DRIVER"));
            config.setJdbcUrl(System.getenv("sl-us-south-1-portal.57.dblayer.com"));
            config.setUsername(System.getenv("admin"));
            config.setPassword(System.getenv("ANNTBRCNZRGWARRY"));

            config.addDataSourceProperty("ApplicationName", System.getenv("TDP_FIJA_DB_APLICATION_NAME"));
            config.setMinimumIdle(Integer.parseInt(System.getenv("TDP_FIJA_DB_MINIMUM_IDLE")));
            config.setMaximumPoolSize(Integer.parseInt(System.getenv("TDP_FIJA_DB_POOLING")));
            config.setIdleTimeout(Integer.parseInt(System.getenv("TDP_FIJA_DB_TIMEOUT_IDLE")));

            config.setMaxLifetime(Integer.parseInt(System.getenv("TDP_FIJA_DB_MAX_LIFETIME")));

            datasource = new HikariDataSource(config);
        }
        return datasource;
    }
}
*/
