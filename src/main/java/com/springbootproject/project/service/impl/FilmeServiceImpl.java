package com.springbootproject.project.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.springbootproject.project.exceptions.FilmeDuplicadoException;
import com.springbootproject.project.exceptions.FilmeNaoEncontradoException;
import com.springbootproject.project.model.Filme;
import com.springbootproject.project.repository.FilmeRepository;
import com.springbootproject.project.service.FilmeService;
import lombok.Data;

@Service
@Data
public class FilmeServiceImpl implements FilmeService{ //lógica necessária para a interface de serviço
    final FilmeRepository filmeRep;

    @Override
    public Filme save(Filme filme) throws FilmeDuplicadoException{
        Filme filmeFromDB = filmeRep.findById(filme.getId()).orElse(null);
        if(filmeFromDB != null){
            throw new FilmeDuplicadoException(filme.getId());
        }
        return filmeRep.save(filme);
    }

    @Override
    public Filme update(Filme filme) throws FilmeNaoEncontradoException {
        Filme filmeFromDB = filmeRep.findById(filme.getId()).orElse(null);
        if(filmeFromDB == null){
            throw new FilmeNaoEncontradoException(filme.getId());
        }
        filme.setId(filmeFromDB.getId());
        return filmeRep.save(filme);
    }

    @Override
    public Long delete(Long id) throws FilmeNaoEncontradoException {
        Filme filmeFromDB = filmeRep.findById(id).orElse(null);
        if (filmeFromDB == null) {
            throw new FilmeNaoEncontradoException(id);
        }
        filmeRep.delete(filmeFromDB);
        return id;
    }

    @Override
    public List<Filme> findAll() {
        return filmeRep.findAll();
    }

    
}
