package com.recetario.backend.service;

import com.recetario.backend.common.GenericCrudServiceImpl;
import com.recetario.backend.dto.ProcedenciaDTO;
import com.recetario.backend.model.Procedencia;
import com.recetario.backend.repository.ProcedenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcedenciaServiceImpl extends GenericCrudServiceImpl<Procedencia, ProcedenciaDTO, Integer>
        implements ProcedenciaService {

    @Autowired
    private ProcedenciaRepository repository;

    @Override
    public JpaRepository<Procedencia, Integer> getRepository() {
        return repository;
    }
}