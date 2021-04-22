package com.recetario.backend.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QPlato is a Querydsl query type for Plato
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlato extends EntityPathBase<Plato> {

    private static final long serialVersionUID = 1402325212L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlato plato = new QPlato("plato");

    public final NumberPath<Integer> calorias = createNumber("calorias", Integer.class);

    public final QCategoria categoria;

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nombre = createString("nombre");

    public final QProcedencia procedencia;

    public QPlato(String variable) {
        this(Plato.class, forVariable(variable), INITS);
    }

    public QPlato(Path<? extends Plato> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlato(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlato(PathMetadata metadata, PathInits inits) {
        this(Plato.class, metadata, inits);
    }

    public QPlato(Class<? extends Plato> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categoria = inits.isInitialized("categoria") ? new QCategoria(forProperty("categoria")) : null;
        this.procedencia = inits.isInitialized("procedencia") ? new QProcedencia(forProperty("procedencia")) : null;
    }

}
