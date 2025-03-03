package com.portfolio.portfolio.api.service;

import com.portfolio.portfolio.api.service.generic.GenericServiceAPI;
import com.portfolio.portfolio.domain.dto.request.BioRequestDto;
import com.portfolio.portfolio.domain.dto.response.BioResponseDto;
import com.portfolio.portfolio.domain.dto.response.BioResponseDtoLang;
import com.portfolio.portfolio.domain.dto.response.StatementResponseDto;
import com.portfolio.portfolio.domain.dto.response.StatementResponseDtoLang;
import com.portfolio.portfolio.domain.model.Bio;

public interface IBioService extends GenericServiceAPI<Bio, BioResponseDto, BioRequestDto, Long> {

    BioResponseDto save(BioRequestDto bioRequestDto);

    BioResponseDto getById(Long id);

    BioResponseDtoLang getByIdLang(Long id, String lang);

    BioResponseDto getByName(String name);

    BioResponseDtoLang getByNameLang(String name, String lang);

    BioResponseDto update(BioRequestDto bioRequestDto, Long id);

    StatementResponseDto getStatementById(Long id);

    StatementResponseDtoLang getStatementByIdLang(Long id, String lang);

    void delete(Long id);
}
