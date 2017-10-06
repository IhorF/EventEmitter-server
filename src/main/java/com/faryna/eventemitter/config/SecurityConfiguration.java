package com.faryna.eventemitter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class SecurityConfiguration {



    @Value("${app.origin.url}")
    private String url;

    @Bean
    public WebMvcConfigurer CORSConfig() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(url)
                        .allowCredentials(true)
                        .allowedHeaders("Access-Control-Allow-Credentials", "Content-Type", "Access-Control-Allow-Headers", "X-Requested-With", "Origin", "Accept")
                        .allowedMethods("PUT", "DELETE", "GET", "POST");
            }
        };
    }


    /*@Bean
    public ErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes() {
            @Override
            public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
                Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
                Throwable error = getError(requestAttributes);
                if (error instanceof BadCredentialsException) {
                    errorAttributes.remove("timestamp");
                    errorAttributes.remove("exception");
                    errorAttributes.remove("path");
                }
                return errorAttributes;
            }
        };
    }*/
}