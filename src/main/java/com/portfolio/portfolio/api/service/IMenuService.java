package com.portfolio.portfolio.api.service;

import com.portfolio.portfolio.api.service.generic.GenericServiceAPI;
import com.portfolio.portfolio.domain.dto.request.MenuRequestDto;
import com.portfolio.portfolio.domain.dto.response.MenuResponseDto;
import com.portfolio.portfolio.domain.dto.response.MenuResponseDtoLang;
import com.portfolio.portfolio.domain.model.Menu;

import java.util.List;

public interface IMenuService extends GenericServiceAPI<Menu, MenuResponseDto, MenuRequestDto, Long> {

    MenuResponseDto save(MenuRequestDto studyRequestDto);

    MenuResponseDto getById(Long id);

    MenuResponseDtoLang getByIdLang(Long id, String lang);

    List<MenuResponseDto> getView();

    List<MenuResponseDtoLang> getViewLang(String lang);

    List<MenuResponseDto> getAll();

    MenuResponseDto update(MenuRequestDto studyRequestDto, Long id);

    MenuResponseDto active(Long id);

    void delete(Long id);
}
