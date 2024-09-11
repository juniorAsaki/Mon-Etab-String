package com.digitalacademy.monetab.config;

import com.digitalacademy.monetab.security.LoginPageFilter;
import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(CsrfConfigurer::disable)
                .addFilterBefore(loginPageFilter(), UsernamePasswordAuthenticationFilter.class) // Ajoute le filtre avant le filtre d'authentification
                .authorizeHttpRequests((authorize) -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/icons/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/fontawesome").permitAll()
                        .requestMatchers("/img/**").permitAll()
                        .requestMatchers("/schools", "/", "settings", "/api/students/**", "/api/teachers/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((login) -> login
                        .loginPage("/connexion").permitAll()
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/connexion?error=true")
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/connexion?logout=true")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public static LoginPageFilter loginPageFilter() {
        return new LoginPageFilter();
    }
}
