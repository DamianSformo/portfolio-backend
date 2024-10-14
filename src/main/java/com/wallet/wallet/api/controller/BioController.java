package com.wallet.wallet.api.controller;

import com.wallet.wallet.api.service.IBioService;
import com.wallet.wallet.domain.dto.request.BioRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/bio")

public record BioController(IBioService service) {


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody BioRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }


    @GetMapping("/getById/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getById(@PathVariable Long id, @RequestParam(required = false) String lang) {
        if (lang == null) {
            return responseBuilder(OK, service.getById(id));
        }
        return switch (lang) {
            case "es" -> responseBuilder(OK, service.getByIdEs(id));
            case "en" -> responseBuilder(OK, service.getByIdEn(id));
            default -> responseBuilder(BAD_REQUEST, "Unsupported language: " + lang);
        };
    }


    @PostMapping("/update/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> update(@RequestBody BioRequestDto bioRequestDto, @PathVariable Long id){
        return responseBuilder(OK, service.update(bioRequestDto, id));
    }


    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
