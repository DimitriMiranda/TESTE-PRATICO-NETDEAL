package com.netdeal.netdeal.controller;

import com.netdeal.netdeal.controller.form.FuncionarioForm;
import com.netdeal.netdeal.domain.dto.FuncionarioDTO;
import com.netdeal.netdeal.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RequiredArgsConstructor
@RestController
@RequestMapping("/funcionarios")
@Primary
public class FuncionarioController {

    private final FuncionarioService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody @Valid FuncionarioForm funcionarioForm) {


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(funcionarioForm.getId())
                .toUri();

        return ResponseEntity.created(uri)
                .body(funcionarioForm);
    }

}
