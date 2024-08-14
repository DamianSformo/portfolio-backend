package com.wallet.wallet.api.service.impl;

import com.wallet.wallet.api.service.IStudyService;
import com.wallet.wallet.api.service.generic.GenericServiceImpl;
import com.wallet.wallet.domain.dto.request.StudyRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.enums.ERecordStatus;
import com.wallet.wallet.domain.mapper.IMapper;
import com.wallet.wallet.domain.mapper.StudyMapper;
import com.wallet.wallet.domain.model.Bio;
import com.wallet.wallet.domain.model.Project;
import com.wallet.wallet.domain.model.Study;
import com.wallet.wallet.domain.repository.IStudyRepository;
import com.wallet.wallet.handler.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.wallet.wallet.domain.enums.EMessageCode.PROJECT_NOT_EXIST_BY_ID;
import static com.wallet.wallet.domain.enums.EMessageCode.RESOURCE_NOT_FIND_BY_ID;

@AllArgsConstructor
@Service
public class StudyServiceImpl extends GenericServiceImpl<Study, StudyResponseDto, StudyRequestDto, Long> implements IStudyService {

    private final StudyMapper mapper;
    private final IStudyRepository repository;

    private final MessageSource messenger;

    @Override
    public StudyResponseDto save(StudyRequestDto studyRequestDto) {
        return super.save(studyRequestDto);
    }

    @Override
    public StudyResponseDto getById(Long id) {
        StudyResponseDto studyResponseDto = super.getById(id);
        return studyResponseDto;
    }

    @Override
    public StudyResponseDtoLang getByIdEs(Long id) {
        Study existingBio = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));

        return mapper.entityToResponseDtoEs(existingBio);
    }

    @Override
    public StudyResponseDtoLang getByIdEn(Long id) {
        Study existingBio = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));

        return mapper.entityToResponseDtoEn(existingBio);
    }

    //@Override
    //public StudyResponseDto update(StudyRequestDto studyRequestDto, Long id) {
    //   Study existingProject = studyRepository.findById(id).orElseThrow(() ->
    //           new ResourceNotFoundException(messenger.getMessage(PROJECT_NOT_EXIST_BY_ID.name(),
    //                   new Object[] {id}, Locale.getDefault())));
    //
    //    projectMapper.updateEntityFromRequestDto(projectRequestDto, existingProject);
    //    projectRepository.save(existingProject);
    //
    //    return getById(id);
    //}

    @Override
    public List<StudyResponseDto> getView() {
        List<StudyResponseDto> studyResponseDtos = mapper.listEntityToListStudyDto(repository.getView());
        return studyResponseDtos;
    }

    @Override
    public List<StudyResponseDtoLang> getViewLang(String lang) {
        List<Study> listStudy = repository.getView();

        List<StudyResponseDtoLang> listStudyResponseDtoLang = new ArrayList<>();
        switch (lang) {
            case "es" -> listStudyResponseDtoLang = mapper.listEntityToListStudyDtoEs(listStudy);
            case "en" -> listStudyResponseDtoLang = mapper.listEntityToListStudyDtoEn(listStudy);
        };

        return listStudyResponseDtoLang;
    }

    @Override
    public List<StudyResponseDto> getAll() {
        return mapper.listEntityToListStudyDto(repository.getAll());
    }

    @Override
    public StudyResponseDto active(Long id) {
        Study existingProject = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(PROJECT_NOT_EXIST_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));

        if (ERecordStatus.A.equals(existingProject.getRecordStatus())) {
            existingProject.setRecordStatus(ERecordStatus.D);
        } else {
            existingProject.setRecordStatus(ERecordStatus.A);
        }

        repository.save(existingProject);

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
