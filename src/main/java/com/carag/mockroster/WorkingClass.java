package com.carag.mockroster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class WorkingClass {

    @Autowired
    private Environment env;

    @PostConstruct
    void execute () {
        String path = env.getProperty("spring.jpa.properties.hibernate.id.new_generator_mappings");

        System.out.println();
    }
}
