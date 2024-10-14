package com.wallet.wallet.api.controller;

import com.wallet.wallet.api.service.IMenuService;

import com.wallet.wallet.domain.dto.request.MenuRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/menu")
@Tag(name = "Menú", description = "Controlador para gestionar Menú")
public record MenuController(IMenuService service) {

    @Operation(summary = "Guardar un Menú", description = "Devuelve el Menú guardado")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MenuRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }

    @Operation(summary = "Traer Menú por ID", description = "Devuelve el Menú buscado")
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

    @Operation(summary = "Traer los Menú activados", description = "Devuelve los Menú activados")
    @GetMapping("/getView")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getView(@RequestParam(required = false) String lang){
        if (lang == null) {
            return responseBuilder(OK, service.getView());
        }
        return switch (lang) {
            case "es", "en" -> responseBuilder(OK, service.getViewLang(lang));
            default -> responseBuilder(BAD_REQUEST, "Unsupported language: " + lang);
        };
    }

    @Operation(summary = "Modificar un Menú", description = "Devuelve el Menú modificado")
    @PostMapping("/update/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> update(@RequestBody MenuRequestDto menuRequestDto, @PathVariable Long id){
        return responseBuilder(OK, service.update(menuRequestDto, id));
    }

    @Operation(summary = "Activar o desactivar un Menú", description = "Devuelve el Menú activado o desactivado")
    @PostMapping("/active/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> active(@PathVariable Long id){
        return responseBuilder(OK, service.active(id));
    }

    @Operation(summary = "Traer todos los Menú", description = "Devuelve todos los Menú")
    @GetMapping("/getAll")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getAll(){
        return responseBuilder(OK, service.getAll());
    }

    @Operation(summary = "Eliminar Menú por ID", description = "Devuelve OK")
    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
