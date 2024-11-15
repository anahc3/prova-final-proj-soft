package com.example.pf.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Artigo {
    @Id
    private String id;
    private String titulo;
    private String conteudo;
    private String autor;

}
