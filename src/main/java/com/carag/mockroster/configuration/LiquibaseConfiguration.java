package com.carag.mockroster.configuration;

import com.carag.mockroster.WorkingClass;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.DriverManager;
import java.sql.SQLException;


@Configuration
public class LiquibaseConfiguration {

    @Inject
    Environment env;

    @Inject
    WorkingClass w;

    private final EntityManager entityManager;

    @Autowired
    public LiquibaseConfiguration(final EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }



    @PostConstruct
    public void liquibase() throws SQLException, LiquibaseException, InterruptedException {

        Logger logger = LogManager.getLogger(LiquibaseConfiguration.class);
        String seed = env.getProperty("spring.liquibase.seed");

        if (!Boolean.parseBoolean(seed) && null != seed) {
            logger.info("Seed disabled, skipping... ");
           // return;
        }

        String url = env.getProperty("spring.datasource.url");
        String username = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String changeLog = env.getProperty("spring.liquibase.change-log").replace("classpath:", "");

        logger.info("Beginning CSV load... ");
        new Liquibase(changeLog, new ClassLoaderResourceAccessor(),
                new JdbcConnection(DriverManager.getConnection(url, username, password))).update("");
        logger.info("Finished CSV load... ");

        FullTextEntityManager fullTextEntityManager =  Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.createIndexer().startAndWait();

        Object x = w.execute();

        System.out.printf("");
    }

}
