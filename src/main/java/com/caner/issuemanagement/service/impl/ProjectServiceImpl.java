package com.caner.issuemanagement.service.impl;

import com.caner.issuemanagement.entity.Project;
import com.caner.issuemanagement.service.ProjectService;
import com.caner.issuemanagement.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public  ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }

    @Override
    public Project save(Project project) {
        if(project.getProjectCode()==null) {
            throw new IllegalArgumentException("Project Code cannot be null");
        }
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
