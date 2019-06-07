package com.carag.mockroster.configuration;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
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


        String url = env.getProperty("spring.datasource.url");
        String username = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String changeLog = env.getProperty("spring.liquibase.change-log").replace("classpath:", "");

        Logger logger = LogManager.getLogger(this.getClass());
        Level level = logger.getLevel();

        try {
            logger.info("Beginning CSV load... ");
            setLevel(Level.WARN);
            new Liquibase(changeLog, new ClassLoaderResourceAccessor(),
                    new JdbcConnection(DriverManager.getConnection(url, username, password))).update("");

        } finally {
            setLevel(level);
            logger.info("Finished CSV load... ");
        }
    }

    private void setLevel(Level level){
        if (Boolean.parseBoolean(env.getProperty("spring.liquibase.silentSQL")))
            Configurator.setLevel(LogManager.getRootLogger().getName(), level);
    }
}
