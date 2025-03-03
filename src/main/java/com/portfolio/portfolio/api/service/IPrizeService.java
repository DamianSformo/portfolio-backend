package com.portfolio.portfolio.api.service;

import com.portfolio.portfolio.api.service.generic.GenericServiceAPI;
import com.portfolio.portfolio.domain.dto.request.PrizeRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.model.Prize;

import java.util.List;

public interface IPrizeService extends GenericServiceAPI<Prize, PrizeResponseDto, PrizeRequestDto, Long> {

    PrizeResponseDto save(PrizeRequestDto prizeRequestDto);

    PrizeResponseDto getById(Long id);

    PrizeResponseDtoLang getByIdLang(Long id, String lang);

    List<PrizeResponseDto> getView();

    List<PrizeResponseDto> getAll();

    List<PrizeResponseDtoLang> getViewLang(String lang);

    PrizeResponseDto update(PrizeRequestDto prizeRequestDto, Long id);

    PrizeResponseDto activate(Long id);

    void delete(Long id);

}
