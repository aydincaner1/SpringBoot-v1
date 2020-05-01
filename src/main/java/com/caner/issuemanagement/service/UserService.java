package com.caner.issuemanagement.service;


import com.caner.issuemanagement.dto.UserDto;
import com.caner.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);

    UserDto getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    User getByUsername (String username);

}
