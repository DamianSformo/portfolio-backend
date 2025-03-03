package com.portfolio.portfolio.api.controller;

import com.portfolio.portfolio.api.service.IStudyService;
import com.portfolio.portfolio.domain.dto.request.StudyRequestDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.portfolio.portfolio.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/study")
@Tag(name = "Study", description = "Controlador para gestionar Estudios")
public class StudyController {

    private final IStudyService service;

    public StudyController(IStudyService service) {
        this.service = service;
    }

    @Operation(summary = "Guardar un Estudio", description = "Devuelve el Estudio guardado")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> save(@RequestBody StudyRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }

    @Operation(summary = "Traer Estudio por ID", description = "Devuelve el Estudio buscado")
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

    @Operation(summary = "Traer los Estudios activados", description = "Devuelve los Estudios activados")
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

    @Operation(summary = "Traer todos los Estudios", description = "Devuelve todos los Estudios")
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return responseBuilder(OK, service.getAll());
    }


    @Operation(summary = "Modificar un Estudio", description = "Devuelve el Estudio modificado")
    @PostMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> update(@RequestBody StudyRequestDto studyRequestDto, @PathVariable Long id){
        return responseBuilder(OK, service.update(studyRequestDto, id));
    }

    @Operation(summary = "Activar o desactivar un Estudio", description = "Devuelve el Estudio activado o desactivado")
    @PostMapping("/activate/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> activate(@PathVariable Long id){
        return responseBuilder(OK, service.activate(id));
    }

    @Operation(summary = "Eliminar Estudio por ID", description = "Devuelve OK")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
