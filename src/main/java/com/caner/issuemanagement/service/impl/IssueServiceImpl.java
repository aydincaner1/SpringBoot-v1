package com.caner.issuemanagement.service.impl;

import com.caner.issuemanagement.dto.IssueDto;
import com.caner.issuemanagement.entity.Issue;
import com.caner.issuemanagement.repository.IssueRepository;
import com.caner.issuemanagement.service.IssueService;
import com.caner.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service

public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public  IssueServiceImpl(IssueRepository issueRepository,ModelMapper modelMapper) {

        this.issueRepository=issueRepository;
        this.modelMapper=modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate()== null)
            throw new IllegalArgumentException("issue date cannot be null");
/*
        if (issue.getIssueStatus()== null)
            throw new IllegalArgumentException("Issue statu cannot be null");*/

        Issue issueEntity = modelMapper.map(issue, Issue.class);
        issueEntity = issueRepository.save(issueEntity);
        issue.setId(issueEntity.getId());
        return issue;

       /* Issue issueDb = modelMapper.map(issue,Issue.class);
        issueDb = issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);*/
    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return null;
    }


    @Override
    public IssueDto update(Long id, IssueDto project) {
        return null;
    }
}
