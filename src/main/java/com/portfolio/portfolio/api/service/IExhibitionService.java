package com.portfolio.portfolio.api.service;

import com.portfolio.portfolio.api.service.generic.GenericServiceAPI;
import com.portfolio.portfolio.domain.dto.request.ExhibitionRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.model.Exhibition;

import java.util.List;

public interface IExhibitionService extends GenericServiceAPI<Exhibition, ExhibitionResponseDto, ExhibitionRequestDto, Long> {

    ExhibitionResponseDto save(ExhibitionRequestDto exhibitionRequestDto);

    ExhibitionResponseDto getById(Long id);

    ExhibitionResponseDtoLang getByIdLang(Long id, String lang);

    List<ExhibitionResponseDto> getView();

    List<ExhibitionResponseDto> getAll();

    List<ExhibitionResponseDtoLang> getViewLang(String lang);

    ExhibitionCompleteResponseDtoLang getComplete(String lang);

    ExhibitionResponseDto update(ExhibitionRequestDto exhibitionRequestDto, Long id);

    ExhibitionResponseDto activate(Long id);

    void delete(Long id);

}
