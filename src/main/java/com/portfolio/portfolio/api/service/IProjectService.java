package com.portfolio.portfolio.api.service;

import com.portfolio.portfolio.api.service.generic.GenericServiceAPI;
import com.portfolio.portfolio.domain.dto.request.ProjectRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.model.Project;

import java.util.List;

public interface IProjectService extends GenericServiceAPI<Project, ProjectResponseDto, ProjectRequestDto, Long> {

    ProjectResponseDto save(ProjectRequestDto projectRequestDto);

    ProjectResponseDto getById(Long id);

    ProjectResponseDtoLang getByIdLang(Long id, String lang);

    List<ProjectResponseDto> getView();

    List<ProjectResponseDtoLang> getViewLang(String lang);

    List<ProjectResponseDto> getAll();

    List<ProjectResponsePreviewDtoLang> getPreviewLang(String lang);

    ProjectResponseDto update(ProjectRequestDto projectRequestDto, Long id);

    ProjectResponseDto active(Long id);

    void delete(Long id);

}
