package com.example.gest_ticket.securite;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private UserDetailServices detailService;

    @Bean
    public DefaultSecurityFilterChain matcherSecurityWebFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
                    registry.requestMatchers("/apprenant/**").hasRole("FORMATEUR");
                    registry.requestMatchers("/ticket/**").permitAll();
                    registry.requestMatchers("/user/**").permitAll();
                    registry.requestMatchers("/baseConnaissace/**").hasRole("ADMIN");
                    registry.requestMatchers("/formateur/**").hasRole("ADMIN");
                    registry.requestMatchers("/categorie").hasRole("FORMATEUR");
                    registry.requestMatchers("/priorite/**").hasRole("FORMATEUR");
                    registry.anyRequest().permitAll();
                })

                .httpBasic(withDefaults());
        return httpSecurity.build();
    }

    /*@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails formateur = User.builder()
                .username("formateur")
                .password(passwordEncoder().encode("formateur"))
                .roles("FORMATEUR")
                .build();

        UserDetails apprenant = User.builder()
                .username("apprenant")
                .password(passwordEncoder().encode("apprenant"))
                .roles("APPRENANT")
                .build();

        return new InMemoryUserDetailsManager(admin, formateur, apprenant);
    }
*/
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(detailService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;

    }


    public void setUserDetailsInContext(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            // Mettre à jour le contexte avec l'authentification actuelle
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, authentication) -> {
            // Appel du service pour mettre à jour le contexte avec l'authentification réussie
            setUserDetailsInContext(authentication);


        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}