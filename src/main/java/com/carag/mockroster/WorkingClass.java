package com.carag.mockroster;

import com.carag.mockroster.data.repository.SectionRepository;
import com.carag.mockroster.data.repository.TestData;
import com.carag.mockroster.data.repository.UserRepository;
import com.carag.mockroster.entity.Section;
import com.carag.mockroster.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class WorkingClass {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SectionRepository sectionRepository;


    @Autowired
    private TestData testData;

  //  @PostConstruct
    @Transactional
    public void execute() {

        Object o = new HashSet(userRepository.findAll());
        Object s = new HashSet(sectionRepository.findAll());
//
//        Object s = sectionRepository.findAll();

      //  Object t = testData.getAllUsers();
     //   Section s = sectionRepository.findAll().iterator().next();
     //   User u = userRepository.findById("18217").get();

        System.out.println();
    }
}
