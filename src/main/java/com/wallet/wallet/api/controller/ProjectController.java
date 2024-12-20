package com.wallet.wallet.api.controller;

import com.wallet.wallet.api.service.IProjectService;
import com.wallet.wallet.domain.dto.request.ProjectRequestDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/project")
public record ProjectController(IProjectService service) {


    @PostMapping("/save")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> save(@RequestBody ProjectRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }


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


    @GetMapping("/getPreview")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getPreview(@RequestParam(required = false) String lang){
        if (lang == null) {
            return responseBuilder(OK, service.getView());
        }
        return switch (lang) {
            case "es", "en" -> responseBuilder(OK, service.getPreviewLang(lang));
            default -> responseBuilder(BAD_REQUEST, "Unsupported language: " + lang);
        };
    }


    @GetMapping("/getAll")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getAll(){
        return responseBuilder(OK, service.getAll());
    }


    @PostMapping("/update/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> update(@RequestBody ProjectRequestDto projectRequestDto, @PathVariable Long id){
        return responseBuilder(OK, service.update(projectRequestDto, id));
    }


    @PostMapping("/active/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> active(@PathVariable Long id){
        return responseBuilder(OK, service.active(id));
    }


    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
