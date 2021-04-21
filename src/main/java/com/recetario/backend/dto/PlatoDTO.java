package com.recetario.backend.dto;

import com.recetario.backend.model.Categoria;
import com.recetario.backend.model.Procedencia;

import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class PlatoDTO extends EntityModel<PlatoDTO> {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer calorias;
    private Categoria categoria = new Categoria();
    private Procedencia procedencia = new Procedencia();
}
