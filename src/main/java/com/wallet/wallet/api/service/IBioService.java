package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.BioRequestDto;
import com.wallet.wallet.domain.dto.response.BioResponseDto;
import com.wallet.wallet.domain.dto.response.BioResponseDtoLang;
import com.wallet.wallet.domain.dto.response.StatementResponseDto;
import com.wallet.wallet.domain.dto.response.StatementResponseDtoLang;
import com.wallet.wallet.domain.model.Bio;

public interface IBioService extends GenericServiceAPI<Bio, BioResponseDto, BioRequestDto, Long> {

    BioResponseDto save(BioRequestDto bioRequestDto);

    BioResponseDto getById(Long id);

    BioResponseDtoLang getByIdLang(Long id, String lang);

    StatementResponseDto getStatementById(Long id);

    StatementResponseDtoLang getStatementByIdLang(Long id, String lang);

    BioResponseDto update(BioRequestDto bioRequestDto, Long id);

    //List<ProjectResponseDto> getView();

    //List<ProjectResponseDto> getAll();

    //ProjectResponseDto active(Long id);

    //void delete(Long id);

    //ExpenseResponseDto update(ExpenseUpdateDto expenseUpdateDto, Long id, String token);

    //List<ExpenseResponseDto> getAllByUserId(String token);

    //ExpenseResponseDto getById(Long id, String token);

    //HomeResponseDto getForHome(String token);

    //List<ExpenseResponseDto> filter(String token, List<Long> categoriesId, Double amountMax, Double amountMin, LocalDate start, LocalDate end, String orderBy, String order);

    //Map<String, Double> groupByCategoryByUserId(String token);

    //StatisticsResponseDto getStatistics(String token);

    //void delete(Long id, String token);

}
