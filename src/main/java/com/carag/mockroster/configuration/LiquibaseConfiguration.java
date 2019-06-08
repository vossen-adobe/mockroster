package com.carag.mockroster.configuration;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.sql.DriverManager;
import java.sql.SQLException;


@Configuration
public class LiquibaseConfiguration {

    @Inject
    Environment env;

    @PostConstruct
    public void liquibase() throws SQLException, LiquibaseException {

        Logger logger = LogManager.getLogger(LiquibaseConfiguration.class);
        String seed = env.getProperty("spring.liquibase.seed");

        if (!Boolean.parseBoolean(seed) && null != seed) {
            logger.info("Seed disabled, skipping... ");
            return;
        }

        String url = env.getProperty("spring.datasource.url");
        String username = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String changeLog = env.getProperty("spring.liquibase.change-log").replace("classpath:", "");

        logger.info("Beginning CSV load... ");
        new Liquibase(changeLog, new ClassLoaderResourceAccessor(),
                new JdbcConnection(DriverManager.getConnection(url, username, password))).update("");
        logger.info("Finished CSV load... ");

    }

}
