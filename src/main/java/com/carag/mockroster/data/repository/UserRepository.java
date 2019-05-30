package com.carag.mockroster.data.repository;

import com.carag.mockroster.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
}


