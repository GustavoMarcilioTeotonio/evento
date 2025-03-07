package com.eventos.resources;

import com.eventos.dtos.CidadeDTO;
import com.eventos.models.Cidade;
import com.eventos.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cidades")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;
    @GetMapping("{id}")
    public ResponseEntity<CidadeDTO> buscarCidadePorId(@PathVariable Long id) {
        Cidade cidade = cidadeService.buscarCidadePorId(id);
        return ResponseEntity.ok(cidadeService.converterCidadeParaCidadeDTO(cidade));
    }

    @GetMapping("/buscar")
    public ResponseEntity<CidadeDTO> buscarCidadePorNome(@RequestParam String nome) {
        CidadeDTO cidadeDTO = cidadeService.buscarCidadePorNome(nome);
        return ResponseEntity.ok(cidadeDTO);
    }

    @PostMapping()
    public ResponseEntity<CidadeDTO> criarCidade(@RequestBody CidadeDTO cidadeDTO) {
        return ResponseEntity.ok(cidadeService.salvarCidade(cidadeDTO));
    }

    @PutMapping()
    public ResponseEntity<CidadeDTO> atualizarCidade(@RequestBody CidadeDTO cidadeDTO) {
        return ResponseEntity.ok(cidadeService.atualizarCidade(cidadeDTO));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarCidade(@RequestBody CidadeDTO cidadeDTO)  {
        cidadeService.deletarCidade(cidadeDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
