package com.wallet.wallet.api.service.impl;

import com.wallet.wallet.api.service.IBioService;
import com.wallet.wallet.api.service.generic.GenericServiceImpl;
import com.wallet.wallet.domain.dto.request.BioRequestDto;
import com.wallet.wallet.domain.dto.response.BioResponseDto;
import com.wallet.wallet.domain.dto.response.BioResponseDtoLang;
import com.wallet.wallet.domain.dto.response.StatementResponseDto;
import com.wallet.wallet.domain.dto.response.StatementResponseDtoLang;
import com.wallet.wallet.domain.mapper.BioMapper;
import com.wallet.wallet.domain.mapper.IMapper;
import com.wallet.wallet.domain.model.Bio;
import com.wallet.wallet.domain.repository.IBioRepository;
import com.wallet.wallet.handler.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.Locale;
import java.util.Optional;

import static com.wallet.wallet.domain.enums.EMessageCode.RESOURCE_NOT_FIND_BY_ID;

@AllArgsConstructor
@Service
public class BioServiceImpl extends GenericServiceImpl<Bio, BioResponseDto, BioRequestDto, Long> implements IBioService {

    private final BioMapper mapper;
    private final IBioRepository repository;

    private final MessageSource messenger;

    @Override
    public BioResponseDto save(BioRequestDto bioRequestDto) {
        return super.save(bioRequestDto);
    }

    @Override
    public BioResponseDto getById(Long id) {
        BioResponseDto projectResponseDto = super.getById(id);
        return projectResponseDto;
    }

    @Override
    public BioResponseDtoLang getByIdLang(Long id, String lang) {
        Bio existingBio = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));

        BioResponseDtoLang bio = new BioResponseDtoLang();
        switch (lang) {
            case "es" -> bio = mapper.entityToResponseDtoEs(existingBio);
            case "en" -> bio = mapper.entityToResponseDtoEn(existingBio);
        };

        return bio;
    }

    @Override
    public StatementResponseDto getStatementById(Long id) {
        return repository.getStatement(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));
    }

    @Override
    public StatementResponseDtoLang getStatementByIdLang(Long id, String lang) {
        return repository.getStatement(id)
                .map(statementResponseDto -> {
                    switch (lang) {
                        case "es":
                            return mapper.statementEntityToResponseDtoEs(statementResponseDto);
                        case "en":
                            return mapper.statementEntityToResponseDtoEn(statementResponseDto);
                        default:
                            throw new IllegalArgumentException("Lenguaje no soportado: " + lang);
                    }
                })
                .orElseThrow(() -> new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));
    }

    @Override
    public BioResponseDto update(BioRequestDto bioRequestDto, Long id) {
        Bio existingBio = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));

        mapper.updateEntityFromRequestDto(bioRequestDto, existingBio);
        repository.save(existingBio);

        return getById(id);
    }

    @Override
    public void delete(Long id){
        super.delete(id);
    }

    @Override
    public JpaRepository<Bio, Long> getRepository() {
        return repository;
    }

    @Override
    public IMapper<Bio, BioResponseDto, BioRequestDto> getMapper() {
        return mapper;
    }

    @Override
    public MessageSource getMessenger() {
        return messenger;
    }

}
