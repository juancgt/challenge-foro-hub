# ForoHub API
¡Hola! Bienvenidos y bienvenidas a un nuevo desafío. En esta oportunidad, vamos a poner en práctica los conocimientos adquiridos en Java y Spring Boot.

## Descripción
La propuesta es construir una API REST para un foro, donde los usuarios puedan crear tópicos con sus dudas o sugerencias, interactuando dentro de una comunidad. La API permitirá listar, crear, actualizar y eliminar tópicos, con medidas de seguridad implementadas mediante JWT (JSON Web Tokens).

## Funcionalidades
Listar Tópicos: Ver una lista de todos los tópicos creados por los usuarios.
Crear Tópicos: Permitir a los usuarios autenticados crear nuevos tópicos.
Actualizar Tópicos: Permitir a los usuarios autenticados actualizar sus propios tópicos.
Eliminar Tópicos: Permitir a los usuarios autenticados eliminar sus propios tópicos.
Autenticación: Implementada mediante JWT, protegiendo las rutas que permiten la creación, actualización y eliminación de tópicos.
# Endpoints
## Listar Tópicos
Método: GET
Ruta: /topicos
Descripción: Obtiene una lista de todos los tópicos creados.
## Crear Tópico
Método: POST
Ruta: /topicos
Descripción: Crea un nuevo tópico. Requiere autenticación.
Cuerpo de la petición:
json
Copy code
{
  "usuarioId": 1,
  "mensaje": "Mensaje del tópico",
  "curso": "Nombre del curso",
  "titulo": "Título del tópico"
}
## Actualizar Tópico
Método: PUT
Ruta: /topicos/{id}
Descripción: Actualiza un tópico existente. Requiere autenticación.
Cuerpo de la petición:
json
Copy code
{
  "mensaje": "Nuevo mensaje del tópico",
  "curso": "Nuevo nombre del curso",
  "titulo": "Nuevo título del tópico"
}
## Eliminar Tópico
Método: DELETE
Ruta: /topicos/{id}
Descripción: Elimina un tópico existente. Requiere autenticación.
## Autenticación
Método: POST
Ruta: /login
Descripción: Autentica al usuario y genera un token JWT.
Cuerpo de la petición:
json
Copy code
{
  "correo_electronico": "user@example.com",
  "contrasena": "password"
}
## Ejecución del Proyecto
Clonar el repositorio:

bash
Copy code
git clone https://github.com/tu-usuario/forohub-api.git
cd forohub-api
Configurar la base de datos:
Edita el archivo application.properties o application.yml con la configuración de tu base de datos.

Ejecutar la aplicación:

bash
Copy code
./mvnw spring-boot:run
Probar los endpoints:
Utiliza una herramienta como Insomnia o Postman para interactuar con la API.

## Creación de un Usuario por Defecto
Para crear un usuario por defecto al iniciar la aplicación, hemos implementado la clase InitialSetup que se ejecuta al inicializar el contexto de la aplicación.

java
Copy code
package com.alura.forohub.infra.security;

import com.alura.forohub.modelo.Usuario;
import com.alura.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class InitialSetup {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void setup() {
        if (!usuarioRepository.existsByCorreoElectronico("admin@example.com")) {
            Usuario usuario = new Usuario();
            usuario.setCorreoElectronico("admin@example.com");
            usuario.setContrasena(passwordEncoder.encode("admin123"));
            usuario.setNombre("Admin");
            usuarioRepository.save(usuario);
        }
    }
}
## Contribuciones
Las contribuciones son bienvenidas. Si deseas contribuir, por favor abre un issue o envía un pull request.

## Licencia
Este proyecto está bajo la Licencia MIT.

## Contacto
Para más información, puedes contactarme en juan.jose.cgt@gmail.com
