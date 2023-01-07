package io.github.app.service;

import io.github.app.domain.Story;
import io.github.app.dto.StoryDTO;

import java.util.List;

public interface StoryService {

    List<Story> adicionarStories(String codigoSala, List<StoryDTO> storyDTOS);
    List<Story> carregarStories(String codigoSala);

}
