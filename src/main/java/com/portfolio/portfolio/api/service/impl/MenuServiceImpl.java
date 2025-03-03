package com.portfolio.portfolio.api.service.impl;

import com.portfolio.portfolio.api.service.IMenuService;
import com.portfolio.portfolio.api.service.generic.GenericServiceImpl;
import com.portfolio.portfolio.domain.dto.request.MenuRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.enums.ERecordStatus;
import com.portfolio.portfolio.domain.mapper.IMapper;
import com.portfolio.portfolio.domain.mapper.MenuMapper;
import com.portfolio.portfolio.domain.model.Menu;
import com.portfolio.portfolio.domain.repository.IMenuRepository;
import com.portfolio.portfolio.handler.exception.ResourceNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

import static com.portfolio.portfolio.domain.enums.EMessageCode.*;

@Service
public class MenuServiceImpl extends GenericServiceImpl<Menu, MenuResponseDto, MenuRequestDto, Long> implements IMenuService {

    private final MenuMapper mapper;
    private final IMenuRepository repository;

    private final MessageSource messenger;

    private final Map<String, Function<List<Menu>, List<MenuResponseDtoLang>>> langMappers;

    private final Map<String, Function<Menu, MenuResponseDtoLang>> singleLangMappers;

    public MenuServiceImpl(MenuMapper mapper, IMenuRepository repository, MessageSource messenger) {
        this.mapper = mapper;
        this.repository = repository;
        this.messenger = messenger;
        this.langMappers = Map.of(
                "es", mapper::listEntityToListResponseDtoEs,
                "en", mapper::listEntityToListResponseDtoEn
        );
        this.singleLangMappers = Map.of(
                "es", mapper::entityToResponseDtoEs,
                "en", mapper::entityToResponseDtoEn
        );
    }

    @Override
    public MenuResponseDto save(MenuRequestDto menuRequestDto) {
        return super.save(menuRequestDto);
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

        Function<Menu, MenuResponseDtoLang> mapperFunction =
                singleLangMappers.getOrDefault(lang, mapper::entityToResponseDtoEs);

        return mapperFunction.apply(existing);
    }

    @Override
    public List<MenuResponseDto> getView() {
        List<MenuResponseDto> listMenusResponseDto = mapper.listEntityToListResponseDto(repository.findByRecordStatusOrderByOrderIndexDesc(ERecordStatus.A));
        return listMenusResponseDto;
    }

    @Override
    public List<MenuResponseDtoLang> getViewLang(String lang) {
        return langMappers.getOrDefault(lang, mapper::listEntityToListResponseDtoEs)
                .apply(repository.findByRecordStatusOrderByOrderIndexDesc(ERecordStatus.A));
    }

    @Override
    public List<MenuResponseDto> getAll() {
        return mapper.listEntityToListResponseDto(repository.findAll());
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
