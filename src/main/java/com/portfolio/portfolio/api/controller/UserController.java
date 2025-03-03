package com.portfolio.portfolio.api.controller;

import com.portfolio.portfolio.api.service.IStudyService;
import com.portfolio.portfolio.api.service.IUserService;
import com.portfolio.portfolio.domain.dto.request.AuthenticationRequest;
import com.portfolio.portfolio.domain.dto.request.UserRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import static org.springframework.http.HttpStatus.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.portfolio.portfolio.handler.ResponseBuilder.*;


@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "Controlador para gestionar Usuarios")
@CrossOrigin
public class UserController{

    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @Operation(summary = "Guardar o actualizar un Usuario")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }

    @Operation(summary = "Log in de Usuario")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest dto) {
        return responseBuilder(OK, service.authenticate(dto));
    }

    @Operation(summary = "Activar o desactivar un Usuario", description = "Devuelve el Usuario activado o desactivado")
    @PostMapping("/activate/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> activate(@PathVariable Long id){
        return responseBuilder(OK, service.activate(id));
    }

}
