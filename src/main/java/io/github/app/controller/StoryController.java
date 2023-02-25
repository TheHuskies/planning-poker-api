package io.github.app.controller;

import io.github.app.domain.Historia;
import io.github.app.dto.StoryDTO;
import io.github.app.service.HistoriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stories")
public class StoryController {

    private final HistoriaService historiaService;

    public StoryController(HistoriaService historiaService) {
        this.historiaService = historiaService;
    }

    @PostMapping("/{codigoSala}")
    public ResponseEntity<List<Historia>> cadastrarStories(@PathVariable String codigoSala,
                                                           @RequestBody @Valid List<StoryDTO> dtos){
        List<Historia> stories = historiaService.adicionarStories(codigoSala, dtos);
        return ResponseEntity.created(URI.create("/stories")).body(stories);
    }

    @GetMapping("/{codigoSala}")
    public ResponseEntity<List<Historia>> listarStories(@PathVariable String codigoSala){
        List<Historia> stories = historiaService.carregarStories(codigoSala);
        return ResponseEntity.ok().body(stories);
    }
}
