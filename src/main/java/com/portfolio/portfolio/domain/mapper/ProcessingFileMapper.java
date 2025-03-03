package com.portfolio.portfolio.domain.mapper;

import com.portfolio.portfolio.domain.dto.request.ProcessingFileRequestDto;
import com.portfolio.portfolio.domain.dto.response.ProcessingFileResponseDto;
import com.portfolio.portfolio.domain.dto.response.ProcessingFileResponseDtoRes;
import com.portfolio.portfolio.domain.model.ProcessingFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ProcessingFileMapper implements IMapper<ProcessingFile, ProcessingFileResponseDto, ProcessingFileRequestDto> {

    public abstract ProcessingFileResponseDto entityToResponseDto(ProcessingFile processingFile);

    public abstract ProcessingFile requestDtoToEntity(ProcessingFileRequestDto processingFileRequestDto);

    @Mapping(source = "urlDesktop", target = "url")
    public abstract ProcessingFileResponseDtoRes entityToResponseDtoDesktop(ProcessingFile processingFile);

    @Mapping(source = "urlMobile", target = "url")
    public abstract ProcessingFileResponseDtoRes entityToResponseDtoMobile(ProcessingFile processingFile);

    public void updateEntityFromRequestDto(ProcessingFileRequestDto processingFileRequestDto, ProcessingFile processingFile) {
        if (processingFileRequestDto.getUrlDesktop() != null) {
            processingFile.setUrlDesktop(processingFileRequestDto.getUrlDesktop());
        }
        if (processingFileRequestDto.getUrlMobile() != null) {
            processingFile.setUrlMobile(processingFileRequestDto.getUrlMobile());
        }
    }

}