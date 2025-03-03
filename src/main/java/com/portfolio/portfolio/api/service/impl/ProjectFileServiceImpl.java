package com.portfolio.portfolio.api.service.impl;

import com.portfolio.portfolio.api.service.IProjectFileService;
import com.portfolio.portfolio.api.service.generic.GenericServiceImpl;
import com.portfolio.portfolio.domain.dto.request.ProjectFileRequestDto;
import com.portfolio.portfolio.domain.dto.response.ProjectFileResponseDto;
import com.portfolio.portfolio.domain.mapper.IMapper;
import com.portfolio.portfolio.domain.mapper.ProjectFileMapper;
import com.portfolio.portfolio.domain.model.ProjectFile;
import com.portfolio.portfolio.domain.repository.IProjectFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProjectFileServiceImpl extends GenericServiceImpl<ProjectFile, ProjectFileResponseDto, ProjectFileRequestDto, Long> implements IProjectFileService {

    private final ProjectFileMapper projectMapper;
    private final IProjectFileRepository projectFileRepository;

    private final MessageSource messenger;

    @Override
    public ProjectFileResponseDto save(ProjectFileRequestDto projectFileRequestDto) {
        return super.save(projectFileRequestDto);
    }

    @Override
    public JpaRepository<ProjectFile, Long> getRepository() {
        return projectFileRepository;
    }

    @Override
    public IMapper<ProjectFile, ProjectFileResponseDto, ProjectFileRequestDto> getMapper() {
        return projectMapper;
    }

    @Override
    public MessageSource getMessenger() {
        return messenger;
    }

}
