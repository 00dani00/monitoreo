# Backend para Monitoreo de Comportamiento de Usuarios

## Descripción General

Este proyecto implementa el backend para una aplicación centrada en monitorear el comportamiento de los usuarios dentro de una plataforma digital. La aplicación utiliza Java con Spring Boot y una base de datos PostgreSQL. La arquitectura sigue un enfoque de microservicios, donde cada endpoint tiene una función específica.

## Estructura del Proyecto

El proyecto está organizado en varias capas:

- **Controlador (Controller):** Gestiona las peticiones HTTP y dirige el flujo a los servicios correspondientes.
- **Servicio (Service):** Lógica de negocio, implementa las reglas específicas de la aplicación.
- **Repositorio (Repository):** Capa de acceso a la base de datos utilizando Spring Data JPA.
- **Otros Paquetes:**
  - **Configuration:** Configuraciones específicas de Spring Boot.
  - **Security:** Configuración de Spring Security para autenticación y autorización.
  - **Modelos:** Definición de entidades y DTOs.

## Configuración de Base de Datos

Para evitar conflictos con la base de datos y considerando la sensibilidad de PostgreSQL a mayúsculas y minúsculas, se han configurado las estrategias de nomenclatura de Hibernate de la siguiente manera:

```properties
spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```
## Seguridad

Se ha implementado Spring Security para autenticar a los usuarios y restringir el acceso basándose en roles. Los endpoints están protegidos y solo accesibles con roles específicos.

## Consultas Avanzadas

Para consultas más avanzadas, se ha utilizado la anotación `@Query` de Spring Data JPA. Esto permite definir consultas específicas dentro de los repositorios.

## Dockerización

La solución está dockerizada para facilitar su implementación y ejecución. Sigue los siguientes pasos para ejecutar la solución:

1. **Construir la imagen del contenedor:**

    ```bash
    docker build -t nombre_de_la_imagen .
    ```

2. **Ejecutar el contenedor:**

    ```bash
    docker run -p 8080:8080 nombre_de_la_imagen
    ```

## Despliegue en AWS

### Despliegue en AWS Lambda

Para desplegar en AWS Lambda, sigue estos pasos:

1. Empaqueta tu aplicación como un archivo JAR ejecutable.
2. Crea una función de AWS Lambda.
Asociar una API Gateway
Si deseas exponer tu función Lambda como un servicio web, puedes asociar una API Gateway:
- En la Consola de AWS, ve a "API Gateway".
- Crea una nueva API.
- Crea un recurso y un método que apunta a tu función Lambda.
- Despliega tu API para generar una URL pública.

3. Sube tu archivo JAR como el código de la función Lambda.
4. Configura los detalles de la función y establece el handler de la función.

### Despliegue en AWS ECS

Para desplegar en AWS ECS (Elastic Container Service), sigue estos pasos:

1. Empaqueta tu aplicación como una imagen de Docker.
2. Sube tu imagen a un registro de Docker compatible con ECS (como Amazon ECR).
3. Crea una tarea y un servicio en ECS.
4. Asocia el servicio con la imagen de Docker que subiste.
