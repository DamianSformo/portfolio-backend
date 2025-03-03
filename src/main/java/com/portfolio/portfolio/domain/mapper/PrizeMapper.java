package com.portfolio.portfolio.domain.mapper;

import com.portfolio.portfolio.domain.dto.request.PrizeRequestDto;
import com.portfolio.portfolio.domain.dto.response.PrizeResponseDto;
import com.portfolio.portfolio.domain.dto.response.PrizeResponseDtoLang;
import com.portfolio.portfolio.domain.model.Prize;
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

    public abstract List<PrizeResponseDto> listEntityToListResponseDto (List<Prize> prizes);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEs")
    public abstract List<PrizeResponseDtoLang> listEntityToListResponseDtoEs(List<Prize> prizes);

    @IterableMapping(qualifiedByName = "entityToResponseDtoEn")
    public abstract List<PrizeResponseDtoLang> listEntityToListResponseDtoEn(List<Prize> prizes);

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