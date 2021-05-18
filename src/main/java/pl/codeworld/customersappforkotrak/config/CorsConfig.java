package pl.codeworld.customersappforkotrak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST", "GET", "OPTIONS", "PUT", "DELETE")
//                        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
//                                "Access-Control-Request-Headers", "Access-Control-Request-Credentials")
//                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Access-Control-Allow-Credentials")
//                        .allowCredentials(true).maxAge(3600);;
//            }
/////////////////////////////////////////////
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE")
//                        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
//                                "Access-Control-Request-Headers", "Access-Control-Request-Credentials")
//                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Access-Control-Allow-Credentials")
//                        .allowCredentials(true).maxAge(3600);
//            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "PATCH", "OPTIONS")
                        .allowCredentials(true);
            }
        };
    }
}
