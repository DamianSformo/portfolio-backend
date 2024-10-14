package com.wallet.wallet.api.service.impl;

import com.wallet.wallet.api.service.IExhibitionService;
import com.wallet.wallet.api.service.generic.GenericServiceImpl;
import com.wallet.wallet.domain.dto.request.ExhibitionRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.enums.ERecordStatus;
import com.wallet.wallet.domain.mapper.ExhibitionMapper;
import com.wallet.wallet.domain.mapper.IMapper;
import com.wallet.wallet.domain.model.Exhibition;
import com.wallet.wallet.domain.repository.IExhibitionRepository;
import com.wallet.wallet.handler.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.wallet.wallet.domain.enums.EMessageCode.RESOURCE_NOT_FIND_BY_ID;

@AllArgsConstructor
@Service
public class ExhibitionServiceImpl extends GenericServiceImpl<Exhibition, ExhibitionResponseDto, ExhibitionRequestDto, Long> implements IExhibitionService {

    private final ExhibitionMapper mapper;
    private final IExhibitionRepository repository;

    private final PrizeServiceImpl prizeService;

    private final MessageSource messenger;

    @Override
    public ExhibitionResponseDto save(ExhibitionRequestDto exhibitionRequestDto) {
        return super.save(exhibitionRequestDto);
    }

    @Override
    public ExhibitionResponseDto getById(Long id) {
        ExhibitionResponseDto exhibitionResponseDto = super.getById(id);
        return exhibitionResponseDto;
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
    public List<ExhibitionResponseDto> getView() {
        List<ExhibitionResponseDto> listExhibitionResponseDto = mapper.listEntityToListDto(repository.getView());
        return listExhibitionResponseDto;
    }

    @Override
    public List<ExhibitionResponseDtoLang> getViewLang(String lang) {
        List<Exhibition> listExhibition = repository.getView();

        List<ExhibitionResponseDtoLang> listExhibitionResponseDtoLang = new ArrayList<>();
        switch (lang) {
            case "es" -> listExhibitionResponseDtoLang = mapper.listEntityToListProjectDtoEs(listExhibition);
            case "en" -> listExhibitionResponseDtoLang = mapper.listEntityToListProjectDtoEn(listExhibition);
        };

        return listExhibitionResponseDtoLang;
    }

    @Override
    public List<ExhibitionResponseDto> getAll() {
        return mapper.listEntityToListDto(repository.getAll());
    }

    @Override
    public ExhibitionCompleteResponseDtoLang getComplete(String lang) {
        List<Exhibition> listExhibitionGroup = repository.getExhibitionGroup();
        List<Exhibition> listExhibitionIndividual = repository.getExhibitionIndividual();

        List<ExhibitionResponseDtoLang> listExhibitionGroupLang = new ArrayList<>();
        List<ExhibitionResponseDtoLang> listExhibitionIndividualLang = new ArrayList<>();
        List<PrizeResponseDtoLang> listPrizeResponseDtoLang = new ArrayList<>();
        switch (lang) {
            case "es" -> {
                listExhibitionGroupLang = mapper.listEntityToListProjectDtoEs(listExhibitionGroup);
                listExhibitionIndividualLang = mapper.listEntityToListProjectDtoEs(listExhibitionIndividual);
                listPrizeResponseDtoLang = prizeService.getViewLang("es");
            }
            case "en" -> {
                listExhibitionGroupLang = mapper.listEntityToListProjectDtoEn(listExhibitionGroup);
                listExhibitionIndividualLang = mapper.listEntityToListProjectDtoEn(listExhibitionIndividual);
                listPrizeResponseDtoLang = prizeService.getViewLang("en");
            }
        };

        ExhibitionCompleteResponseDtoLang exhibitionCompleteResponseDtoLang = new ExhibitionCompleteResponseDtoLang();
        exhibitionCompleteResponseDtoLang.setExhibitionGroup(listExhibitionGroupLang);
        exhibitionCompleteResponseDtoLang.setExhibitionIndividual(listExhibitionIndividualLang);
        exhibitionCompleteResponseDtoLang.setPrizes(listPrizeResponseDtoLang);

        return exhibitionCompleteResponseDtoLang;
    }

    @Override
    public ExhibitionResponseDto active(Long id) {
        Exhibition existing = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {"Exhibition", id}, Locale.getDefault())));

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
