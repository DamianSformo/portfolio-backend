package com.portfolio.portfolio.api.service;

import com.portfolio.portfolio.api.service.generic.GenericServiceAPI;
import com.portfolio.portfolio.domain.dto.request.StudyRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.model.Study;

import java.util.List;

public interface IStudyService extends GenericServiceAPI<Study, StudyResponseDto, StudyRequestDto, Long> {

    StudyResponseDto save(StudyRequestDto studyRequestDto);

    StudyResponseDto getById(Long id);

    StudyResponseDtoLang getByIdLang(Long id, String lang);

    List<StudyResponseDto> getView();

    List<StudyResponseDto> getAll();

    List<StudyResponseDtoLang> getViewLang(String lang);

    StudyResponseDto update(StudyRequestDto studyRequestDto, Long id);

    StudyResponseDto activate(Long id);

    void delete(Long id);

}
