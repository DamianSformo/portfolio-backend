package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.IncomeRequestDto;
import com.wallet.wallet.domain.dto.request.IncomeUpdateDto;
import com.wallet.wallet.domain.dto.response.IncomeResponseDto;
import com.wallet.wallet.domain.dto.response.MoveResponseDto;
import com.wallet.wallet.domain.model.Income;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class IncomeMapper implements IMapper<Income, IncomeResponseDto, IncomeRequestDto>{

    @Mapping(source = "currency.codeCurrency", target = "currencyCode")
    public abstract IncomeResponseDto entityToResponseDto(Income income);

    @Mapping(source = "currencyId", target = "currency.id")
    @Mapping(source = "userId", target = "user.id")
    public abstract Income requestDtoToEntity(IncomeRequestDto incomeRequestDto);

    public abstract Income updateToEntity(IncomeUpdateDto incomeUpdateDto);

    public abstract List<IncomeResponseDto> listEntityToListResponseDto(List<Income> incomes);

    @Mapping(source = "type", target = "categoryName")
    @Mapping(source = "currency.codeCurrency", target = "currencyCode")
    public abstract MoveResponseDto entityToMoveResponseDto(Income income);

}
