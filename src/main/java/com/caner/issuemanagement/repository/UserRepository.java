package com.caner.issuemanagement.repository;

import com.caner.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByUsername(String username);

    }
