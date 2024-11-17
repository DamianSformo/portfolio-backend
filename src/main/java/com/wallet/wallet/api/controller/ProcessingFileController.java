package com.wallet.wallet.api.controller;

import com.wallet.wallet.api.service.IProcessingFileService;
import com.wallet.wallet.domain.dto.request.ProcessingFileRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/processingFile")
@Tag(name = "ProcessingFile", description = "Controlador para gestionar ProcessingFile")
public record ProcessingFileController(IProcessingFileService service) {

    @Operation(summary = "Guardar un Processing File", description = "Devuelve el Processing File guardado")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProcessingFileRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }

    @Operation(summary = "Traer Processing File por ID", description = "Devuelve el Processing File buscado")
    @GetMapping("/getById/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getById(@PathVariable Long id, @RequestParam(required = false) String res) {
        if (res == null) {
            return responseBuilder(OK, service.getById(id));
        }
        return switch (res) {
            case "desktop", "mobile" -> responseBuilder(OK, service.getByRes(res));
            default -> responseBuilder(BAD_REQUEST, "Unsupported resolution: " + res);
        };
    }

    @Operation(summary = "Traer Processing File por ID", description = "Devuelve el Processing File buscado")
    @GetMapping("/get")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> get(@RequestParam(required = false) String res) {
        if (res == null) {
            return responseBuilder(OK, service.getByRes(res));
        }
        return switch (res) {
            case "desktop", "mobile" -> responseBuilder(OK, service.getByRes(res));
            default -> responseBuilder(BAD_REQUEST, "Unsupported resolution: " + res);
        };
    }

    @Operation(summary = "Modificar un Processing File", description = "Devuelve el Processing File modificado")
    @PostMapping("/update/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> update(@RequestBody ProcessingFileRequestDto processingFileRequestDto, @PathVariable Long id){
        return responseBuilder(OK, service.update(processingFileRequestDto, id));
    }

    @Operation(summary = "Eliminar Processing File por ID", description = "Devuelve OK")
    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
