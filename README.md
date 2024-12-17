# **LogisCode - Seguridad con OAuth2 y CRUD de Viajes**

## **Descripción del Proyecto**

La empresa de logística **LogisCode** busca mejorar la seguridad de su plataforma mediante la implementación de un sistema de inicio de sesión utilizando **OAuth2**. La autenticación se realizará a través de proveedores externos como **Google** o **GitHub** para garantizar la seguridad de los datos sensibles y simplificar el proceso de inicio de sesión.

Además, la aplicación permitirá gestionar las operaciones de **viajes**, **choferes** y **vehículos** mediante endpoints **CRUD** protegidos, a los cuales solo podrán acceder usuarios autenticados.

---

## **Objetivos del Proyecto**

1. Implementar un sistema de inicio de sesión mediante **OAuth2** con proveedores como Google o GitHub.
2. Configurar la aplicación para que **solo los usuarios autenticados** puedan acceder a los endpoints de la API.
3. Crear endpoints **CRUD** para gestionar las siguientes entidades:
   - **Viajes** (alta, baja, modificación y consulta)
   - **Choferes**
   - **Vehículos**
4. Garantizar la seguridad y protección de los datos en toda la aplicación.

---

## **Requisitos Técnicos**

- **Java**: JDK 17+
- **Spring Boot**: Framework principal
- **Spring Security**: Para la implementación de OAuth2 y protección de endpoints.
- **OAuth2 Providers**: Google / GitHub
- **Base de Datos**: MySQL (o H2 en memoria para pruebas locales)
- **Herramientas de Construcción**: Maven
- **IDE Sugerido**: IntelliJ IDEA o NetBeans

---

## **Estructura del Proyecto**

```plaintext
src/
  main/
    java/
      com.logiscode/
        config/             # Configuraciones de seguridad y OAuth2
        controller/         # Controladores para manejar los endpoints CRUD
        model/              # Entidades: Viaje, Chofer, Vehiculo
        repository/         # Repositorios JPA
        service/            # Lógica de negocio
        LogisCodeApplication.java  # Clase principal
    resources/
      application.properties   # Configuración de la base de datos y OAuth2
README.md                   # Documentación del proyecto

Endpoints CRUD
Todos los endpoints están protegidos por OAuth2 y solo permiten acceso a usuarios autenticados.

1. Endpoints de Viajes
POST /api/viajes - Crear un viaje.
GET /api/viajes - Obtener todos los viajes.
GET /api/viajes/{id} - Obtener un viaje por ID.
PUT /api/viajes/{id} - Actualizar un viaje.
DELETE /api/viajes/{id} - Eliminar un viaje.

2. Endpoints de Choferes
POST /api/choferes
GET /api/choferes
GET /api/choferes/{id}
PUT /api/choferes/{id}
DELETE /api/choferes/{id}

3. Endpoints de Vehículos
POST /api/vehiculos
GET /api/vehiculos
GET /api/vehiculos/{id}
PUT /api/vehiculos/{id}
DELETE /api/vehiculos/{id}
Configuración de OAuth2
Para utilizar OAuth2 con Google/GitHub:

Crear una aplicación en el Google Cloud Console o GitHub Developer Settings.
Obtener las credenciales:
Client ID
Client Secret
Configurar las credenciales en el archivo application.properties:
properties

spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
spring.security.oauth2.client.registration.github.client-id=YOUR_GITHUB_CLIENT_ID
spring.security.oauth2.client.registration.github.client-secret=YOUR_GITHUB_CLIENT_SECRET
Ejecución del Proyecto
Clonar el repositorio:

bash
git clone <URL_DEL_REPO>
cd <NOMBRE_DEL_PROYECTO>
Configurar la base de datos en application.properties.

Ejecutar la aplicación

bash
Copiar código
mvn spring-boot:run
Acceder a la aplicación en:


http://localhost:8080
Pruebas
Utiliza Postman o Swagger UI para probar los endpoints protegidos.
Verifica que solo los usuarios autenticados puedan acceder a los recursos.
Tecnologías Utilizadas
Java 17
Spring Boot
Spring Security (OAuth2)
MySQL
Maven
