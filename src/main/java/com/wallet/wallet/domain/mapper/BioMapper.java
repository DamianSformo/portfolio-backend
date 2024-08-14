package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.BioRequestDto;
import com.wallet.wallet.domain.dto.response.BioResponseDto;
import com.wallet.wallet.domain.dto.response.BioResponseDtoEn;
import com.wallet.wallet.domain.dto.response.BioResponseDtoEs;
import com.wallet.wallet.domain.model.Bio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class BioMapper implements IMapper<Bio, BioResponseDto, BioRequestDto> {

    public abstract BioResponseDto entityToResponseDto(Bio bio);

    public abstract Bio requestDtoToEntity(BioRequestDto bioRequestDto);

    @Mapping(source = "textPhotoEs", target = "textPhoto")
    @Mapping(source = "bioEs", target = "bio")
    @Mapping(source = "bioShortEs", target = "bioShort")
    @Mapping(source = "statementEs", target = "statement")
    public abstract BioResponseDtoEs entityToResponseDtoEs(Bio bio);

    @Mapping(source = "textPhotoEn", target = "textPhoto")
    @Mapping(source = "bioEn", target = "bio")
    @Mapping(source = "bioShortEn", target = "bioShort")
    @Mapping(source = "statementEn", target = "statement")
    public abstract BioResponseDtoEn entityToResponseDtoEn(Bio bio);

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
        if (dto.getBioShortEs() != null) {
            bio.setBioShortEs(dto.getBioShortEs());
        }
        if (dto.getBioShortEn() != null) {
            bio.setBioShortEn(dto.getBioShortEn());
        }
        if (dto.getStatementEs() != null) {
            bio.setStatementEs(dto.getStatementEs());
        }
        if (dto.getStatementEn() != null) {
            bio.setStatementEn(dto.getStatementEn());
        }
    }
}