package io.github.app.service.impl;

import io.github.app.domain.Sala;
import io.github.app.domain.Historia;
import io.github.app.dto.StoryDTO;
import io.github.app.repository.SalaRepository;
import io.github.app.repository.HistoriaRepository;
import io.github.app.service.HistoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaServiceImpl implements HistoriaService {

    private final HistoriaRepository historiaRepository;
    private final SalaRepository salaRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public HistoriaServiceImpl(HistoriaRepository historiaRepository, SalaRepository salaRepository) {
        this.historiaRepository = historiaRepository;
        this.salaRepository = salaRepository;
    }

    @Override
    public List<Historia> adicionarStories(String codigoSala, List<StoryDTO> storyDTOS) {
        Sala sala = salaRepository.findSalaByCodigoSala(codigoSala).orElseThrow();
        List<Historia> stories = storyDTOS.stream().map(dto -> modelMapper.map(dto, Historia.class)).toList();
        return historiaRepository.saveAllAndFlush(stories);
    }

    @Override
    public List<Historia> carregarStories(String codigoSala) {
        Sala sala = salaRepository.findSalaByCodigoSala(codigoSala).orElseThrow();
        return historiaRepository.findStoriesBySalaId(sala.getId());
    }
}
