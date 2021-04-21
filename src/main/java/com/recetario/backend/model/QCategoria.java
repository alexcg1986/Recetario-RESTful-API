package com.recetario.backend.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategoria is a Querydsl query type for Categoria
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategoria extends EntityPathBase<Categoria> {

    private static final long serialVersionUID = 1585740048L;

    public static final QCategoria categoria = new QCategoria("categoria");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nombre = createString("nombre");

    public final ListPath<Plato, QPlato> platos = this.<Plato, QPlato>createList("platos", Plato.class, QPlato.class, PathInits.DIRECT2);

    public QCategoria(String variable) {
        super(Categoria.class, forVariable(variable));
    }

    public QCategoria(Path<? extends Categoria> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategoria(PathMetadata metadata) {
        super(Categoria.class, metadata);
    }

}

