package com.raim.demo_crud_thymeleaf.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(configurer ->
                        configurer
                                .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/showLoginPage")  // Correct path
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")  // Set the logout URL
                        .logoutSuccessUrl("/login?logout")  // Redirect to login page with logout success message
                        .permitAll())  // Allow logout for unauthorized users
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                )
                .build();
    }
}
