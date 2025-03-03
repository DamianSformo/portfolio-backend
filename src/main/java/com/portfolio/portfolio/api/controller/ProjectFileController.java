package com.portfolio.portfolio.api.controller;

import com.portfolio.portfolio.api.service.IProjectFileService;
import com.portfolio.portfolio.domain.dto.request.ProjectFileRequestDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.portfolio.portfolio.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/projectFile")

public record ProjectFileController(IProjectFileService service) {


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProjectFileRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }
}
