package com.caner.issuemanagement.api;

import com.caner.issuemanagement.dto.ProjectDto;
import com.caner.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl){
        this.projectServiceImpl=projectServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return  ResponseEntity.ok(projectDto);
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    //@RequestMapping(path = "/project", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id,@Valid @RequestBody ProjectDto project){
    return ResponseEntity.ok(projectServiceImpl.update(id,project));
    }



}
