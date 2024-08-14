package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.BioRequestDto;
import com.wallet.wallet.domain.dto.request.ProjectRequestDto;
import com.wallet.wallet.domain.dto.response.BioResponseDto;
import com.wallet.wallet.domain.dto.response.BioResponseDtoEn;
import com.wallet.wallet.domain.dto.response.BioResponseDtoEs;
import com.wallet.wallet.domain.dto.response.ProjectResponseDto;
import com.wallet.wallet.domain.model.Bio;
import com.wallet.wallet.domain.model.Project;

import java.util.List;

public interface IBioService extends GenericServiceAPI<Bio, BioResponseDto, BioRequestDto, Long> {

    BioResponseDto save(BioRequestDto bioRequestDto);

    BioResponseDto getById(Long id);

    BioResponseDtoEs getByIdEs(Long id);

    BioResponseDtoEn getByIdEn(Long id);

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
