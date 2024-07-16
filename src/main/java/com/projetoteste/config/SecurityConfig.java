package com.projetoteste.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

	   @SuppressWarnings({ "deprecation", "removal" })
	@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable() // Desabilitar CSRF se não for necessário para o seu caso de uso
	            .authorizeRequests(authorizeRequests ->
	                authorizeRequests
	                    .anyRequest().permitAll() // Permitir todas as requisições sem autenticação
	            );
	        return http.build();
	    }
}
