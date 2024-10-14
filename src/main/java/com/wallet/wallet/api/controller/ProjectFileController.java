package com.wallet.wallet.api.controller;

import com.wallet.wallet.api.service.IProjectFileService;
import com.wallet.wallet.api.service.IProjectService;
import com.wallet.wallet.domain.dto.request.ProjectFileRequestDto;
import com.wallet.wallet.domain.dto.request.ProjectRequestDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/projectFile")

public record ProjectFileController(IProjectFileService service) {


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProjectFileRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }
}
