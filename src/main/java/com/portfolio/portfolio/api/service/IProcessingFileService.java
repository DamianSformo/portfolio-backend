package com.portfolio.portfolio.api.service;

import com.portfolio.portfolio.api.service.generic.GenericServiceAPI;
import com.portfolio.portfolio.domain.dto.request.ProcessingFileRequestDto;
import com.portfolio.portfolio.domain.dto.response.ProcessingFileResponseDto;
import com.portfolio.portfolio.domain.dto.response.ProcessingFileResponseDtoRes;
import com.portfolio.portfolio.domain.model.ProcessingFile;

public interface IProcessingFileService extends GenericServiceAPI<ProcessingFile, ProcessingFileResponseDto, ProcessingFileRequestDto, Long> {

    ProcessingFileResponseDto save(ProcessingFileRequestDto processingFileRequestDto);

    ProcessingFileResponseDto update(ProcessingFileRequestDto processingFileRequestDto, Long id);

    //ProcessingFileResponseDto active(Long id);

    ProcessingFileResponseDto getById(Long id);

    ProcessingFileResponseDtoRes getByRes(String res);

    void delete(Long id);
}
