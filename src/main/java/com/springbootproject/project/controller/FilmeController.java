package com.springbootproject.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.project.exceptions.FilmeDuplicadoException;
import com.springbootproject.project.exceptions.FilmeNaoEncontradoException;
import com.springbootproject.project.model.Filme;
import com.springbootproject.project.service.FilmeService;

import lombok.Data;

@RestController
@RequestMapping("filme")
@Data
public class FilmeController {
    final FilmeService filmeService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Filme filme) throws FilmeDuplicadoException{
        if(filme==null){
            return ResponseEntity.badRequest().body("Filme inválido");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.save(filme));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Filme filme) throws FilmeNaoEncontradoException{
        if(filme==null){
            return ResponseEntity.badRequest().body("Filme inválido");
        }
        return ResponseEntity.ok().body(filmeService.update(filme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws FilmeNaoEncontradoException{
        if(id==null){
            return ResponseEntity.badRequest().body("Id de filme inválida");
        }
        return ResponseEntity.ok().body("Filme ["+filmeService.delete(id)+"] deletado com sucesso");
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(filmeService.findAll());
    }
}
