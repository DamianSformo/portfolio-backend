package com.wallet.wallet.api.service;

import com.wallet.wallet.api.service.generic.GenericServiceAPI;
import com.wallet.wallet.domain.dto.request.ProcessingFileRequestDto;
import com.wallet.wallet.domain.dto.response.ProcessingFileResponseDto;
import com.wallet.wallet.domain.dto.response.ProcessingFileResponseDtoRes;
import com.wallet.wallet.domain.model.ProcessingFile;

public interface IProcessingFileService extends GenericServiceAPI<ProcessingFile, ProcessingFileResponseDto, ProcessingFileRequestDto, Long> {

    ProcessingFileResponseDto save(ProcessingFileRequestDto processingFileRequestDto);

    ProcessingFileResponseDto update(ProcessingFileRequestDto processingFileRequestDto, Long id);

    //ProcessingFileResponseDto active(Long id);

    ProcessingFileResponseDto getById(Long id);

    ProcessingFileResponseDtoRes getByRes(String res);

    void delete(Long id);
}
