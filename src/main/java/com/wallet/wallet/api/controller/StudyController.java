package com.wallet.wallet.api.controller;

import com.wallet.wallet.api.service.IBioService;
import com.wallet.wallet.api.service.IStudyService;
import com.wallet.wallet.domain.dto.request.BioRequestDto;
import com.wallet.wallet.domain.dto.request.StudyRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/study")
@Api(tags = "Study", description = " " )
public record StudyController(IStudyService service) {

    @ApiOperation(value = "Register a new Expense")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody StudyRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }

    @ApiOperation(value = "Find Expense by Id by User")
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

    //@ApiOperation(value = "Find Expense by Id by User")
    //@PostMapping("/update/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    //public ResponseEntity<?> update(@RequestBody StudyRequestDto studyRequestDto, @PathVariable Long id){
    //    return responseBuilder(OK, service.update(studyRequestDto, id));
    //}

    @ApiOperation(value = "Find Expense by Id by User")
    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
