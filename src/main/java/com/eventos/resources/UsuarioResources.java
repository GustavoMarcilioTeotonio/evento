package com.eventos.resources;

import com.eventos.dtos.UsuarioDTO;
import com.eventos.models.Usuario;
import com.eventos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResources {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> BuscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuarioDTO = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuarioService.converterUsuarioParaUsuarioDTO(usuarioDTO));

    }

    @GetMapping("/buscar")
    public ResponseEntity<UsuarioDTO> BuscarUsuarioPorEmail(@RequestParam String email) {
        Usuario usuarioDTO = usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok(usuarioService.converterUsuarioParaUsuarioDTO(usuarioDTO));
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
       usuarioDTO = usuarioService.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }



}
