# ForoHub API



## Descripción

La propuesta es construir una API REST para un foro, donde los usuarios puedan crear tópicos con sus dudas o sugerencias, interactuando dentro de una comunidad. La API permitirá listar, crear, actualizar y eliminar tópicos, con medidas de seguridad implementadas mediante JWT (JSON Web Tokens).

## Funcionalidades

- **Listar Tópicos:** Ver una lista de todos los tópicos creados por los usuarios.
- **Crear Tópicos:** Permitir a los usuarios autenticados crear nuevos tópicos.
- **Actualizar Tópicos:** Permitir a los usuarios autenticados actualizar sus propios tópicos.
- **Eliminar Tópicos:** Permitir a los usuarios autenticados eliminar sus propios tópicos.
- **Autenticación:** Implementada mediante JWT, protegiendo las rutas que permiten la creación, actualización y eliminación de tópicos.

## Endpoints

### Listar Tópicos

- **Método:** GET
- **Ruta:** `/topicos`
- **Descripción:** Obtiene una lista de todos los tópicos creados.

### Crear Tópico

- **Método:** POST
- **Ruta:** `/topicos`
- **Descripción:** Crea un nuevo tópico. Requiere autenticación.
- **Cuerpo de la petición:**
  ```json
  {
    "usuarioId": 1,
    "mensaje": "Mensaje del tópico",
    "curso": "Nombre del curso",
    "titulo": "Título del tópico"
  }
  
### Actualizar Tópico

- **Método:** PUT
- **Ruta:** `/topicos/{id}`
- **Descripción:** Actualiza un tópico existente. Requiere autenticación.
- **Cuerpo de la petición:**
  ```json
  {
    "mensaje": "Nuevo mensaje del tópico",
    "curso": "Nuevo nombre del curso",
    "titulo": "Nuevo título del tópico"
  }
  
### Eliminar Tópico

- **Método:** DELETE
- **Ruta:** `/topicos/{id}`
- **Descripción:** Elimina un tópico existente. Requiere autenticación.
- **Cuerpo de la petición:**
  ```json
  {
    "id": "ID del tópico a eliminar"
  }
  
### Autenticación

La autenticación en esta API se maneja mediante JSON Web Tokens (JWT). Para poder realizar operaciones que requieren autenticación, primero debes obtener un token JWT a través del endpoint de autenticación.

#### Autenticar Usuario

- **Método:** POST
- **Ruta:** `/login`
- **Descripción:** Autentica al usuario y genera un token JWT.
- **Cuerpo de la petición:**
  ```json
  {
    "correo_electronico": "usuario@ejemplo.com",
    "contrasena": "12345"
  }
  
## Ejecución del Proyecto

### Prerrequisitos

Asegúrate de tener instalados los siguientes programas:

- [JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [MySQL](https://dev.mysql.com/downloads/mysql/) (o cualquier otra base de datos de tu elección)

### Configuración de la Base de Datos

1. Crea una base de datos en MySQL (o en tu base de datos de elección):
   ```sql
   CREATE DATABASE forohub;

## Imagenes

![2](https://github.com/user-attachments/assets/317fe96d-9f4a-49f8-885c-ba9bf9804047)
![3](https://github.com/user-attachments/assets/2e5408d3-cd44-4fe6-96ab-21cbc233a745)
![1](https://github.com/user-attachments/assets/a0d07259-d13b-4ca1-bcd6-aefe2e57f688)


## Contribuciones
Las contribuciones son bienvenidas. Si deseas contribuir, por favor abre un issue o envía un pull request.

## Licencia
Este proyecto está bajo la Licencia MIT.

## Contacto
Para más información, puedes contactarme en juan.jose.cgt@gmail.com.

