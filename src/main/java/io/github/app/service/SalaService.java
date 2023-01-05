package io.github.app.service;

import io.github.app.domain.Sala;
import io.github.app.dto.SalaDTO;

public interface SalaService {

    Sala criarSala(SalaDTO dto);
    Sala buscarSala(String codigoSala);
    Sala acessarSala(String codigoSala);

}
