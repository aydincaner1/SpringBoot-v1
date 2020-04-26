package com.caner.issuemanagement.service.impl;

import com.caner.issuemanagement.dto.IssueDto;
import com.caner.issuemanagement.entity.Issue;
import com.caner.issuemanagement.repository.IssueRepository;
import com.caner.issuemanagement.service.IssueService;
import com.caner.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

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
            throw new IllegalArgumentException("Issue date cannot be null");

        Issue issueDb = modelMapper.map(issue,Issue.class);
        issueDb= issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
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
    public Boolean delete(IssueDto issue) {
        return null;
    }
}
