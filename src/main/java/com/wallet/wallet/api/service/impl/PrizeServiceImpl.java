package com.wallet.wallet.api.service.impl;

import com.wallet.wallet.api.service.IPrizeService;
import com.wallet.wallet.api.service.IProjectService;
import com.wallet.wallet.api.service.generic.GenericServiceImpl;
import com.wallet.wallet.domain.dto.request.PrizeRequestDto;
import com.wallet.wallet.domain.dto.request.ProjectRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.enums.ERecordStatus;
import com.wallet.wallet.domain.mapper.IMapper;
import com.wallet.wallet.domain.mapper.PrizeMapper;
import com.wallet.wallet.domain.mapper.ProjectFileMapper;
import com.wallet.wallet.domain.mapper.ProjectMapper;
import com.wallet.wallet.domain.model.Menu;
import com.wallet.wallet.domain.model.Prize;
import com.wallet.wallet.domain.model.Project;
import com.wallet.wallet.domain.repository.IPrizeRepository;
import com.wallet.wallet.domain.repository.IProjectFileRepository;
import com.wallet.wallet.domain.repository.IProjectRepository;
import com.wallet.wallet.handler.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.wallet.wallet.domain.enums.EMessageCode.RESOURCE_NOT_FIND_BY_ID;
import static com.wallet.wallet.domain.enums.EMessageCode.RESOURCE_NOT_FOUND_BY_ID;

@AllArgsConstructor
@Service
public class PrizeServiceImpl extends GenericServiceImpl<Prize, PrizeResponseDto, PrizeRequestDto, Long> implements IPrizeService {

    private final PrizeMapper mapper;
    private final IPrizeRepository repository;

    private final MessageSource messenger;

    @Override
    public PrizeResponseDto save(PrizeRequestDto prizeRequestDto) {
        return super.save(prizeRequestDto);
    }

    @Override
    public PrizeResponseDto getById(Long id) {
        PrizeResponseDto prizeResponseDto = super.getById(id);
        return prizeResponseDto;
    }

    @Override
    public PrizeResponseDtoLang getByIdLang(Long id, String lang) {
        Prize existing = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                        new Object[] {"Prize", id}, Locale.getDefault())));

        PrizeResponseDtoLang prizeResponseDtoLang = new PrizeResponseDtoLang();
        switch (lang) {
            case "es" -> prizeResponseDtoLang = mapper.entityToResponseDtoEs(existing);
            case "en" -> prizeResponseDtoLang = mapper.entityToResponseDtoEn(existing);
        };

        return prizeResponseDtoLang;
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
    public List<PrizeResponseDto> getView() {
        List<PrizeResponseDto> prizeResponseDtos = mapper.listEntityToListDto(repository.getView());
        return prizeResponseDtos;
    }

    @Override
    public List<PrizeResponseDtoLang> getViewLang(String lang) {
        List<Prize> prizes = repository.getView();

        List<PrizeResponseDtoLang> prizeResponseDtoLangs = new ArrayList<>();
        switch (lang) {
            case "es" -> {
                prizeResponseDtoLangs = mapper.listEntityToListProjectDtoEs(prizes);
            }
            case "en" -> {
                prizeResponseDtoLangs = mapper.listEntityToListProjectDtoEn(prizes);
                }
            }

        return prizeResponseDtoLangs;
    }

    @Override
    public List<PrizeResponseDto> getAll() {
        return mapper.listEntityToListDto(repository.getAll());
    }

    @Override
    public PrizeResponseDto active(Long id) {
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
