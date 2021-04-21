package com.recetario.backend.repository;

import com.recetario.backend.model.Procedencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedenciaRepository extends JpaRepository<Procedencia, Integer> {
}