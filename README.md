# 🚀 Proyecto Spring Boot con JPA, JWT y H2

Este es un proyecto base de **Spring Boot** utilizando **Spring JPA**, autenticación con **JWT**, base de datos en memoria **H2**, y construido con **Java 21** y **Maven**.

## 📌 Tecnologías utilizadas

- **Java 21** - Última versión de Java con mejoras en rendimiento y sintaxis
- **Spring Boot** - Framework para el desarrollo rápido de aplicaciones Java
- **Spring JPA** - Para la gestión de la persistencia con Hibernate
- **JWT (JSON Web Token)** - Para la autenticación segura
- **H2 Database** - Base de datos en memoria para pruebas y desarrollo
- **Maven** - Para la gestión de dependencias y construcción del proyecto

## 🏗️ Configuración del proyecto

### 📥 Clonar el repositorio
```sh
 git clone https://github.com/AlexsDarn/spring-jwt-jpa-h2
 cd tu-repositorio
```

### ⚙️ Configurar el entorno
Asegúrate de tener instalado:
- **Java 21**
- **Maven**
- **Postman o ARC** para probar la API

### 🛠️ Construir y ejecutar el proyecto
```sh
mvn clean install
mvn spring-boot:run
```

## 🔑 Autenticación con JWT

### 📤 Registro de usuario
- **Endpoint:** `POST /api/auth/register`
- **Body:**
  ```json
  {
    "username": "Usuario Ejemplo",
    "password": "password123"
  }
  ```

### 🔐 Iniciar sesión
- **Endpoint:** `POST /api/auth/login`
- **Body:**
  ```json
  {
    "username": "Usuario Ejemplo",
    "password": "password123"
  }
  ```
- **Respuesta esperada:**
  ```json
  {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
  }
  ```

### 🔒 Acceder a recursos protegidos
- **Ejemplo:** `GET /api/usuarios`
- **Header:**
  ```
  Authorization: Bearer <TOKEN>
  ```

## 🗄️ Configuración de la Base de Datos (H2)

Spring Boot viene preconfigurado para usar H2 en memoria. Puedes acceder a la consola de H2 en:

🔗 `http://localhost:8080/h2-console`

- **JDBC URL:** `jdbc:h2:mem:playlist`
- **Usuario:** `sa`
- **Contraseña:** *(vacío)*

## 📜 Licencia
Este proyecto está bajo la licencia MIT. ¡Siéntete libre de contribuir y mejorarlo!

---

💡 **Sugerencias y mejoras son bienvenidas!**

