package io.github.app.service.impl;

import io.github.app.domain.Sala;
import io.github.app.domain.Story;
import io.github.app.dto.StoryDTO;
import io.github.app.repository.SalaRepository;
import io.github.app.repository.StoryRepository;
import io.github.app.service.StoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    private final SalaRepository salaRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public StoryServiceImpl(StoryRepository storyRepository, SalaRepository salaRepository) {
        this.storyRepository = storyRepository;
        this.salaRepository = salaRepository;
    }

    @Override
    public List<Story> adicionarStories(String codigoSala, List<StoryDTO> storyDTOS) {
        Sala sala = salaRepository.findSalaByCodigoSala(codigoSala).orElseThrow();
        List<Story> stories = storyDTOS.stream().map(dto -> modelMapper.map(dto, Story.class)).toList();
        stories.forEach(story -> story.setSalaId(sala.getId()));
        return storyRepository.saveAllAndFlush(stories);
    }

    @Override
    public List<Story> carregarStories(String codigoSala) {
        Sala sala = salaRepository.findSalaByCodigoSala(codigoSala).orElseThrow();
        return storyRepository.findStoriesBySalaId(sala.getId());
    }
}
