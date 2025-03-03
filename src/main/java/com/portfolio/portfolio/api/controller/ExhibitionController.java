package com.portfolio.portfolio.api.controller;

import com.portfolio.portfolio.api.service.IExhibitionService;
import com.portfolio.portfolio.domain.dto.request.ExhibitionRequestDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.portfolio.portfolio.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/exhibition")
@Tag(name = "Exhibition", description = "Controlador para gestionar Exhibiciones")
public class ExhibitionController {

    private final IExhibitionService service;

    public ExhibitionController(IExhibitionService service) {
        this.service = service;
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> save(@RequestBody ExhibitionRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, @RequestParam(required = false) String lang) {
        if (lang == null) {
            return responseBuilder(OK, service.getById(id));
        }
        return switch (lang) {
            case "es", "en" -> responseBuilder(OK, service.getByIdLang(id, lang));
            default -> responseBuilder(BAD_REQUEST, "Unsupported language: " + lang);
        };
    }


    @GetMapping("/getView")
    public ResponseEntity<?> getView(@RequestParam(required = false) String lang){
        if (lang == null) {
            return responseBuilder(OK, service.getView());
        }
        return switch (lang) {
            case "es", "en" -> responseBuilder(OK, service.getViewLang(lang));
            default -> responseBuilder(BAD_REQUEST, "Unsupported language: " + lang);
        };
    }


    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return responseBuilder(OK, service.getAll());
    }


    @GetMapping("/getComplete")
    public ResponseEntity<?> getComplete(@RequestParam(required = false) String lang){
        if (lang == null) {
            return responseBuilder(OK, service.getView());
        }
        return switch (lang) {
            case "es", "en" -> responseBuilder(OK, service.getComplete(lang));
            default -> responseBuilder(BAD_REQUEST, "Unsupported language: " + lang);
        };
    }


    @Operation(summary = "Modificar una Exhibición", description = "Devuelve la Exhibición modificada")
    @PostMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> update(@RequestBody ExhibitionRequestDto exhibitionRequestDto, @PathVariable Long id){
        return responseBuilder(OK, service.update(exhibitionRequestDto, id));
    }


    @PostMapping("/activate/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> activate(@PathVariable Long id){
        return responseBuilder(OK, service.activate(id));
    }


    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
