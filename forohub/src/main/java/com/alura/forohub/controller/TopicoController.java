package com.alura.forohub.controller;

import com.alura.forohub.dto.TopicoDTO;
import com.alura.forohub.dto.TopicoResponseDTO;
import com.alura.forohub.model.Topico;
import com.alura.forohub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<TopicoResponseDTO> listarTopicos() {
        return topicoService.listarTopicos();
    }

    @PostMapping
    public ResponseEntity<Topico> registrarTopico(@RequestBody TopicoDTO topicoDTO, UriComponentsBuilder uriBuilder) {
        Topico nuevoTopico = topicoService.registrarTopico(topicoDTO);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(nuevoTopico.getId()).toUri();
        return ResponseEntity.created(uri).body(nuevoTopico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody TopicoDTO topicoDTO) {
        Topico topicoActualizado = topicoService.actualizarTopico(id, topicoDTO);
        return ResponseEntity.ok(topicoActualizado);
    }
}