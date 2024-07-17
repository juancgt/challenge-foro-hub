package com.alura.forohub.config;

import com.alura.forohub.service.UsuarioService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialSetup {

    @Autowired
    private UsuarioService usuarioService;

    @PostConstruct
    public void setup() {
        usuarioService.crearUsuarioPorDefecto();
    }
}