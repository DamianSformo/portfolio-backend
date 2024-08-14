package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.ProjectRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.model.Project;

import java.util.List;

public interface IProjectService extends GenericServiceAPI<Project, ProjectResponseDto, ProjectRequestDto, Long> {

    ProjectResponseDto save(ProjectRequestDto projectRequestDto);

    ProjectResponseDto getById(Long id);

    ProjectResponseDtoLang getByIdLang(Long id, String lang);

    List<ProjectResponseDto> getView();

    List<ProjectResponseDtoLang> getViewLang(String lang);

    List<ProjectResponsePreviewDto> getPreviewLang(String lang);

    List<ProjectResponseDto> getAll();

    ProjectResponseDto update(ProjectRequestDto projectRequestDto, Long id);

    ProjectResponseDto active(Long id);

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
