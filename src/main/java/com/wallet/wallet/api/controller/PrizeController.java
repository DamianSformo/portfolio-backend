package com.wallet.wallet.api.controller;

import com.wallet.wallet.api.service.IExhibitionService;
import com.wallet.wallet.api.service.IPrizeService;
import com.wallet.wallet.domain.dto.request.ExhibitionRequestDto;
import com.wallet.wallet.domain.dto.request.PrizeRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/prize")
@Tag(name = "Prize", description = "Controlador para gestionar Becas, Premios y Residencia")
public record PrizeController(IPrizeService service) {

    @Operation(summary = "Guardar una Beca, Premio y Residencia", description = "Devuelve la Beca, Premio o Residencia guardado")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PrizeRequestDto prizeRequestDto) {
        return responseBuilder(CREATED, service.save(prizeRequestDto));
    }

    @Operation(summary = "Traer una Beca, Premio y Residencia por ID", description = "Devuelve la Beca, Premio o Residencia buscado")
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

    @Operation(summary = "Traer las Becas, Premios y Residencias activadas", description = "Devuelve las Becas, Premios y Residencias activadas")
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

    @GetMapping("/getAll")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getAll(){
        return responseBuilder(OK, service.getAll());
    }

    @Operation(summary = "Modificar una Beca, Premio o Residencia", description = "Devuelve la Beca, Premio o Residencia modificado")
    @PostMapping("/update/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> update(@RequestBody PrizeRequestDto prizeRequestDto, @PathVariable Long id){
        return responseBuilder(OK, service.update(prizeRequestDto, id));
    }


    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


    @PostMapping("/active/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> active(@PathVariable Long id){
        return responseBuilder(OK, service.active(id));
    }
}
