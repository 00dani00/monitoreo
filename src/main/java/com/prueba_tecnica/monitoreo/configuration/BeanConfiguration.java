package com.prueba_tecnica.monitoreo.configuration;

import com.prueba_tecnica.monitoreo.security.TokenUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {
    @Bean
    TokenUtils tokenUtils() { return new TokenUtils(); }
}