package com.portfolio.portfolio.api.service;

import com.portfolio.portfolio.api.service.generic.GenericServiceAPI;
import com.portfolio.portfolio.domain.dto.request.ProjectFileRequestDto;
import com.portfolio.portfolio.domain.dto.response.ProjectFileResponseDto;
import com.portfolio.portfolio.domain.model.ProjectFile;

public interface IProjectFileService extends GenericServiceAPI<ProjectFile, ProjectFileResponseDto, ProjectFileRequestDto, Long> {

    ProjectFileResponseDto save(ProjectFileRequestDto projectFileRequestDto);

}
