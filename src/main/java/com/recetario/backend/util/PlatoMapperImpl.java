package com.recetario.backend.util;

import com.recetario.backend.dto.PlatoDTO;
import com.recetario.backend.model.Plato;

import org.springframework.stereotype.Component;

@Component
public class PlatoMapperImpl implements Mapper<Plato, PlatoDTO> {

    @Override
    public Plato toEntity(PlatoDTO dto) {
        Plato plato = new Plato();
        plato.setId(dto.getId());
        plato.setNombre(dto.getNombre());
        plato.setDescripcion(dto.getDescripcion());
        plato.setCalorias(dto.getCalorias());
        plato.getCategoria().setId(dto.getCategoria().getId());
        plato.getProcedencia().setId(dto.getProcedencia().getId());
        return plato;
    }

    @Override
    public PlatoDTO toDTO(Plato entity) {
        PlatoDTO platoDTO = new PlatoDTO();
        platoDTO.setId(entity.getId());
        platoDTO.setNombre(entity.getNombre());
        platoDTO.setDescripcion(entity.getDescripcion());
        platoDTO.setCalorias(entity.getCalorias());
        platoDTO.getCategoria().setId(entity.getCategoria().getId());
        platoDTO.getCategoria().setNombre(entity.getCategoria().getNombre());
        platoDTO.getProcedencia().setId(entity.getProcedencia().getId());
        platoDTO.getProcedencia().setNombre(entity.getProcedencia().getNombre());
        return platoDTO;
    }
}