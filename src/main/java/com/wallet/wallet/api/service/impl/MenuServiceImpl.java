package com.wallet.wallet.api.service.impl;

import com.wallet.wallet.api.service.IMenuService;
import com.wallet.wallet.api.service.generic.GenericServiceImpl;
import com.wallet.wallet.domain.dto.request.MenuRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.enums.ERecordStatus;
import com.wallet.wallet.domain.mapper.IMapper;
import com.wallet.wallet.domain.mapper.MenuMapper;
import com.wallet.wallet.domain.model.Menu;
import com.wallet.wallet.domain.repository.IMenuRepository;
import com.wallet.wallet.handler.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.wallet.wallet.domain.enums.EMessageCode.*;

@AllArgsConstructor
@Service
public class MenuServiceImpl extends GenericServiceImpl<Menu, MenuResponseDto, MenuRequestDto, Long> implements IMenuService {

    private final MenuMapper mapper;
    private final IMenuRepository repository;

    private final MessageSource messenger;

    @Override
    public MenuResponseDto save(MenuRequestDto menuRequestDto) {
        return super.save(menuRequestDto);
    }

    @Override
    public MenuResponseDto update(MenuRequestDto menuRequestDto, Long id) {
       Menu existing = repository.findById(id).orElseThrow(() ->
               new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                       new Object[] {"Menu",id}, Locale.getDefault())));

        mapper.updateEntityFromRequestDto(menuRequestDto, existing);
        repository.save(existing);

        return getById(id);
    }

    @Override
    public MenuResponseDto active(Long id) {
        Menu existingMenu = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                        new Object[] {"Menu", id}, Locale.getDefault())));

        if (ERecordStatus.A.equals(existingMenu.getRecordStatus())) {
            existingMenu.setRecordStatus(ERecordStatus.D);
        } else {
            existingMenu.setRecordStatus(ERecordStatus.A);
        }

        repository.save(existingMenu);

        return getById(id);
    }

    @Override
    public MenuResponseDto getById(Long id) {
        MenuResponseDto menuResponseDto = super.getById(id);
        return menuResponseDto;
    }

    @Override
    public MenuResponseDtoLang getByIdLang(Long id, String lang) {
        Menu existing = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                        new Object[] {"Menu", id}, Locale.getDefault())));

        MenuResponseDtoLang menuResponseDtoLang = new MenuResponseDtoLang();
        switch (lang) {
            case "es" -> menuResponseDtoLang = mapper.entityToResponseDtoEs(existing);
            case "en" -> menuResponseDtoLang = mapper.entityToResponseDtoEn(existing);
        };

        return menuResponseDtoLang;
    }

    @Override
    public List<MenuResponseDto> getView() {
        List<MenuResponseDto> menuResponseDtos = mapper.listEntityToListDto(repository.getView());
        return menuResponseDtos;
    }

    @Override
    public List<MenuResponseDtoLang> getViewLang(String lang) {
        List<Menu> listMenu = repository.getView();

        List<MenuResponseDtoLang> listMenuResponseDtoLang = new ArrayList<>();
        switch (lang) {
            case "es" -> listMenuResponseDtoLang = mapper.listEntityToListDtoEs(listMenu);
            case "en" -> listMenuResponseDtoLang = mapper.listEntityToListDtoEn(listMenu);
        };

        return listMenuResponseDtoLang;
    }

    @Override
    public List<MenuResponseDto> getAll() {
        return mapper.listEntityToListDto(repository.getAll());
    }

    @Override
    public void delete(Long id){
        super.delete(id);
    }

    @Override
    public JpaRepository<Menu, Long> getRepository() {
        return repository;
    }

    @Override
    public IMapper<Menu, MenuResponseDto, MenuRequestDto> getMapper() {
        return mapper;
    }

    @Override
    public MessageSource getMessenger() {
        return messenger;
    }

}
