package com.pruebaTecnica.Buses.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Value("${app.security.user.name}")
    private String username;

    @Value("${app.security.user.password}")
    private String password;

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        var user = User.withUsername(username)
                .password(password)
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
        .requestMatchers(org.springframework.http.HttpMethod.OPTIONS, "/**").permitAll()
        .requestMatchers("/bus/**").authenticated()
        .anyRequest().permitAll()
        )
        .httpBasic(Customizer.withDefaults());
    return http.build();
    }
}
