create table participante(
    id bigserial,
    nome text not null,
    cargo text not null,

    constraint pk_participante primary key (id)
);