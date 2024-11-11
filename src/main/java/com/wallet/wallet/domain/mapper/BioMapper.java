package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.BioRequestDto;
import com.wallet.wallet.domain.dto.response.BioResponseDto;
import com.wallet.wallet.domain.dto.response.BioResponseDtoLang;
import com.wallet.wallet.domain.dto.response.StatementResponseDto;
import com.wallet.wallet.domain.dto.response.StatementResponseDtoLang;
import com.wallet.wallet.domain.model.Bio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import javax.persistence.Tuple;

@Mapper(componentModel = "spring")
public abstract class BioMapper implements IMapper<Bio, BioResponseDto, BioRequestDto> {

    public abstract BioResponseDto entityToResponseDto(Bio bio);

    public abstract Bio requestDtoToEntity(BioRequestDto bioRequestDto);

    @Named("statementEntityToResponseDtoEs")
    @Mapping(source = "statementEs", target = "statement")
    public abstract StatementResponseDtoLang statementEntityToResponseDtoEs(StatementResponseDto statementResponseDto);

    @Named("statementEntityToResponseDtoEn")
    @Mapping(source = "statementEn", target = "statement")
    public abstract StatementResponseDtoLang statementEntityToResponseDtoEn(StatementResponseDto statementResponseDto);

    @Named("statementEntityToResponseDtoEs")
    @Mapping(source = "textPhotoEs", target = "textPhoto")
    @Mapping(source = "bioEs", target = "bio")
    public abstract BioResponseDtoLang entityToResponseDtoEs(Bio bio);

    @Named("entityToResponseDtoEn")
    @Mapping(source = "textPhotoEn", target = "textPhoto")
    @Mapping(source = "bioEn", target = "bio")
    public abstract BioResponseDtoLang entityToResponseDtoEn(Bio bio);

    public void updateEntityFromRequestDto(BioRequestDto dto, Bio bio) {
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
}