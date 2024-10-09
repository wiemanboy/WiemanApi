package com.wiemanboy.wiemanapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/services/profiles/actuator/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/profiles/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/profiles/{name}/{locale}").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2Login -> oauth2Login
                        .defaultSuccessUrl("/services/profiles/docs/")
                        .failureUrl("/")
                );
        return http.build();
    }
}
