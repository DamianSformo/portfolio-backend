package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.ExhibitionRequestDto;
import com.wallet.wallet.domain.dto.request.StudyRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.model.Exhibition;
import com.wallet.wallet.domain.model.Study;

import java.util.List;

public interface IExhibitionService extends GenericServiceAPI<Exhibition, ExhibitionResponseDto, ExhibitionRequestDto, Long> {

    ExhibitionResponseDto save(ExhibitionRequestDto exhibitionRequestDto);

    ExhibitionResponseDto getById(Long id);

    //ExhibitionResponseDto getByIdLang(Long id, String lang);

    List<ExhibitionResponseDto> getView();

    List<ExhibitionResponseDto> getAll();

    List<ExhibitionResponseDtoLang> getViewLang(String lang);

    ExhibitionCompleteResponseDtoLang getComplete(String lang);

    //ExhibitionResponseDto update(ExhibitionRequestDto exhibitionRequestDto, Long id);

    ExhibitionResponseDto active(Long id);

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
