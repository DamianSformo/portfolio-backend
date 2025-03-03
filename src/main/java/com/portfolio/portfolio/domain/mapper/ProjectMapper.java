package com.portfolio.portfolio.domain.mapper;

import com.portfolio.portfolio.domain.dto.request.ProjectRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.model.Project;
import com.portfolio.portfolio.domain.projection.ProjectPreviewProjection;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProjectMapper implements IMapper<Project, ProjectResponseDto, ProjectRequestDto> {

    public abstract ProjectResponseDto entityToResponseDto(Project project);

    public abstract Project requestDtoToEntity(ProjectRequestDto projectRequestDto);

    public abstract List<ProjectResponseDto> listEntityToListResponseDto(List<Project> projects);

    @Named("entityToResponseDtoEs")
    @Mapping(source = "titleEs", target = "title")
    @Mapping(source = "descriptionEs", target = "description")
    @Mapping(source = "textEs", target = "text")
    @Mapping(source = "techniqueEs", target = "technique")
    public abstract ProjectResponseDtoLang entityToResponseDtoEs(Project project);

    @Named("entityToResponseDtoEn")
    @Mapping(source = "titleEn", target = "title")
    @Mapping(source = "descriptionEn", target = "description")
    @Mapping(source = "textEn", target = "text")
    @Mapping(source = "techniqueEn", target = "technique")
    public abstract ProjectResponseDtoLang entityToResponseDtoEn(Project project);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEs")
    public abstract List<ProjectResponseDtoLang> listEntityToListResponseDtoEs(List<Project> projects);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEn")
    public abstract List<ProjectResponseDtoLang> listEntityToListResponseDtoEn(List<Project> projects);

    @Named("projectPreviewProjectionToProjectPreviewResponseDtoEs")
    @Mapping(source = "titleEs", target = "title")
    public abstract ProjectResponsePreviewDtoLang projectPreviewProjectionToProjectPreviewResponseDtoEs (ProjectPreviewProjection projectPreviewProjection);

    @Named("projectPreviewProjectionToProjectPreviewResponseDtoEn")
    @Mapping(source = "titleEn", target = "title")
    public abstract ProjectResponsePreviewDtoLang projectPreviewProjectionToProjectPreviewResponseDtoEn (ProjectPreviewProjection projectPreviewProjection);

    @IterableMapping(qualifiedByName = "projectPreviewProjectionToProjectPreviewResponseDtoEs")
    public abstract List<ProjectResponsePreviewDtoLang> listProjectPreviewProjectionToListProjectPreviewResponseDtoEs(List<ProjectPreviewProjection> listProjectPreviewProjection);

    @IterableMapping(qualifiedByName = "projectPreviewProjectionToProjectPreviewResponseDtoEn")
    public abstract List<ProjectResponsePreviewDtoLang> listProjectPreviewProjectionToListProjectPreviewResponseDtoEn(List<ProjectPreviewProjection> listProjectPreviewProjection);

    public void updateEntityFromRequestDto(ProjectRequestDto dto, Project project) {
        if (dto.getTitleEs() != null) {
            project.setTitleEs(dto.getTitleEs());
        }
        if (dto.getTitleEn() != null) {
            project.setTitleEn(dto.getTitleEn());
        }
        if (dto.getDescriptionEs() != null) {
            project.setDescriptionEs(dto.getDescriptionEs());
        }
        if (dto.getDescriptionEn() != null) {
            project.setDescriptionEn(dto.getDescriptionEn());
        }
        if (dto.getTextEs() != null) {
            project.setTextEs(dto.getTextEs());
        }
        if (dto.getTextEn() != null) {
            project.setTextEn(dto.getTextEn());
        }
        if (dto.getYear() != null) {
            project.setYear(dto.getYear());
        }
        if (dto.getOrderIndex() != null) {
            project.setOrderIndex(dto.getOrderIndex());
        }
    }
}