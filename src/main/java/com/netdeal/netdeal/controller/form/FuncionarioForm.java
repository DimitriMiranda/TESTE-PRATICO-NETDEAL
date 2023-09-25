package com.netdeal.netdeal.controller.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FuncionarioForm {


    private Long id;
    private Long coordenador_id;
    private Long subcoordenador_id;

    @NotBlank
    private String nome;
    @NotBlank
    private String senha;

}


