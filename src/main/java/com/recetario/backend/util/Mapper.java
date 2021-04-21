package com.recetario.backend.util;

import org.springframework.stereotype.Component;

@Component
public interface Mapper<Entity, DTO> {

    Entity toEntity(DTO dto);

    DTO toDTO(Entity entity);
}