package com.carag.mockroster.entity;

import com.carag.mockroster.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class TestData {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private SectionRepository sectionRepository;

    @Transactional
    public List<User> getAllUsers() {
//
//        userRepository.findAll();
//        sectionRepository.findAll();

        String hql = "select u from User u left join fetch Enrollment e on u.sourcedId=e.user left join fetch Section s on s.sourcedId=e.section";

        return (List<User>) entityManager.createQuery(hql).getResultList();

//        return entityManager.createQuery(
//                "select u " +
//                        "from User u " +
//                        "join fetch Enrollment.user " +
//                        "where u.sectionList = :section", User.class)
//                .setParameter("section", section)
//                .getResultList();


    }

//    String queryText = "select u from User u join fetch Enrollment e on u.userId=e.userId join fetch " +
//            "ClassOfCourse c on e.classId=c.classId where c.sourcedId = "
//            + surround(sourcedId) + setRole(role);
//
//        return (List<User>) entityManager
//            .createQuery(queryText)
//            .setMaxResults(limit)
//                .setFirstResult(offset)
//                .getResultList();
}
