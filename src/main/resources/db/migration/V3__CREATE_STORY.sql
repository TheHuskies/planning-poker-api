create table story(
    id bigserial,
    titulo text not null,
    descricao text,
    sala_id bigint,

    constraint pk_story primary key (id)
);