package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.PrizeRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.model.Prize;

import java.util.List;

public interface IPrizeService extends GenericServiceAPI<Prize, PrizeResponseDto, PrizeRequestDto, Long> {

    PrizeResponseDto save(PrizeRequestDto prizeRequestDto);

    PrizeResponseDto update(PrizeRequestDto prizeRequestDto, Long id);

    PrizeResponseDto getById(Long id);

    PrizeResponseDtoLang getByIdLang(Long id, String lang);

    List<PrizeResponseDto> getView();

    List<PrizeResponseDto> getAll();

    List<PrizeResponseDtoLang> getViewLang(String lang);

    PrizeResponseDto active(Long id);

    void delete(Long id);

}
