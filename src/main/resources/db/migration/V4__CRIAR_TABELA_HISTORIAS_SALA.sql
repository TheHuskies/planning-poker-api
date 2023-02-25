create table historia_sala(
     id bigserial,
     id_sala bigserial,
     id_historia bigserial,



     constraint pk_historia_sala primary key (id),
     constraint fk_historia_sala foreign key (id_historia) references historia(id),
     constraint fk_sala_historias foreign key (id_sala) references sala(id)
);