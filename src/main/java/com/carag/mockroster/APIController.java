package com.carag.mockroster;


import com.carag.mockroster.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class APIController {

    @Autowired
    private UserRepository userRepository;




    @RequestMapping(value = "/test", produces = "application/hal+json")
    public Object thing(){
        return userRepository.findAll();
    }

}
