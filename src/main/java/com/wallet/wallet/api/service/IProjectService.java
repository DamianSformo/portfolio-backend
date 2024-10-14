package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.ProjectRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.model.Project;

import java.util.List;

public interface IProjectService extends GenericServiceAPI<Project, ProjectResponseDto, ProjectRequestDto, Long> {

    ProjectResponseDto save(ProjectRequestDto projectRequestDto);

    ProjectResponseDto update(ProjectRequestDto projectRequestDto, Long id);

    ProjectResponseDto active(Long id);

    ProjectResponseDto getById(Long id);

    ProjectResponseDtoLang getByIdLang(Long id, String lang);

    List<ProjectResponseDto> getView();

    List<ProjectResponseDtoLang> getViewLang(String lang);

    List<ProjectResponsePreviewDto> getPreviewLang(String lang);

    List<ProjectResponseDto> getAll();

    void delete(Long id);

}
