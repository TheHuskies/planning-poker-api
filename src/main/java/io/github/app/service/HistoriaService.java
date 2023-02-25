package io.github.app.service;

import io.github.app.domain.Historia;
import io.github.app.dto.StoryDTO;

import java.util.List;

public interface HistoriaService {

    List<Historia> adicionarStories(String codigoSala, List<StoryDTO> storyDTOS);
    List<Historia> carregarStories(String codigoSala);

}
