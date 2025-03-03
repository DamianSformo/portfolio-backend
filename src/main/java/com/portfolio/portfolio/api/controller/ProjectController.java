package com.portfolio.portfolio.api.controller;

import com.portfolio.portfolio.api.service.IProjectService;
import com.portfolio.portfolio.domain.dto.request.ProjectRequestDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import static com.portfolio.portfolio.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/project")
@Tag(name = "Project", description = "Controlador para gestionar Proyectos")
public class ProjectController {

    private final IProjectService service;

    public ProjectController(IProjectService service) {
        this.service = service;
    }

    @Operation(summary = "Guardar un Proyecto", description = "Devuelve el Proyecto guardado")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> save(@RequestBody ProjectRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }

    @Operation(summary = "Traer Proyecto por ID", description = "Devuelve el Proyecto buscado")
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

    @Operation(summary = "Traer los Proyectos activados", description = "Devuelve los Proyectos activados")
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

    @Operation(summary = "Traer todos los Proyectos", description = "Devuelve todos los Proyectos")
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return responseBuilder(OK, service.getAll());
    }

    @Operation(summary = "Traer todas las previsualizaciones de los Proyectos", description = "Devuelve todas las previsualizaciones de los Proyectos")
    @GetMapping("/getPreview")
    public ResponseEntity<?> getPreview(@RequestParam(required = false) String lang){
        if (lang == null) {
            return responseBuilder(OK, service.getView());
        }
        return switch (lang) {
            case "es", "en" -> responseBuilder(OK, service.getPreviewLang(lang));
            default -> responseBuilder(BAD_REQUEST, "Unsupported language: " + lang);
        };
    }

    @Operation(summary = "Modificar un Proyecto", description = "Devuelve el Proyecto modificado")
    @PostMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> update(@RequestBody ProjectRequestDto projectRequestDto, @PathVariable Long id){
        return responseBuilder(OK, service.update(projectRequestDto, id));
    }

    @Operation(summary = "Activar o desactivar un Proyecto", description = "Devuelve el Proyecto activado o desactivado")
    @PostMapping("/active/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> active(@PathVariable Long id){
        return responseBuilder(OK, service.active(id));
    }


    @Operation(summary = "Eliminar Proyecto por ID", description = "Devuelve OK")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
