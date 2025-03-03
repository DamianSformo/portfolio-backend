package com.portfolio.portfolio.api.service.impl;

import com.portfolio.portfolio.api.service.IStudyService;
import com.portfolio.portfolio.api.service.generic.GenericServiceImpl;
import com.portfolio.portfolio.domain.dto.request.StudyRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.enums.ERecordStatus;
import com.portfolio.portfolio.domain.mapper.IMapper;
import com.portfolio.portfolio.domain.mapper.StudyMapper;
import com.portfolio.portfolio.domain.model.Study;
import com.portfolio.portfolio.domain.repository.IStudyRepository;
import com.portfolio.portfolio.handler.exception.ResourceNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

import static com.portfolio.portfolio.domain.enums.EMessageCode.RESOURCE_NOT_FOUND_BY_ID;

@Service
public class StudyServiceImpl extends GenericServiceImpl<Study, StudyResponseDto, StudyRequestDto, Long> implements IStudyService {

    private final StudyMapper mapper;
    private final IStudyRepository repository;

    private final MessageSource messenger;

    private final Map<String, Function<List<Study>, List<StudyResponseDtoLang>>> langMappers;

    private final Map<String, Function<Study, StudyResponseDtoLang>> singleLangMappers;

    public StudyServiceImpl(StudyMapper mapper, IStudyRepository repository, MessageSource messenger) {
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
    public StudyResponseDto save(StudyRequestDto studyRequestDto) {
        return super.save(studyRequestDto);
    }

    @Override
    public StudyResponseDto getById(Long id) {
        return super.getById(id);
    }

    @Override
    public StudyResponseDtoLang getByIdLang(Long id, String lang) {
        Study existing = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                        new Object[] {"Study", id}, Locale.getDefault())));

        Function<Study, StudyResponseDtoLang> mapperFunction =
                singleLangMappers.getOrDefault(lang, mapper::entityToResponseDtoEs);

        return mapperFunction.apply(existing);
    }

    @Override
    public List<StudyResponseDto> getView() {
        return mapper.listEntityToListResponseDto(repository.findByRecordStatusOrderByStartYearDesc(ERecordStatus.A));
    }

    @Override
    public List<StudyResponseDtoLang> getViewLang(String lang) {
        return langMappers.getOrDefault(lang, mapper::listEntityToListResponseDtoEs)
                .apply(repository.findByRecordStatusOrderByStartYearDesc(ERecordStatus.A));
    }

    @Override
    public List<StudyResponseDto> getAll() {
        return mapper.listEntityToListResponseDto(repository.findAll());
    }

    @Override
    public StudyResponseDto update(StudyRequestDto studyRequestDto, Long id) {
        Study existing = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                        new Object[] {"Study", id}, Locale.getDefault())));

        mapper.updateEntityFromRequestDto(studyRequestDto, existing);
        repository.save(existing);

        return getById(id);
    }

    @Override
    public StudyResponseDto activate(Long id) {
        Study existing = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                        new Object[] {"Study", id}, Locale.getDefault())));

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
    public JpaRepository<Study, Long> getRepository() {
        return repository;
    }

    @Override
    public IMapper<Study, StudyResponseDto, StudyRequestDto> getMapper() {
        return mapper;
    }

    @Override
    public MessageSource getMessenger() {
        return messenger;
    }

}
