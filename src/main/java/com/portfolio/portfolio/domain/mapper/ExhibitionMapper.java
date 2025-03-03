package com.portfolio.portfolio.domain.mapper;

import com.portfolio.portfolio.domain.dto.request.ExhibitionRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.model.Exhibition;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ExhibitionMapper implements IMapper<Exhibition, ExhibitionResponseDto, ExhibitionRequestDto> {

    public abstract ExhibitionResponseDto entityToResponseDto(Exhibition exhibition);

    public abstract Exhibition requestDtoToEntity(ExhibitionRequestDto exhibitionRequestDto);

    @Named("entityToResponseDtoEs")
    @Mapping(source = "titleEs", target = "title")
    @Mapping(source = "textEs", target = "text")
    public abstract ExhibitionResponseDtoLang entityToResponseDtoEs(Exhibition exhibition);

    @Named("entityToResponseDtoEn")
    @Mapping(source = "titleEn", target = "title")
    @Mapping(source = "textEn", target = "text")
    public abstract ExhibitionResponseDtoLang entityToResponseDtoEn(Exhibition exhibition);

    public abstract List<ExhibitionResponseDto> listEntityToListResponseDto (List<Exhibition> listExhibition);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEs")
    public abstract List<ExhibitionResponseDtoLang> listEntityToListResponseDtoEs(List<Exhibition> listExhibition);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEn")
    public abstract List<ExhibitionResponseDtoLang> listEntityToListResponseDtoEn(List<Exhibition> listExhibition);

    public void updateEntityFromRequestDto(ExhibitionRequestDto exhibitionRequestDto, Exhibition exhibition) {
        if (exhibitionRequestDto.getType() != null) {
            exhibition.setType(exhibitionRequestDto.getType());
        }
        if (exhibitionRequestDto.getYear() != null) {
            exhibition.setYear(exhibitionRequestDto.getYear());
        }
        if (exhibitionRequestDto.getTitleEs() != null) {
            exhibition.setTitleEs(exhibitionRequestDto.getTitleEs());
        }
        if (exhibitionRequestDto.getTitleEn() != null) {
            exhibition.setTitleEn(exhibitionRequestDto.getTitleEn());
        }
        if (exhibitionRequestDto.getTextEs() != null) {
            exhibition.setTextEs(exhibitionRequestDto.getTextEs());
        }
        if (exhibitionRequestDto.getTextEn() != null) {
            exhibition.setTextEn(exhibitionRequestDto.getTextEn());
        }
    }
}