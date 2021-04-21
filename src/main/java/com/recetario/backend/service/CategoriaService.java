package com.recetario.backend.service;

import com.recetario.backend.common.GenericCrudService;
import com.recetario.backend.dto.CategoriaDTO;
import com.recetario.backend.model.Categoria;

import org.springframework.stereotype.Service;

@Service
public interface CategoriaService extends GenericCrudService<Categoria, CategoriaDTO, Integer> {
}