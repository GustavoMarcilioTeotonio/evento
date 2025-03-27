package com.eventos.resources;

import com.eventos.dtos.EventoDTO;
import com.eventos.models.Evento;
import com.eventos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eventos")
public class EventoResource {

    @Autowired
    private EventoService eventoService;
    @GetMapping("{id}")
    public ResponseEntity<EventoDTO> buscarEventoPorId(@PathVariable Long id) {
        Evento evento = eventoService.buscarEventoPorId(id);
        return ResponseEntity.ok(eventoService.converterEventoParaEventoDTO(evento));
    }

    @GetMapping("/buscar")
    public ResponseEntity<EventoDTO> buscarEventoPorDescricao(@RequestParam String descricao) {
        EventoDTO eventoDTO = eventoService.buscarEventoPorDescricao(descricao);
        return ResponseEntity.ok(eventoDTO);
    }

    @PostMapping()
    public ResponseEntity<EventoDTO> criarEvento(@RequestBody EventoDTO eventoDTO) {
        return ResponseEntity.ok(eventoService.salvarEvento(eventoDTO));
    }

    @PutMapping()
    public ResponseEntity<EventoDTO> atualizarEvento(@RequestBody EventoDTO eventoDTO) {
        return ResponseEntity.ok(eventoService.atualizarEvento(eventoDTO));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarEvento(@RequestBody EventoDTO eventoDTO)  {
        eventoService.deletarEvento(eventoDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
