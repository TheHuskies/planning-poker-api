package io.github.app.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "sala", schema = "planning_poker")
public class Sala {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo_sala")
    private String codigoSala;
    @Column(name = "administrador")
    private String administrador;
    @Column(name = "numero_participantes")
    private Integer numeroParticipantes;
    @Column(name = "metodologia")
    private String metodologia;


}
