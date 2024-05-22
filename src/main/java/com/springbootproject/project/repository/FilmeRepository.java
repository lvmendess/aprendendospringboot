package com.springbootproject.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springbootproject.project.model.Filme;

@Repository //especialização da anotação @Component que permite Spring autodetectar classes Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{}
