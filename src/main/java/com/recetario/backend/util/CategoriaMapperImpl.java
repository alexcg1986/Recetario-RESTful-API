package com.recetario.backend.util;

import com.recetario.backend.dto.CategoriaDTO;
import com.recetario.backend.model.Categoria;

import org.springframework.stereotype.Component;

@Component
public class CategoriaMapperImpl implements Mapper<Categoria, CategoriaDTO> {

    @Override
    public Categoria toEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNombre(dto.getNombre());
        return categoria;
    }

    @Override
    public CategoriaDTO toDTO(Categoria entity) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(entity.getId());
        categoriaDTO.setNombre(entity.getNombre());
        return categoriaDTO;
    }
}