package com.recetario.backend.repository;

import com.recetario.backend.model.Plato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Integer>, QuerydslPredicateExecutor<Plato> {
}