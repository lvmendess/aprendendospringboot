package com.springbootproject.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data //gera construtores/getters/setters implicitamente
@Entity //informa o Spring que a classe deve ser representada por tabela -> ORM
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //gera sequencia de id, garantindo que não haverão ids duplicadas
    private Long id;
    private String titulo;
    private String genero;
    private Long duracao;
    private Long lancamento;

}
