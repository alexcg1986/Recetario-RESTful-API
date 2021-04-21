package com.recetario.backend.dto;

import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class ProcedenciaDTO extends EntityModel<ProcedenciaDTO> {

    private Integer id;
    private String nombre;
}