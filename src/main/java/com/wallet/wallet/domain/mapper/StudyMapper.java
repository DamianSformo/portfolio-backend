package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.StudyRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.model.Study;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StudyMapper implements IMapper<Study, StudyResponseDto, StudyRequestDto> {

    public abstract StudyResponseDto entityToResponseDto(Study study);

    public abstract Study requestDtoToEntity(StudyRequestDto studyRequestDto);

    @Named("entityToResponseDtoEs")
    @Mapping(source = "descriptionEs", target = "description")
    public abstract StudyResponseDtoLang entityToResponseDtoEs(Study study);

    @Named("entityToResponseDtoEn")
    @Mapping(source = "descriptionEn", target = "description")
    public abstract StudyResponseDtoLang entityToResponseDtoEn(Study study);

    public abstract List<StudyResponseDto> listEntityToListStudyDto (List<Study> studies);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEs")
    public abstract List<StudyResponseDtoLang> listEntityToListStudyDtoEs(List<Study> studies);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEn")
    public abstract List<StudyResponseDtoLang> listEntityToListStudyDtoEn(List<Study> studies);

}