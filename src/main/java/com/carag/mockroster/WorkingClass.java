package com.carag.mockroster;

import com.carag.mockroster.data.repository.UserRepository;
import com.carag.mockroster.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class WorkingClass {


    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    void execute() throws IOException {


       // logger.info("ARRRRRR");


        User u = new User();

        Object o = userRepository.findAll();

        User s = userRepository.save(u);
        System.out.println();
    }
}
