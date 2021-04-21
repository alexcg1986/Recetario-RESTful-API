package com.recetario.backend.service;

import com.recetario.backend.common.GenericCrudService;
import com.recetario.backend.dto.ProcedenciaDTO;
import com.recetario.backend.model.Procedencia;

import org.springframework.stereotype.Service;

@Service
public interface ProcedenciaService extends GenericCrudService<Procedencia, ProcedenciaDTO, Integer> {
}