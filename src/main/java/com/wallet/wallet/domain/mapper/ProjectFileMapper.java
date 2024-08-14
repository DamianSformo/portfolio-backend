package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.ProjectFileRequestDto;
import com.wallet.wallet.domain.dto.response.ProjectFileResponseDto;
import com.wallet.wallet.domain.model.ProjectFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProjectFileMapper implements IMapper<ProjectFile, ProjectFileResponseDto, ProjectFileRequestDto> {

    public abstract ProjectFileResponseDto entityToResponseDto(ProjectFile projectFile);

    @Mapping(source = "projectId", target = "project.id")
    public abstract ProjectFile requestDtoToEntity(ProjectFileRequestDto projectFileRequestDto);

    public abstract List<ProjectFileResponseDto> listEntityToListProjectFileDto(List<ProjectFile> projectFiles);
}