package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.ProjectRequestDto;
import com.wallet.wallet.domain.dto.request.StudyRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.model.Project;
import com.wallet.wallet.domain.model.Study;

import java.util.List;

public interface IStudyService extends GenericServiceAPI<Study, StudyResponseDto, StudyRequestDto, Long> {

    StudyResponseDto save(StudyRequestDto studyRequestDto);

    StudyResponseDto getById(Long id);

    StudyResponseDtoLang getByIdEs(Long id);

    StudyResponseDtoLang getByIdEn(Long id);

    List<StudyResponseDto> getView();

    List<StudyResponseDtoLang> getViewLang(String lang);

    List<StudyResponseDto> getAll();

    //StudyResponseDto update(StudyRequestDto studyRequestDto, Long id);

    StudyResponseDto active(Long id);

    void delete(Long id);

    //ExpenseResponseDto update(ExpenseUpdateDto expenseUpdateDto, Long id, String token);

    //List<ExpenseResponseDto> getAllByUserId(String token);

    //ExpenseResponseDto getById(Long id, String token);

    //HomeResponseDto getForHome(String token);

    //List<ExpenseResponseDto> filter(String token, List<Long> categoriesId, Double amountMax, Double amountMin, LocalDate start, LocalDate end, String orderBy, String order);

    //Map<String, Double> groupByCategoryByUserId(String token);

    //StatisticsResponseDto getStatistics(String token);

    //void delete(Long id, String token);

}
