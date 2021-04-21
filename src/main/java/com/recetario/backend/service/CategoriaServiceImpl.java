package com.recetario.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.recetario.backend.common.GenericCrudServiceImpl;
import com.recetario.backend.dto.CategoriaDTO;
import com.recetario.backend.model.Categoria;
import com.recetario.backend.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl extends GenericCrudServiceImpl<Categoria, CategoriaDTO, Integer>
        implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public JpaRepository<Categoria, Integer> getRepository() {
        return repository;
    }
}