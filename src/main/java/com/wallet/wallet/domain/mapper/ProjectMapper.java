package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.ProjectRequestDto;
import com.wallet.wallet.domain.dto.response.ProjectResponseDto;
import com.wallet.wallet.domain.dto.response.ProjectResponseDtoLang;
import com.wallet.wallet.domain.dto.response.ProjectResponsePreviewDto;
import com.wallet.wallet.domain.model.Project;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProjectMapper implements IMapper<Project, ProjectResponseDto, ProjectRequestDto> {

    public abstract ProjectResponseDto entityToResponseDto(Project project);

    public abstract Project requestDtoToEntity(ProjectRequestDto projectRequestDto);

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

    @Named("entityToResponsePreviewDtoEs")
    @Mapping(source = "titleEs", target = "title")
    public abstract ProjectResponsePreviewDto entityToResponsePreviewDtoEs(Project project);

    @Named("entityToResponsePreviewDtoEn")
    @Mapping(source = "titleEn", target = "title")
    public abstract ProjectResponsePreviewDto entityToResponsePreviewDtoEn(Project project);

    public abstract List<ProjectResponseDto> listEntityToListProjectDto(List<Project> projects);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEs")
    public abstract List<ProjectResponseDtoLang> listEntityToListProjectDtoEs(List<Project> projects);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEn")
    public abstract List<ProjectResponseDtoLang> listEntityToListProjectDtoEn(List<Project> projects);

    @IterableMapping(qualifiedByName = "entityToResponsePreviewDtoEs")
    public abstract List<ProjectResponsePreviewDto> listEntityToListProjectDtoPreviewEs(List<Project> projects);

    @IterableMapping(qualifiedByName = "entityToResponsePreviewDtoEn")
    public abstract List<ProjectResponsePreviewDto> listEntityToListProjectDtoPreviewEn(List<Project> projects);

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