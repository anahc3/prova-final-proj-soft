package com.example.pf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetornarUsuarioDTO {
    private String nome;
    private String cpf;
    private String email;
    private String password;
    private String papel;
}

