package com.recetario.backend.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProcedencia is a Querydsl query type for Procedencia
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProcedencia extends EntityPathBase<Procedencia> {

    private static final long serialVersionUID = 1701374650L;

    public static final QProcedencia procedencia = new QProcedencia("procedencia");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nombre = createString("nombre");

    public final ListPath<Plato, QPlato> platos = this.<Plato, QPlato>createList("platos", Plato.class, QPlato.class, PathInits.DIRECT2);

    public QProcedencia(String variable) {
        super(Procedencia.class, forVariable(variable));
    }

    public QProcedencia(Path<? extends Procedencia> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProcedencia(PathMetadata metadata) {
        super(Procedencia.class, metadata);
    }

}

