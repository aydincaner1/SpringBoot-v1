package com.caner.issuemanagement.service.impl;

import com.caner.issuemanagement.dto.ProjectDto;
import com.caner.issuemanagement.entity.Project;
import com.caner.issuemanagement.service.ProjectService;
import com.caner.issuemanagement.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public  ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper){
        this.projectRepository=projectRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        /*if(project.getProjectCode()==null) {
            throw new IllegalArgumentException("Project Code cannot be null");
        }*/

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
       // Project projectName = projectRepository.getByProjectName(project.getProjectName());

        if (projectCheck !=null)
            throw new IllegalArgumentException("Project code already exist");

        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<ProjectDto> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
