package io.github.app.controller;

import io.github.app.domain.Sala;
import io.github.app.dto.SalaDTO;
import io.github.app.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @PostMapping
    public ResponseEntity<Sala> criarSala(@RequestBody @Valid SalaDTO dto){
        Sala sala = salaService.criarSala(dto);
        return ResponseEntity.created(URI.create("/salas")).body(sala);
    }

    @GetMapping("/{codigoSala}")
    public ResponseEntity<Sala> buscarSala(@PathVariable String codigoSala){
        Sala sala = salaService.buscarSala(codigoSala);
        return ResponseEntity.accepted().body(sala);
    }
}
