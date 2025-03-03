package com.portfolio.portfolio.api.service.impl;

import com.portfolio.portfolio.api.service.IProcessingFileService;
import com.portfolio.portfolio.api.service.generic.GenericServiceImpl;
import com.portfolio.portfolio.domain.dto.request.ProcessingFileRequestDto;
import com.portfolio.portfolio.domain.dto.response.*;
import com.portfolio.portfolio.domain.mapper.IMapper;
import com.portfolio.portfolio.domain.mapper.ProcessingFileMapper;
import com.portfolio.portfolio.domain.model.ProcessingFile;
import com.portfolio.portfolio.domain.repository.IProcessingFileRepository;
import com.portfolio.portfolio.handler.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;

import static com.portfolio.portfolio.domain.enums.EMessageCode.RESOURCE_NOT_FIND;
import static com.portfolio.portfolio.domain.enums.EMessageCode.RESOURCE_NOT_FIND_BY_ID;

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
