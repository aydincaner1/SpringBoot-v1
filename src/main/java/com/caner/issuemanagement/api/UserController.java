package com.caner.issuemanagement.api;

import com.caner.issuemanagement.dto.ProjectDto;
import com.caner.issuemanagement.dto.UserDto;
import com.caner.issuemanagement.service.impl.ProjectServiceImpl;
import com.caner.issuemanagement.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl= userServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id){
        UserDto userDto = userServiceImpl.getById(id);
        return  ResponseEntity.ok(userDto);
    }
}
