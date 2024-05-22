package com.springbootproject.project.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true) //gera os métodos equals() e hashCode()
@Data
@AllArgsConstructor //gera construtor c/todos os argumentos
public class FilmeNaoEncontradoException extends Exception{
    private Long filmeId;
}
