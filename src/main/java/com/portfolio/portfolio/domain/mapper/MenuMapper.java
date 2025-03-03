package com.portfolio.portfolio.domain.mapper;

import com.portfolio.portfolio.domain.dto.request.MenuRequestDto;
import com.portfolio.portfolio.domain.dto.response.MenuResponseDto;
import com.portfolio.portfolio.domain.dto.response.MenuResponseDtoLang;
import com.portfolio.portfolio.domain.model.Menu;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class MenuMapper implements IMapper<Menu, MenuResponseDto, MenuRequestDto> {

    public abstract MenuResponseDto entityToResponseDto(Menu menu);

    public abstract Menu requestDtoToEntity(MenuRequestDto menuRequestDto);

    @Named("entityToResponseDtoEs")
    @Mapping(source = "titleEs", target = "title")
    public abstract MenuResponseDtoLang entityToResponseDtoEs(Menu menu);

    @Named("entityToResponseDtoEn")
    @Mapping(source = "titleEn", target = "title")
    public abstract MenuResponseDtoLang entityToResponseDtoEn(Menu menu);

    public abstract List<MenuResponseDto> listEntityToListResponseDto (List<Menu> menus);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEs")
    public abstract List<MenuResponseDtoLang> listEntityToListResponseDtoEs(List<Menu> menus);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEn")
    public abstract List<MenuResponseDtoLang> listEntityToListResponseDtoEn(List<Menu> menus);

    public void updateEntityFromRequestDto(MenuRequestDto dto, Menu project) {
        if (dto.getTitleEs() != null) {
            project.setTitleEs(dto.getTitleEs());
        }
        if (dto.getTitleEn() != null) {
            project.setTitleEn(dto.getTitleEn());
        }
        if (dto.getRouter() != null) {
            project.setRouter(dto.getRouter());
        }
        if (dto.getOrderIndex() != null) {
            project.setOrderIndex(dto.getOrderIndex());
        }
    }

}