package com.portfolio.portfolio.api.service.impl;

import com.portfolio.portfolio.api.service.IExhibitionService;
import com.portfolio.portfolio.api.service.generic.GenericServiceImpl;
import com.portfolio.portfolio.domain.dto.request.ExhibitionRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.enums.EExhibitionType;
import com.portfolio.portfolio.domain.enums.ERecordStatus;
import com.portfolio.portfolio.domain.mapper.ExhibitionMapper;
import com.portfolio.portfolio.domain.mapper.IMapper;
import com.portfolio.portfolio.domain.model.Exhibition;
import com.portfolio.portfolio.domain.repository.IExhibitionRepository;
import com.portfolio.portfolio.handler.exception.ResourceNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

import static com.portfolio.portfolio.domain.enums.EMessageCode.RESOURCE_NOT_FIND_BY_ID;

@Service
public class ExhibitionServiceImpl extends GenericServiceImpl<Exhibition, ExhibitionResponseDto, ExhibitionRequestDto, Long> implements IExhibitionService {

    private final ExhibitionMapper mapper;
    private final IExhibitionRepository repository;

    private final PrizeServiceImpl prizeService;

    private final MessageSource messenger;

    private final Map<String, Function<List<Exhibition>, List<ExhibitionResponseDtoLang>>> langMappers;

    private final Map<String, Function<Exhibition, ExhibitionResponseDtoLang>> singleLangMappers;

    public ExhibitionServiceImpl(ExhibitionMapper mapper, IExhibitionRepository repository, PrizeServiceImpl prizeService, MessageSource messenger) {
        this.mapper = mapper;
        this.repository = repository;
        this.prizeService = prizeService;
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
    public ExhibitionResponseDto save(ExhibitionRequestDto exhibitionRequestDto) {
        return super.save(exhibitionRequestDto);
    }

    @Override
    public ExhibitionResponseDto getById(Long id) {
        ExhibitionResponseDto exhibitionResponseDto = super.getById(id);
        return exhibitionResponseDto;
    }

    @Override
    public ExhibitionResponseDtoLang getByIdLang(Long id, String lang) {
        Exhibition existing = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));

        Function<Exhibition, ExhibitionResponseDtoLang> mapperFunction =
                singleLangMappers.getOrDefault(lang, mapper::entityToResponseDtoEs);

        return mapperFunction.apply(existing);
    }

    @Override
    public ExhibitionResponseDto update(ExhibitionRequestDto exhibitionRequestDto, Long id) {
        Exhibition existingProject = repository.findById(id).orElseThrow(() ->
              new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                       new Object[] {id}, Locale.getDefault())));

        mapper.updateEntityFromRequestDto(exhibitionRequestDto, existingProject);
        repository.save(existingProject);

        return getById(id);
    }

    @Override
    public List<ExhibitionResponseDto> getView() {
        List<ExhibitionResponseDto> listExhibitionResponseDto = mapper.listEntityToListResponseDto(repository.findByRecordStatusOrderByYearDesc(ERecordStatus.A));
        return listExhibitionResponseDto;
    }

    @Override
    public List<ExhibitionResponseDtoLang> getViewLang(String lang) {
        return langMappers.getOrDefault(lang, mapper::listEntityToListResponseDtoEs)
                .apply(repository.findByRecordStatusOrderByYearDesc(ERecordStatus.A));
    }

    @Override
    public List<ExhibitionResponseDto> getAll() {
        return mapper.listEntityToListResponseDto(repository.findAll());
    }

    @Override
    public ExhibitionCompleteResponseDtoLang getComplete(String lang) {
        ExhibitionCompleteResponseDtoLang response = new ExhibitionCompleteResponseDtoLang();
        response.setExhibitionGroup(getExhibitionsByTypeAndLang(EExhibitionType.GROUP, lang));
        response.setExhibitionIndividual(getExhibitionsByTypeAndLang(EExhibitionType.INDIVIDUAL, lang));
        response.setPrizes(getPrizesByLang(lang));
        return response;
    }

    private List<ExhibitionResponseDtoLang> getExhibitionsByTypeAndLang(EExhibitionType type, String lang) {
        List<Exhibition> exhibitions = repository.findByTypeAndRecordStatusOrderByYearDesc(type, ERecordStatus.A);
        return langMappers.getOrDefault(lang, mapper::listEntityToListResponseDtoEs).apply(exhibitions);
    }

    private List<PrizeResponseDtoLang> getPrizesByLang(String lang) {
        return prizeService.getViewLang(lang);
    }

    @Override
    public ExhibitionResponseDto activate(Long id) {
        Exhibition existing = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));

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
    public JpaRepository<Exhibition, Long> getRepository() {
        return repository;
    }

    @Override
    public IMapper<Exhibition, ExhibitionResponseDto, ExhibitionRequestDto> getMapper() {
        return mapper;
    }

    @Override
    public MessageSource getMessenger() {
        return messenger;
    }

}
