package com.recetario.backend.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.recetario.backend.common.GenericCrudServiceImpl;
import com.recetario.backend.dto.ParametrosDTO;
import com.recetario.backend.dto.PlatoDTO;
import com.recetario.backend.model.Plato;
import com.recetario.backend.model.QPlato;
import com.recetario.backend.repository.PlatoRepository;
import com.recetario.backend.util.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PlatoServiceImpl extends GenericCrudServiceImpl<Plato, PlatoDTO, Integer> implements PlatoService {

        @Autowired
        private PlatoRepository repository;

        @Autowired
        Mapper<Plato, PlatoDTO> mapper;

        @Override
        public JpaRepository<Plato, Integer> getRepository() {
                return repository;
        }

        @Override
        public List<PlatoDTO> getAllFiltered(ParametrosDTO parametrosDTO) {
                BooleanExpression bExpression = null;
                BooleanExpression byCategoria = QPlato.plato.categoria.id.eq(parametrosDTO.getCategoriaId());
                BooleanExpression byProcedencia = QPlato.plato.procedencia.id.eq(parametrosDTO.getProcedenciaId());
                BooleanExpression byNombre = QPlato.plato.nombre.contains(parametrosDTO.getSearchString());
                BooleanExpression byDescripcion = QPlato.plato.descripcion.contains(parametrosDTO.getSearchString());
                OrderSpecifier<Integer> oSpecifier = QPlato.plato.id.asc();
                if ("".equals(parametrosDTO.getSearchString())) {
                        bExpression = parametrosDTO.getCategoriaId() != 0 && parametrosDTO.getProcedenciaId() != 0
                                        ? byCategoria.and(byProcedencia)
                                        : parametrosDTO.getCategoriaId() != 0 ? byCategoria : byProcedencia;
                } else {
                        bExpression = parametrosDTO.getCategoriaId() != 0 && parametrosDTO.getProcedenciaId() != 0
                                        ? byCategoria.and(byProcedencia).andAnyOf(byNombre.or(byDescripcion))
                                        : parametrosDTO.getCategoriaId() != 0
                                                        ? byCategoria.andAnyOf(byNombre.or(byDescripcion))
                                                        : parametrosDTO.getProcedenciaId() != 0
                                                                        ? byProcedencia.andAnyOf(
                                                                                        byNombre.or(byDescripcion))
                                                                        : byNombre.or(byDescripcion);
                }
                return StreamSupport.stream(repository.findAll(bExpression, oSpecifier).spliterator(), false)
                                .map(mapper::toDTO).collect(Collectors.toList());
        }
}