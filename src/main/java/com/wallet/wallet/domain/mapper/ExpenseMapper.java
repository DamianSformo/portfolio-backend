package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.ExpenseRequestDto;
import com.wallet.wallet.domain.dto.request.ExpenseUpdateDto;
import com.wallet.wallet.domain.dto.response.ExpenseResponseDto;
import com.wallet.wallet.domain.dto.response.MoveResponseDto;
import com.wallet.wallet.domain.model.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ExpenseMapper implements IMapper<Expense, ExpenseResponseDto, ExpenseRequestDto> {

    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "category.icon", target = "categoryIcon")
    @Mapping(source = "category.colorCode", target = "categoryColorCode")
    @Mapping(source = "currency.codeCurrency", target = "currencyCode")
    public abstract ExpenseResponseDto entityToResponseDto(Expense expense);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "currencyId", target = "currency.id")
    @Mapping(source = "userId", target = "user.id")
    public abstract Expense requestDtoToEntity(ExpenseRequestDto expenseRequestDto);

    @Mapping(source = "categoryId", target = "category.id")
    public abstract Expense updateToEntity(ExpenseUpdateDto expenseUpdateDto);

    public abstract List<ExpenseResponseDto> listEntityToListResponseDto(List<Expense> expenses);

    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "category.icon", target = "categoryIcon")
    @Mapping(source = "category.colorCode", target = "categoryColorCode")
    @Mapping(source = "currency.codeCurrency", target = "currencyCode")
    @Mapping(constant = "gasto", target = "type")
    public abstract MoveResponseDto entityToMoveResponseDto(Expense expense);

}