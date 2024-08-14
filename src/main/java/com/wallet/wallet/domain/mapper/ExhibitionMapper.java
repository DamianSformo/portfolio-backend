package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.ExhibitionRequestDto;
import com.wallet.wallet.domain.dto.request.StudyRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.model.Exhibition;
import com.wallet.wallet.domain.model.Project;
import com.wallet.wallet.domain.model.Study;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ExhibitionMapper implements IMapper<Exhibition, ExhibitionResponseDto, ExhibitionRequestDto> {

    public abstract ExhibitionResponseDto entityToResponseDto(Exhibition exhibition);

    public abstract Exhibition requestDtoToEntity(ExhibitionResponseDto exhibitionResponseDto);

    @Named("entityToResponseDtoEs")
    @Mapping(source = "titleEs", target = "title")
    @Mapping(source = "textEs", target = "text")
    public abstract ExhibitionResponseDtoLang entityToResponseDtoEs(Exhibition exhibition);

    @Named("entityToResponseDtoEn")
    @Mapping(source = "titleEn", target = "title")
    @Mapping(source = "textEn", target = "text")
    public abstract ExhibitionResponseDtoLang entityToResponseDtoEn(Exhibition exhibition);

    public abstract List<ExhibitionResponseDto> listEntityToListDto (List<Exhibition> listExhibition);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEs")
    public abstract List<ExhibitionResponseDtoLang> listEntityToListProjectDtoEs(List<Exhibition> listExhibition);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEn")
    public abstract List<ExhibitionResponseDtoLang> listEntityToListProjectDtoEn(List<Exhibition> listExhibition);

}