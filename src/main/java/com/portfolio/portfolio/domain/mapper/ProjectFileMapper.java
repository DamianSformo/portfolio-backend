package com.portfolio.portfolio.domain.mapper;

import com.portfolio.portfolio.domain.dto.request.ProjectFileRequestDto;
import com.portfolio.portfolio.domain.dto.response.ProjectFileResponseDto;
import com.portfolio.portfolio.domain.dto.response.ProjectFileResponseDtoLang;
import com.portfolio.portfolio.domain.model.ProjectFile;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProjectFileMapper implements IMapper<ProjectFile, ProjectFileResponseDto, ProjectFileRequestDto> {

    public abstract ProjectFileResponseDto entityToResponseDto(ProjectFile projectFile);

    @Mapping(source = "projectId", target = "project.id")
    public abstract ProjectFile requestDtoToEntity(ProjectFileRequestDto projectFileRequestDto);

    public abstract List<ProjectFileResponseDto> listEntityToListProjectFileDto(List<ProjectFile> projectFiles);

    @Named("entityToResponseDtoEs")
    @Mapping(source = "textEs", target = "text")
    public abstract ProjectFileResponseDtoLang entityToResponseDtoEs(ProjectFile projectFile);

    @Named("entityToResponseDtoEn")
    @Mapping(source = "textEn", target = "text")
    public abstract ProjectFileResponseDtoLang entityToResponseDtoEn(ProjectFile projectFile);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEs")
    public abstract List<ProjectFileResponseDtoLang> listEntityToListProjectFileDtoEs(List<ProjectFile> projectFiles);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEn")
    public abstract List<ProjectFileResponseDtoLang> listEntityToListProjectFileDtoEn(List<ProjectFile> projectFiles);
}