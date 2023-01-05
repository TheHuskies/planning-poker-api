package io.github.app.service.impl;

import io.github.app.domain.Sala;
import io.github.app.dto.SalaDTO;
import io.github.app.repository.SalaRepository;
import io.github.app.service.SalaService;
import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SalaServiceImpl implements SalaService {

    private final SalaRepository salaRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public SalaServiceImpl(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @Override
    public Sala criarSala(SalaDTO dto) {
        Sala sala = modelMapper.map(dto, Sala.class);
        sala.setCodigoSala(RandomStringUtils.randomAlphanumeric(5));
        salaRepository.saveAndFlush(sala);
        return sala;
    }

    @Override
    public Sala buscarSala(String codigoSala) {
        return salaRepository.findSalaByCodigoSala(codigoSala).orElseThrow();
    }

    @Override
    public Sala acessarSala(String codigoSala) {
        return null;
    }
}
