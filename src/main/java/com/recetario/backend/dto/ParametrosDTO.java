package com.recetario.backend.dto;

import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class ParametrosDTO extends EntityModel<ParametrosDTO> {

    private Integer categoriaId;
    private Integer procedenciaId;
    private String searchString;
}