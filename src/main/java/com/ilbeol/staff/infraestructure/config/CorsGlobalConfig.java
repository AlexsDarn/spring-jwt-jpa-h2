package com.ilbeol.staff.infraestructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableWebMvc
public class CorsGlobalConfig implements WebMvcConfigurer {
/*
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Aplica a todas las rutas
                .allowedOrigins("http://localhost:4200") // Permitir el frontend Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("Authorization", "*") // Permitir todos los headers
                .allowCredentials(true); // Permitir credenciales
    }*/
}
