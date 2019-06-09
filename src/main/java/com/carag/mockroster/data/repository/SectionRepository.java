package com.carag.mockroster.data.repository;

import com.carag.mockroster.entity.Section;
import com.carag.mockroster.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SectionRepository extends PagingAndSortingRepository<Section, String> {

  //  @Query("select s from Section s left join fetch Enrollment e on s.sourcedId=e.section left join fetch User u on u.sourcedId=e.user")
    List<Section> findAll();
}


