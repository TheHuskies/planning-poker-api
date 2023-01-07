package io.github.app.controller;

import io.github.app.domain.Story;
import io.github.app.dto.StoryDTO;
import io.github.app.service.StoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stories")
public class StoryController {

    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping("/{codigoSala}")
    public ResponseEntity<List<Story>> cadastrarStories(@PathVariable String codigoSala,
                                                        @RequestBody @Valid List<StoryDTO> dtos){
        List<Story> stories = storyService.adicionarStories(codigoSala, dtos);
        return ResponseEntity.created(URI.create("/stories")).body(stories);
    }

    @GetMapping("/{codigoSala}")
    public ResponseEntity<List<Story>> listarStories(@PathVariable String codigoSala){
        List<Story> stories = storyService.carregarStories(codigoSala);
        return ResponseEntity.ok().body(stories);
    }
}
