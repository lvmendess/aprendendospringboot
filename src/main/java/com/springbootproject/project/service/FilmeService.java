package com.springbootproject.project.service;

import java.util.List;

import com.springbootproject.project.exceptions.FilmeDuplicadoException;
import com.springbootproject.project.exceptions.FilmeNaoEncontradoException;
import com.springbootproject.project.model.Filme;

public interface FilmeService { //contém o schema do serviço projetado, métodos que realizam operações CRUD

    Filme save(Filme filme) throws FilmeDuplicadoException; //salva
    Filme update(Filme filme) throws FilmeNaoEncontradoException; //atualiza
    Long delete(Long id) throws FilmeNaoEncontradoException; //deleta 
    List<Filme> findAll(); //lista todos os filmes
}
