create schema if not exists planning_poker;

create table sala(
     id bigserial,
     codigo_sala text not null,
     administrador text not null,
     numero_participantes numeric not null,
     metodologia text not null,

     constraint pk_sala primary key (id)
);