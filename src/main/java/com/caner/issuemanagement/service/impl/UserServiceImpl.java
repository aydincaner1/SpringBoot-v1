package com.caner.issuemanagement.service.impl;

import com.caner.issuemanagement.entity.User;
import com.caner.issuemanagement.repository.UserRepository;
import com.caner.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User save(User user) {
        //busines logics user mail olmaz ise kayıt edemesin
        if (user.getEmail() == null){
            throw new IllegalArgumentException("User cannot be null");
        }
        user =  userRepository.save(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }
}
