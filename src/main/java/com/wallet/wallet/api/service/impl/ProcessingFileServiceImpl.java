package com.wallet.wallet.api.service.impl;

import com.wallet.wallet.api.service.IProcessingFileService;
import com.wallet.wallet.api.service.generic.GenericServiceImpl;
import com.wallet.wallet.domain.dto.request.ProcessingFileRequestDto;
import com.wallet.wallet.domain.dto.response.*;
import com.wallet.wallet.domain.mapper.IMapper;
import com.wallet.wallet.domain.mapper.ProcessingFileMapper;
import com.wallet.wallet.domain.model.ProcessingFile;
import com.wallet.wallet.domain.repository.IProcessingFileRepository;
import com.wallet.wallet.handler.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;

import static com.wallet.wallet.domain.enums.EMessageCode.RESOURCE_NOT_FIND;
import static com.wallet.wallet.domain.enums.EMessageCode.RESOURCE_NOT_FIND_BY_ID;

@AllArgsConstructor
@Service
public class ProcessingFileServiceImpl extends GenericServiceImpl<ProcessingFile, ProcessingFileResponseDto, ProcessingFileRequestDto, Long> implements IProcessingFileService {

    private final ProcessingFileMapper mapper;
    private final IProcessingFileRepository repository;
    private final MessageSource messenger;

    @Override
    public ProcessingFileResponseDto save(ProcessingFileRequestDto processingFileRequestDto) {
        return super.save(processingFileRequestDto);
    }

    @Override
    public ProcessingFileResponseDto getById(Long id) {
        ProcessingFileResponseDto processingFileResponseDto = super.getById(id);
        return processingFileResponseDto;
    }

    @Override
    public ProcessingFileResponseDtoRes getByRes(String res) {
        return repository.getRandomProcessingFile()
                .map(processingFile -> {
                    switch (res) {
                        case "desktop":
                            return mapper.entityToResponseDtoDesktop(processingFile);
                        case "mobile":
                            return mapper.entityToResponseDtoMobile(processingFile);
                        default:
                            throw new IllegalArgumentException("Resolución no soportada: " + res);
                    }
                })
                .orElseThrow(() -> new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND.name(),
                        new Object[] {}, Locale.getDefault())));
    }

    @Override
    public ProcessingFileResponseDto update(ProcessingFileRequestDto processingFileRequestDto, Long id) {
        ProcessingFile existingProcessingFile = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FIND_BY_ID.name(),
                        new Object[] {id}, Locale.getDefault())));

        mapper.updateEntityFromRequestDto(processingFileRequestDto, existingProcessingFile);
        repository.save(existingProcessingFile);

        return getById(id);
    }

    @Override
    public void delete(Long id){
        super.delete(id);
    }

    @Override
    public JpaRepository<ProcessingFile, Long> getRepository() {
        return repository;
    }

    @Override
    public IMapper<ProcessingFile, ProcessingFileResponseDto, ProcessingFileRequestDto> getMapper() {
        return mapper;
    }

    @Override
    public MessageSource getMessenger() {
        return messenger;
    }

}
