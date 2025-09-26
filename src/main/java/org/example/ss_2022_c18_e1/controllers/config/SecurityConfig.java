package org.example.ss_2022_c18_e1.controllers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                .anyRequest().permitAll());

        // csrf disable
//        http.csrf(AbstractHttpConfigurer::disable); // DON'T DO THAT!!

        // you can disable just for an endpoint
//        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.ignoringRequestMatchers("/smth"));

        // when is disabled but requires for some purpose
//        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.requireCsrfProtectionMatcher())
//
//        http.csrf(httpSecurityCsrfConfigurer ->
//                httpSecurityCsrfConfigurer
//                        .csrfTokenRepository()) // we can say to Spring how to handle the token; default is handled in the session have to implement CsrfTokenRepository interface
        return http.build();
    }
}