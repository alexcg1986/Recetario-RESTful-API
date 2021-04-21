package com.recetario.backend.util;

import com.recetario.backend.dto.ProcedenciaDTO;
import com.recetario.backend.model.Procedencia;

import org.springframework.stereotype.Component;

@Component
public class ProcedenciaMapperImpl implements Mapper<Procedencia, ProcedenciaDTO> {

    @Override
    public Procedencia toEntity(ProcedenciaDTO dto) {
        Procedencia procedencia = new Procedencia();
        procedencia.setId(dto.getId());
        procedencia.setNombre(dto.getNombre());
        return procedencia;
    }

    @Override
    public ProcedenciaDTO toDTO(Procedencia entity) {
        ProcedenciaDTO procedenciaDTO = new ProcedenciaDTO();
        procedenciaDTO.setId(entity.getId());
        procedenciaDTO.setNombre(entity.getNombre());
        return procedenciaDTO;
    }
}