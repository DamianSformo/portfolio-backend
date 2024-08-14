package com.wallet.wallet.api.controller;

import com.wallet.wallet.api.service.IExhibitionService;
import com.wallet.wallet.api.service.IProjectService;
import com.wallet.wallet.domain.dto.request.ExhibitionRequestDto;
import com.wallet.wallet.domain.dto.request.ProjectRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/exhibition")
@Api(tags = "Exhibition", description = " " )
public record ExhibitionController(IExhibitionService service) {

    @ApiOperation(value = "Register a new Expense")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ExhibitionRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }

    /*
    @ApiOperation(value = "Find Expense by Id by User")
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
    */

    @ApiOperation(value = "Find Expense by Id by User")
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

    @ApiOperation(value = "Find Expense by Id by User")
    @GetMapping("/getAll")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getAll(){
        return responseBuilder(OK, service.getAll());
    }

    @ApiOperation(value = "Find Expense by Id by User")
    @GetMapping("/getComplete")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getComplete(@RequestParam(required = false) String lang){
        if (lang == null) {
            return responseBuilder(OK, service.getView());
        }
        return switch (lang) {
            case "es", "en" -> responseBuilder(OK, service.getComplete(lang));
            default -> responseBuilder(BAD_REQUEST, "Unsupported language: " + lang);
        };
    }

    /*
    @ApiOperation(value = "Find Expense by Id by User")
    @PostMapping("/update/{ }")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> update(@RequestBody ProjectRequestDto projectRequestDto, @PathVariable Long id){
        return responseBuilder(OK, service.update(projectRequestDto, id));
    }
    */

    @ApiOperation(value = "Find Expense by Id by User")
    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @ApiOperation(value = "Find Expense by Id by User")
    @PostMapping("/active/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> active(@PathVariable Long id){
        return responseBuilder(OK, service.active(id));
    }
}
