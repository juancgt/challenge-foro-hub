package com.alura.forohub.service;

import com.alura.forohub.dto.TopicoDTO;
import com.alura.forohub.dto.TopicoResponseDTO;
import com.alura.forohub.model.Curso;
import com.alura.forohub.model.Topico;
import com.alura.forohub.model.Usuario;
import com.alura.forohub.repository.TopicoRepository;
import com.alura.forohub.repository.CursoRepository;
import com.alura.forohub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Topico registrarTopico(TopicoDTO topicoDTO) {
        // Buscar el curso por nombre
        Curso curso = cursoRepository.findByNombre(topicoDTO.getNombreCurso())
                .orElseGet(() -> {
                    // Crear un nuevo curso si no se encuentra
                    Curso nuevoCurso = new Curso();
                    nuevoCurso.setNombre(topicoDTO.getNombreCurso());
                    nuevoCurso.setCategoria("Default"); // Puedes cambiar esto según sea necesario
                    return cursoRepository.save(nuevoCurso);
                });

        // Buscar el autor por ID
        Usuario autor = usuarioRepository.findById(topicoDTO.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Crear el nuevo tópico
        Topico topico = new Topico();
        topico.setTitulo(topicoDTO.getTitulo());
        topico.setMensaje(topicoDTO.getMensaje());
        topico.setCurso(curso);
        topico.setAutor(autor);
        topico.setFechaCreacion(LocalDateTime.now());
        topico.setStatus("ABIERTO");

        return topicoRepository.save(topico);
    }

    public List<TopicoResponseDTO> listarTopicos() {
        return topicoRepository.findAll().stream()
                .map(topico -> new TopicoResponseDTO(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getFechaCreacion()))
                .collect(Collectors.toList());
    }

    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
    }

    public Topico actualizarTopico(Long id, TopicoDTO topicoDTO) {
        Topico topicoExistente = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado con ID: " + id));

        // Actualizar los campos del tópico existente con los datos del DTO
        topicoExistente.setTitulo(topicoDTO.getTitulo());
        topicoExistente.setMensaje(topicoDTO.getMensaje());
        topicoExistente.setStatus(topicoDTO.getStatus());
        // Actualizar otros campos según sea necesario

        // Guardar y devolver el tópico actualizado
        return topicoRepository.save(topicoExistente);
    }
}