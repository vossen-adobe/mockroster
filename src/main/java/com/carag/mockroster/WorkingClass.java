package com.carag.mockroster;

import com.carag.mockroster.data.repository.UserRepository;
import com.carag.mockroster.entity.User;
import com.carag.mockroster.execption.customexception.SearchFailedException;
import com.carag.mockroster.search.FullTextSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashSet;

@Component
public class WorkingClass {

    @Autowired
    private UserRepository userRepository;

    @Inject
    private FullTextSearch fullTextSearch;
//    @Autowired
//    private SectionRepository sectionRepository;



  //  @PostConstruct
   // @Transactional
    public Object execute() {

        Object o = null;

        try {
            fullTextSearch.setEntityType(User.class);
            o = fullTextSearch.search("sectionSe0t.sourcedId:32707");
        } catch (SearchFailedException e){
            System.out.println();
        }
       // Object o = new HashSet(userRepository.findAll());

//
//        Object s = sectionRepository.findAll();

      //  Object t = testData.getAllUsers();
     //   Section s = sectionRepository.findAll().iterator().next();
     //   User u = userRepository.findById("18217").get();
        return null;
    }
}
