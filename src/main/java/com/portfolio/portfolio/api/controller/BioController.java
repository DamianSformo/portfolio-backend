package com.portfolio.portfolio.api.controller;

import com.portfolio.portfolio.api.service.IBioService;
import com.portfolio.portfolio.domain.dto.request.BioRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.portfolio.portfolio.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/bio")
@Tag(name = "Bio", description = "Controlador para gestionar Bio")
public record BioController(IBioService service) {

    @Operation(summary = "Guardar una Bio", description = "Devuelve la Bio guardada")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody BioRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }

    @Operation(summary = "Traer Bio por ID", description = "Devuelve la Bio buscada")
    @GetMapping("/getById/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getById(@PathVariable Long id, @RequestParam(required = false) String lang) {
        if (lang == null) {
            return responseBuilder(OK, service.getById(id));
        }
        return switch (lang) {
            case "es", "en" -> responseBuilder(OK, service.getByIdLang(id, lang));
            default -> responseBuilder(BAD_REQUEST, "Unsupported language: " + lang);
        };
    }

    @Operation(summary = "Traer Bio por Nombre", description = "Devuelve la Bio buscada")
    @GetMapping("/getByName/{name}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getById(@PathVariable String name, @RequestParam(required = false) String lang) {
        if (lang == null) {
            return responseBuilder(OK, service.getByName(name));
        }
        return switch (lang) {
            case "es", "en" -> responseBuilder(OK, service.getByNameLang(name, lang));
            default -> responseBuilder(BAD_REQUEST, "Unsupported language: " + lang);
        };
    }

    @Operation(summary = "Traer Statement por ID", description = "Devuelve el Statement buscado")
    @GetMapping("/getStatementById/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getStatementById(@PathVariable Long id, @RequestParam(required = false) String lang) {
        if (lang == null) {
            return responseBuilder(OK, service.getStatementById(id));
        }
        return switch (lang) {
            case "es", "en" -> responseBuilder(OK, service.getStatementByIdLang(id, lang));
            default -> responseBuilder(BAD_REQUEST, "Unsupported language: " + lang);
        };
    }

    @Operation(summary = "Modificar una Bio", description = "Devuelve la Bio modificada")
    @PostMapping("/update/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> update(@RequestBody BioRequestDto bioRequestDto, @PathVariable Long id){
        return responseBuilder(OK, service.update(bioRequestDto, id));
    }

    @Operation(summary = "Eliminar Bio por ID", description = "Devuelve OK")
    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
