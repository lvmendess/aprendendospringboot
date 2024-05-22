package com.springbootproject.project.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springbootproject.project.exceptions.FilmeDuplicadoException;
import com.springbootproject.project.exceptions.FilmeNaoEncontradoException;

@ControllerAdvice
public class FilmeControllerExceptionHandler {

    @ExceptionHandler(FilmeNaoEncontradoException.class)
    private ResponseEntity<?> handleFilmeNaoEncontradoException(FilmeNaoEncontradoException e){
        String msgResposta = "O filme ["+e.getFilmeId()+"] não foi encontrado";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msgResposta);
    }

    @ExceptionHandler(FilmeDuplicadoException.class)
    private ResponseEntity<?> handleFilmeDuplicadoException(FilmeDuplicadoException e){
        String msgResposta = "O filme ["+e.getFilmeId()+"] já existe";
        return ResponseEntity.status(HttpStatus.CONFLICT).body(msgResposta);
    }
}
