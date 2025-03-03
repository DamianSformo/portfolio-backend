package com.portfolio.portfolio.domain.mapper;

import com.portfolio.portfolio.domain.dto.request.BioRequestDto;
import com.portfolio.portfolio.domain.dto.response.BioResponseDto;
import com.portfolio.portfolio.domain.dto.response.BioResponseDtoLang;
import com.portfolio.portfolio.domain.dto.response.StatementResponseDto;
import com.portfolio.portfolio.domain.dto.response.StatementResponseDtoLang;
import com.portfolio.portfolio.domain.model.Bio;
import com.portfolio.portfolio.domain.projection.BioProjection;
import com.portfolio.portfolio.domain.projection.StatementProjection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class BioMapper implements IMapper<Bio, BioResponseDto, BioRequestDto> {

    public abstract Bio requestDtoToEntity(BioRequestDto bioRequestDto);

    public abstract BioResponseDto entityToResponseDto(Bio bio);

    @Mapping(source = "textPhotoEs", target = "textPhoto")
    @Mapping(source = "bioEs", target = "bio")
    public abstract BioResponseDtoLang entityToResponseDtoEs(Bio bio);

    @Mapping(source = "textPhotoEn", target = "textPhoto")
    @Mapping(source = "bioEn", target = "bio")
    public abstract BioResponseDtoLang entityToResponseDtoEn(Bio bio);

    public abstract BioResponseDto bioProjectionToBioResponseDto(BioProjection bioProjection);

    @Mapping(source = "textPhotoEs", target = "textPhoto")
    @Mapping(source = "bioEs", target = "bio")
    public abstract BioResponseDtoLang bioProjectionToBioResponseDtoEs(BioProjection bioProjection);

    @Mapping(source = "textPhotoEn", target = "textPhoto")
    @Mapping(source = "bioEn", target = "bio")
    public abstract BioResponseDtoLang bioProjectionToBioResponseDtoEn(BioProjection bioProjection);

    public void updateEntityFromRequestDto(BioRequestDto dto, Bio bio) {
        if (dto.getName() != null) {
            bio.setName(dto.getName());
        }
        if (dto.getUrlPhoto() != null) {
            bio.setUrlPhoto(dto.getUrlPhoto());
        }
        if (dto.getTextPhotoEs() != null) {
            bio.setTextPhotoEs(dto.getTextPhotoEs());
        }
        if (dto.getTextPhotoEn() != null) {
            bio.setTextPhotoEn(dto.getTextPhotoEn());
        }
        if (dto.getBioEs() != null) {
            bio.setBioEs(dto.getBioEs());
        }
        if (dto.getBioEn() != null) {
            bio.setBioEn(dto.getBioEn());
        }
        if (dto.getStatementEs() != null) {
            bio.setStatementEs(dto.getStatementEs());
        }
        if (dto.getStatementEn() != null) {
            bio.setStatementEn(dto.getStatementEn());
        }
    }

    public abstract StatementResponseDto statementProjectionToStatementResponseDto(StatementProjection statementProjection);

    @Mapping(source = "statementEs", target = "statement")
    public abstract StatementResponseDtoLang statementProjectionToStatementResponseDtoEs(StatementProjection statementProjection);

    @Mapping(source = "statementEn", target = "statement")
    public abstract StatementResponseDtoLang statementProjectionToStatementResponseDtoEn(StatementProjection statementProjection);

}