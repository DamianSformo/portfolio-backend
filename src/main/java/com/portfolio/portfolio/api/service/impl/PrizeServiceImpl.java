package com.portfolio.portfolio.api.service.impl;

import com.portfolio.portfolio.api.service.IPrizeService;
import com.portfolio.portfolio.api.service.generic.GenericServiceImpl;
import com.portfolio.portfolio.domain.dto.request.PrizeRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.enums.ERecordStatus;
import com.portfolio.portfolio.domain.mapper.IMapper;
import com.portfolio.portfolio.domain.mapper.PrizeMapper;
import com.portfolio.portfolio.domain.model.Prize;
import com.portfolio.portfolio.domain.repository.IPrizeRepository;
import com.portfolio.portfolio.handler.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

import static com.portfolio.portfolio.domain.enums.EMessageCode.RESOURCE_NOT_FIND_BY_ID;
import static com.portfolio.portfolio.domain.enums.EMessageCode.RESOURCE_NOT_FOUND_BY_ID;

@Service
public class PrizeServiceImpl extends GenericServiceImpl<Prize, PrizeResponseDto, PrizeRequestDto, Long> implements IPrizeService {

    private final PrizeMapper mapper;
    private final IPrizeRepository repository;

    private final MessageSource messenger;

    private final Map<String, Function<List<Prize>, List<PrizeResponseDtoLang>>> langMappers;

    private final Map<String, Function<Prize, PrizeResponseDtoLang>> singleLangMappers;

    public PrizeServiceImpl(PrizeMapper mapper, IPrizeRepository repository, MessageSource messenger) {
        this.mapper = mapper;
        this.repository = repository;
        this.messenger = messenger;
        this.langMappers = Map.of(
                "es", mapper::listEntityToListResponseDtoEs,
                "en", mapper::listEntityToListResponseDtoEn
        );
        this.singleLangMappers = Map.of(
                "es", mapper::entityToResponseDtoEs,
                "en", mapper::entityToResponseDtoEn
        );
    }

    @Override
    public PrizeResponseDto save(PrizeRequestDto prizeRequestDto) {
        return super.save(prizeRequestDto);
    }

    @Override
    public PrizeResponseDto getById(Long id) {
        return super.getById(id);
    }

    @Override
    public PrizeResponseDtoLang getByIdLang(Long id, String lang) {
        Prize existing = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                        new Object[] {"Prize", id}, Locale.getDefault())));

        Function<Prize, PrizeResponseDtoLang> mapperFunction =
                singleLangMappers.getOrDefault(lang, mapper::entityToResponseDtoEs);

        return mapperFunction.apply(existing);
    }

    @Override
    public List<PrizeResponseDto> getView() {
        return mapper.listEntityToListResponseDto(repository.findByRecordStatusOrderByOrderIndexAscYearDesc(ERecordStatus.A));
    }

    @Override
    public List<PrizeResponseDtoLang> getViewLang(String lang) {
        return langMappers.getOrDefault(lang, mapper::listEntityToListResponseDtoEs)
                .apply(repository.findByRecordStatusOrderByOrderIndexAscYearDesc(ERecordStatus.A));
    }

    @Override
    public List<PrizeResponseDto> getAll() {
        return mapper.listEntityToListResponseDto(repository.findAll());
    }

    @Override
    public PrizeResponseDto update(PrizeRequestDto prizeRequestDto, Long id) {
        Prize existing = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {"Prize", id}, Locale.getDefault())));

        mapper.updateEntityFromRequestDto(prizeRequestDto, existing);
        repository.save(existing);

        return getById(id);
    }

    @Override
    public PrizeResponseDto activate(Long id) {
        Prize existing = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {"Prize", id}, Locale.getDefault())));

        if (ERecordStatus.A.equals(existing.getRecordStatus())) {
            existing.setRecordStatus(ERecordStatus.D);
        } else {
            existing.setRecordStatus(ERecordStatus.A);
        }

        repository.save(existing);

        return getById(id);
    }

    @Override
    public void delete(Long id){
        super.delete(id);
    }

    @Override
    public JpaRepository<Prize, Long> getRepository() {
        return repository;
    }

    @Override
    public IMapper<Prize, PrizeResponseDto, PrizeRequestDto> getMapper() {
        return mapper;
    }

    @Override
    public MessageSource getMessenger() {
        return messenger;
    }

}
