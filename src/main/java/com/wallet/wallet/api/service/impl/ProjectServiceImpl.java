package com.wallet.wallet.api.service.impl;

import com.wallet.wallet.api.service.IProjectService;
import com.wallet.wallet.api.service.generic.GenericServiceImpl;
import com.wallet.wallet.domain.dto.request.ProjectRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.enums.ERecordStatus;
import com.wallet.wallet.domain.mapper.IMapper;
import com.wallet.wallet.domain.mapper.ProjectFileMapper;
import com.wallet.wallet.domain.mapper.ProjectMapper;
import com.wallet.wallet.domain.model.Project;
import com.wallet.wallet.domain.repository.IProjectFileRepository;
import com.wallet.wallet.domain.repository.IProjectRepository;
import com.wallet.wallet.handler.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.wallet.wallet.domain.enums.EMessageCode.PROJECT_NOT_EXIST_BY_ID;
import static com.wallet.wallet.domain.enums.EMessageCode.RESOURCE_NOT_FIND_BY_ID;
import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;

@AllArgsConstructor
@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project, ProjectResponseDto, ProjectRequestDto, Long> implements IProjectService {

    private final ProjectMapper mapper;
    private final ProjectFileMapper projectFileMapper;
    private final IProjectRepository repository;
    private final IProjectFileRepository projectFileRepository;

    private final MessageSource messenger;

    @Override
    public ProjectResponseDto save(ProjectRequestDto projectRequestDto) {
        return super.save(projectRequestDto);
    }

    @Override
    public ProjectResponseDto getById(Long id) {
        ProjectResponseDto projectResponseDto = super.getById(id);
        projectResponseDto.setProjectFiles(projectFileMapper.listEntityToListProjectFileDto(projectFileRepository.getProjectFileByProjectId(id)));
        return projectResponseDto;
    }

    @Override
    public ProjectResponseDtoLang getByIdLang(Long id, String lang) {
        Project existing = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));

        ProjectResponseDtoLang projectResponseDtoLen = new ProjectResponseDtoLang();
        switch (lang) {
            case "es" -> projectResponseDtoLen = mapper.entityToResponseDtoEs(existing);
            case "en" -> projectResponseDtoLen = mapper.entityToResponseDtoEn(existing);
        };

        projectResponseDtoLen.setProjectFiles(projectFileMapper.listEntityToListProjectFileDto(projectFileRepository.getProjectFileByProjectId(id)));
        return projectResponseDtoLen;
    }

    @Override
    public ProjectResponseDto update(ProjectRequestDto projectRequestDto, Long id) {
        Project existingProject = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(PROJECT_NOT_EXIST_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));

        mapper.updateEntityFromRequestDto(projectRequestDto, existingProject);
        repository.save(existingProject);

        return getById(id);
    }

    @Override
    public List<ProjectResponseDto> getView() {
        List<ProjectResponseDto> projectResponseDtos = mapper.listEntityToListProjectDto(repository.getView());

        for (ProjectResponseDto projectResponseDto : projectResponseDtos) {
            Long projectId = projectResponseDto.getId();
            projectResponseDto.setProjectFiles(projectFileMapper.listEntityToListProjectFileDto(projectFileRepository.getProjectFileByProjectId(projectId)));
        }

        return projectResponseDtos;
    }

    @Override
    public List<ProjectResponseDtoLang> getViewLang(String lang) {
        List<Project> listProject = repository.getView();

        List<ProjectResponseDtoLang> listProjectResponseDtoLang = new ArrayList<>();
        switch (lang) {
            case "es" -> listProjectResponseDtoLang = mapper.listEntityToListProjectDtoEs(listProject);
            case "en" -> listProjectResponseDtoLang = mapper.listEntityToListProjectDtoEn(listProject);
        };

        for (ProjectResponseDtoLang projectResponseDtoLang : listProjectResponseDtoLang) {
            Long projectId = projectResponseDtoLang.getId();
            projectResponseDtoLang.setProjectFiles(projectFileMapper.listEntityToListProjectFileDto(projectFileRepository.getProjectFileByProjectId(projectId)));
        }

        return listProjectResponseDtoLang;
    }

    @Override
    public List<ProjectResponsePreviewDto> getPreviewLang(String lang) {
        List<Project> listProject = repository.getView();

        List<ProjectResponsePreviewDto> listProjectResponsePreviewDtoLang = new ArrayList<>();
        switch (lang) {
            case "es" -> listProjectResponsePreviewDtoLang = mapper.listEntityToListProjectDtoPreviewEs(listProject);
            case "en" -> listProjectResponsePreviewDtoLang = mapper.listEntityToListProjectDtoPreviewEn(listProject);
        };

        for (ProjectResponsePreviewDto projectResponsePreviewDtoLang : listProjectResponsePreviewDtoLang) {
            Long projectId = projectResponsePreviewDtoLang.getId();
            projectResponsePreviewDtoLang.setProjectFile(projectFileMapper.entityToResponseDto(projectFileRepository.getProjectFilePreviewByProjectId(projectId)));
        }

        return listProjectResponsePreviewDtoLang;
    }

    @Override
    public List<ProjectResponseDto> getAll() {
        return mapper.listEntityToListProjectDto(repository.getAll());
    }

    @Override
    public ProjectResponseDto active(Long id) {
        Project existingProject = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(PROJECT_NOT_EXIST_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));

        if (ERecordStatus.A.equals(existingProject.getRecordStatus())) {
            existingProject.setRecordStatus(ERecordStatus.D);
        } else {
            existingProject.setRecordStatus(ERecordStatus.A);
        }

        repository.save(existingProject);

        return getById(id);
    }

    @Override
    public void delete(Long id){
        super.delete(id);
    }

    @Override
    public JpaRepository<Project, Long> getRepository() {
        return repository;
    }

    @Override
    public IMapper<Project, ProjectResponseDto, ProjectRequestDto> getMapper() {
        return mapper;
    }

    @Override
    public MessageSource getMessenger() {
        return messenger;
    }

}
