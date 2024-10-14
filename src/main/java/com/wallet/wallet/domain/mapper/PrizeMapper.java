package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.ExhibitionRequestDto;
import com.wallet.wallet.domain.dto.request.PrizeRequestDto;
import com.wallet.wallet.domain.dto.request.ProjectRequestDto;
import com.wallet.wallet.domain.dto.response.ExhibitionResponseDto;
import com.wallet.wallet.domain.dto.response.ExhibitionResponseDtoLang;
import com.wallet.wallet.domain.dto.response.PrizeResponseDto;
import com.wallet.wallet.domain.dto.response.PrizeResponseDtoLang;
import com.wallet.wallet.domain.model.Exhibition;
import com.wallet.wallet.domain.model.Prize;
import com.wallet.wallet.domain.model.Project;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PrizeMapper implements IMapper<Prize, PrizeResponseDto, PrizeRequestDto> {

    public abstract PrizeResponseDto entityToResponseDto(Prize prize);

    public abstract Prize requestDtoToEntity(PrizeResponseDto prizeResponseDto);

    @Named("entityToResponseDtoEs")
    @Mapping(source = "titleEs", target = "title")
    public abstract PrizeResponseDtoLang entityToResponseDtoEs(Prize prize);

    @Named("entityToResponseDtoEn")
    @Mapping(source = "titleEn", target = "title")
    public abstract PrizeResponseDtoLang entityToResponseDtoEn(Prize prize);

    public abstract List<PrizeResponseDto> listEntityToListDto (List<Prize> prizes);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEs")
    public abstract List<PrizeResponseDtoLang> listEntityToListProjectDtoEs(List<Prize> prizes);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEn")
    public abstract List<PrizeResponseDtoLang> listEntityToListProjectDtoEn(List<Prize> prizes);

    public void updateEntityFromRequestDto(PrizeRequestDto prizeRequestDto, Prize prize) {
        if (prizeRequestDto.getYear() != null) {
            prize.setYear(prizeRequestDto.getYear());
        }
        if (prizeRequestDto.getTitleEs() != null) {
            prize.setTitleEs(prizeRequestDto.getTitleEs());
        }
        if (prizeRequestDto.getTitleEn() != null) {
            prize.setTitleEn(prizeRequestDto.getTitleEn());
        }
        if (prizeRequestDto.getOrderIndex() != null) {
            prize.setOrderIndex(prizeRequestDto.getOrderIndex());
        }
    }

}