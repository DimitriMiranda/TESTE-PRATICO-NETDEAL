package com.netdeal.netdeal.domain.dto;

import jakarta.validation.constraints.NotBlank;

public class FuncionarioDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String senha;
}
