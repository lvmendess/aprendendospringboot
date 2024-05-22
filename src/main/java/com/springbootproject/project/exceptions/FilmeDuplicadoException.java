package com.springbootproject.project.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class FilmeDuplicadoException extends Exception{
    private Long filmeId;
}
