package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.MenuRequestDto;
import com.wallet.wallet.domain.dto.request.StudyRequestDto;
import com.wallet.wallet.domain.dto.response.MenuResponseDto;
import com.wallet.wallet.domain.dto.response.MenuResponseDtoLang;
import com.wallet.wallet.domain.dto.response.StudyResponseDto;
import com.wallet.wallet.domain.dto.response.StudyResponseDtoLang;
import com.wallet.wallet.domain.model.Menu;
import com.wallet.wallet.domain.model.Study;

import java.util.List;

public interface IMenuService extends GenericServiceAPI<Menu, MenuResponseDto, MenuRequestDto, Long> {

    MenuResponseDto save(MenuRequestDto studyRequestDto);

    MenuResponseDto update(MenuRequestDto studyRequestDto, Long id);

    MenuResponseDto active(Long id);

    MenuResponseDto getById(Long id);

    MenuResponseDtoLang getByIdLang(Long id, String lang);

    List<MenuResponseDto> getView();

    List<MenuResponseDtoLang> getViewLang(String lang);

    List<MenuResponseDto> getAll();

    void delete(Long id);
}
