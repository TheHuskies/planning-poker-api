create table historia(
    id bigserial,
    titulo text not null,
    descricao text,

    constraint pk_historias primary key (id)
);