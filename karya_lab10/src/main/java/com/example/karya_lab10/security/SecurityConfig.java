package com.example.karya_lab10.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // REST API olduğu için CSRF kapalı
                .csrf(csrf -> csrf.disable())

                // Session yok, JWT mantığına hazırlık
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Endpoint yetkilendirme
                .authorizeHttpRequests(auth -> auth
                        // 👇 HERKESE AÇIK OLANLAR
                        .requestMatchers(
                                "/auth/**",
                                "/api/info",
                                "/api/register",
                                "/hello"
                        ).permitAll()

                        // 👇 DİĞER HER ŞEY KORUMALI
                        .anyRequest().authenticated()
                )

                // Default login kapalı
                .formLogin(form -> form.disable())

                // Basic auth kapalı
                .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
