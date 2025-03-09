package com.EduVerse.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/")  // Tüm endpoint'lere CORS izin ver
                .allowedOrigins("http://localhost:5173")  // React frontend adresi
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Hangi HTTP metotlarına izin verileceği
                .allowedHeaders("*")  // Tüm başlıklara izin ver
                .allowCredentials(true);  // Kimlik doğrulama gerektiren istekler için izin ver
    }
}