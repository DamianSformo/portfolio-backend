package com.portfolio.portfolio.api.service.impl;

import com.portfolio.portfolio.api.service.IProjectService;
import com.portfolio.portfolio.api.service.generic.GenericServiceImpl;
import com.portfolio.portfolio.domain.dto.request.ProjectRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.enums.ERecordStatus;
import com.portfolio.portfolio.domain.mapper.IMapper;
import com.portfolio.portfolio.domain.mapper.ProjectFileMapper;
import com.portfolio.portfolio.domain.mapper.ProjectMapper;
import com.portfolio.portfolio.domain.model.Project;
import com.portfolio.portfolio.domain.model.ProjectFile;
import com.portfolio.portfolio.domain.projection.ProjectPreviewProjection;
import com.portfolio.portfolio.domain.repository.IProjectFileRepository;
import com.portfolio.portfolio.domain.repository.IProjectRepository;
import com.portfolio.portfolio.handler.exception.ResourceNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

import static com.portfolio.portfolio.domain.enums.EMessageCode.RESOURCE_NOT_FOUND_BY_ID;

@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project, ProjectResponseDto, ProjectRequestDto, Long> implements IProjectService {

    private final ProjectMapper mapper;
    private final IProjectRepository repository;
    private final ProjectFileMapper projectFileMapper;
    private final IProjectFileRepository projectFileRepository;

    private final MessageSource messenger;

    private final Map<String, Function<List<Project>, List<ProjectResponseDtoLang>>> langMappers;

    private final Map<String, Function<Project, ProjectResponseDtoLang>> singleLangMappers;

    private final Map<String, Function<List<ProjectPreviewProjection>, List<ProjectResponsePreviewDtoLang>>> langMappersPreview;

    public ProjectServiceImpl(ProjectMapper mapper, IProjectRepository repository, ProjectFileMapper projectFileMapper, IProjectFileRepository projectFileRepository, MessageSource messenger) {
        this.mapper = mapper;
        this.repository = repository;
        this.projectFileMapper = projectFileMapper;
        this.projectFileRepository = projectFileRepository;
        this.messenger = messenger;
        this.langMappers = Map.of(
                "es", mapper::listEntityToListResponseDtoEs,
                "en", mapper::listEntityToListResponseDtoEn
        );
        this.singleLangMappers = Map.of(
                "es", mapper::entityToResponseDtoEs,
                "en", mapper::entityToResponseDtoEn
        );
        this.langMappersPreview = Map.of(
                "es", mapper::listProjectPreviewProjectionToListProjectPreviewResponseDtoEs,
                "en", mapper::listProjectPreviewProjectionToListProjectPreviewResponseDtoEn
        );
    }

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
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                        new Object[]{"Project", id}, Locale.getDefault())));

        Function<Project, ProjectResponseDtoLang> mapperFunction = singleLangMappers.getOrDefault(lang, mapper::entityToResponseDtoEs);

        ProjectResponseDtoLang projectResponseDtoLang = mapperFunction.apply(existing);

        Function<List<ProjectFile>, List<ProjectFileResponseDtoLang>> fileMapperFunction =
                lang.equals("en") ? projectFileMapper::listEntityToListProjectFileDtoEn
                        : projectFileMapper::listEntityToListProjectFileDtoEs;

        projectResponseDtoLang.setProjectFiles(fileMapperFunction.apply(projectFileRepository.getProjectFileByProjectId(id)));

        return projectResponseDtoLang;
    }


    @Override
    public List<ProjectResponseDto> getView() {
        List<ProjectResponseDto> projectResponseDtos = mapper.listEntityToListResponseDto(repository.findByRecordStatusOrderByOrderIndexAsc(ERecordStatus.A));

        for (ProjectResponseDto projectResponseDto : projectResponseDtos) {
            Long projectId = projectResponseDto.getId();
            projectResponseDto.setProjectFiles(projectFileMapper.listEntityToListProjectFileDto(projectFileRepository.getProjectFileByProjectId(projectId)));
        }

        return projectResponseDtos;
    }

    @Override
    public List<ProjectResponseDtoLang> getViewLang(String lang) {
        List<Project> listProject = repository.findByRecordStatusOrderByOrderIndexAsc(ERecordStatus.A);

        Function<List<Project>, List<ProjectResponseDtoLang>> mapperFunction =
                langMappers.getOrDefault(lang, mapper::listEntityToListResponseDtoEs);

        List<ProjectResponseDtoLang> listProjectResponseDtoLang = mapperFunction.apply(listProject);

        Function<List<ProjectFile>, List<ProjectFileResponseDtoLang>> fileMapperFunction =
                lang.equals("en") ? projectFileMapper::listEntityToListProjectFileDtoEn
                        : projectFileMapper::listEntityToListProjectFileDtoEs;

        for (ProjectResponseDtoLang projectResponseDtoLang : listProjectResponseDtoLang) {
            Long projectId = projectResponseDtoLang.getId();
            projectResponseDtoLang.setProjectFiles(
                    fileMapperFunction.apply(projectFileRepository.getProjectFileByProjectId(projectId))
            );
        }

        return listProjectResponseDtoLang;
    }

    @Override
    public List<ProjectResponsePreviewDtoLang> getPreviewLang(String lang) {
        List<ProjectPreviewProjection> listProjectPreviewProjection = repository.getPreview();

        Function<List<ProjectPreviewProjection>, List<ProjectResponsePreviewDtoLang>> mapperFunction =
                langMappersPreview.getOrDefault(lang, mapper::listProjectPreviewProjectionToListProjectPreviewResponseDtoEs);

        List<ProjectResponsePreviewDtoLang> listProjectResponsePreviewDtoLang = mapperFunction.apply(listProjectPreviewProjection);

        Function<ProjectFile, ProjectFileResponseDtoLang> fileMapperFunction =
                lang.equals("en") ? projectFileMapper::entityToResponseDtoEn
                        : projectFileMapper::entityToResponseDtoEs;

        for (ProjectResponsePreviewDtoLang projectResponsePreviewDtoLang : listProjectResponsePreviewDtoLang) {
            Long projectId = projectResponsePreviewDtoLang.getId();
            ProjectFile projectFile = projectFileRepository.getProjectFilePreviewByProjectId(projectId);
            if (projectFile != null) {
                projectResponsePreviewDtoLang.setProjectFile(fileMapperFunction.apply(projectFile));
            }
        }

        return listProjectResponsePreviewDtoLang;
    }

    @Override
    public List<ProjectResponseDto> getAll() {
        return mapper.listEntityToListResponseDto(repository.findAll());
    }

    @Override
    public ProjectResponseDto update(ProjectRequestDto projectRequestDto, Long id) {
        Project existingProject = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                        new Object[] {"Project", id}, Locale.getDefault())));

        mapper.updateEntityFromRequestDto(projectRequestDto, existingProject);
        repository.save(existingProject);

        return getById(id);
    }

    @Override
    public ProjectResponseDto active(Long id) {
        Project existingProject = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                        new Object[] {"Project", id}, Locale.getDefault())));

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
