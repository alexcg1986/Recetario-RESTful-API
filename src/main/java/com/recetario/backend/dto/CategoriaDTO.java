package com.recetario.backend.dto;

import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class CategoriaDTO extends EntityModel<CategoriaDTO> {

    private Integer id;
    private String nombre;
}