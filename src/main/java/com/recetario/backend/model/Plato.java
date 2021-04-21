package com.recetario.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "plato")
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 50, unique = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 2000, unique = false)
    private String descripcion;
    @Column(name = "calorias", nullable = false, unique = false)
    private Integer calorias;
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria = new Categoria();
    @ManyToOne(fetch = FetchType.LAZY)
    private Procedencia procedencia = new Procedencia();
}