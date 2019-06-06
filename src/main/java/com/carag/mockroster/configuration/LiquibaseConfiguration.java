package com.carag.mockroster.configuration;

import com.sun.javafx.binding.Logging;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.StringWriter;
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

        new Liquibase(changeLog, new ClassLoaderResourceAccessor(),
                new JdbcConnection(DriverManager.getConnection(url, username, password))).update("");
    }

}