package com.portfolio.portfolio.domain.mapper;

import com.portfolio.portfolio.domain.dto.request.StudyRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.model.Study;
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

    public abstract List<StudyResponseDto> listEntityToListResponseDto (List<Study> studies);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEs")
    public abstract List<StudyResponseDtoLang> listEntityToListResponseDtoEs(List<Study> studies);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEn")
    public abstract List<StudyResponseDtoLang> listEntityToListResponseDtoEn(List<Study> studies);

    public void updateEntityFromRequestDto(StudyRequestDto studyRequestDto, Study study) {
        if (studyRequestDto.getStartYear() != null) {
            study.setStartYear(studyRequestDto.getStartYear());
        }
        if (studyRequestDto.getEndYear() != null) {
            study.setStartYear(studyRequestDto.getEndYear());
        }
        if (studyRequestDto.getDescriptionEs() != null) {
            study.setDescriptionEs(studyRequestDto.getDescriptionEs());
        }
        if (studyRequestDto.getDescriptionEn() != null) {
            study.setDescriptionEn(studyRequestDto.getDescriptionEn());
        }
        if (studyRequestDto.getSite() != null) {
            study.setSite(studyRequestDto.getSite());
        }
    }
}