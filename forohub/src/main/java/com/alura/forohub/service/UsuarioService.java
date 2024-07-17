package com.alura.forohub.service;

import com.alura.forohub.model.Usuario;
import com.alura.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder; // Asegúrate de tener configurado un bean PasswordEncoder

    @Autowired
    private UsuarioRepository usuarioRepository; // Repositorio de usuarios

    public void crearUsuarioPorDefecto() {
        // Verificar si ya existe un usuario por defecto
        if (usuarioRepository.existsByCorreoElectronico("usuario@ejemplo.com")) {
            return; // Si ya existe, no hacer nada
        }

        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setCorreoElectronico("usuario@ejemplo.com");
        usuario.setNombre("Usuario Por Defecto");
        // Establecer una contraseña encriptada
        usuario.setContrasena(passwordEncoder.encode("12345")); // Reemplaza "password" por la contraseña encriptada

        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);
    }
}