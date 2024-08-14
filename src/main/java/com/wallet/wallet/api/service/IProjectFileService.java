package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.ProjectFileRequestDto;
import com.wallet.wallet.domain.dto.request.ProjectRequestDto;
import com.wallet.wallet.domain.dto.response.ProjectFileResponseDto;
import com.wallet.wallet.domain.dto.response.ProjectResponseDto;
import com.wallet.wallet.domain.model.Project;
import com.wallet.wallet.domain.model.ProjectFile;

import java.util.List;

public interface IProjectFileService extends GenericServiceAPI<ProjectFile, ProjectFileResponseDto, ProjectFileRequestDto, Long> {

    ProjectFileResponseDto save(ProjectFileRequestDto projectFileRequestDto);

}
