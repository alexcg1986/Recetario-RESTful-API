package com.recetario.backend.service;

import java.util.List;

import com.recetario.backend.common.GenericCrudService;
import com.recetario.backend.dto.ParametrosDTO;
import com.recetario.backend.dto.PlatoDTO;
import com.recetario.backend.model.Plato;

import org.springframework.stereotype.Service;

@Service
public interface PlatoService extends GenericCrudService<Plato, PlatoDTO, Integer> {

    List<PlatoDTO> getAllFiltered(ParametrosDTO parametrosDTO);
}