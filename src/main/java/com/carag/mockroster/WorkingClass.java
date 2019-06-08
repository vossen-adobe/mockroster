package com.carag.mockroster;

import com.carag.mockroster.data.repository.SectionRepository;
import com.carag.mockroster.data.repository.UserRepository;
import com.carag.mockroster.entity.Section;
import com.carag.mockroster.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Component
public class WorkingClass {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SectionRepository sectionRepository;

  //  @PostConstruct
    public void execute() {

        Object o = userRepository.findAll();

        Object s = sectionRepository.findAll();
     //   Section s = sectionRepository.findAll().iterator().next();
     //   User u = userRepository.findById("18217").get();

        String z = ((List<User>) o).get(0).toString();
        System.out.println();
    }
}
