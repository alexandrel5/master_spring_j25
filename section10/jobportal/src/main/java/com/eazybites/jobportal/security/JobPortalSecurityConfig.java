package com.eazybites.jobportal.security;

import org.springframework.boot.security.autoconfigure.web.servlet.SecurityFilterProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class JobPortalSecurityConfig {

    @Bean
    @Order(SecurityFilterProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain customSecurityFilterChain(HttpSecurity http) {
        return http.csrf(csrfConfig -> csrfConfig.disable())
                .authorizeHttpRequests((requests) ->
//                        requests.requestMatchers("/api/companies/public").permitAll()
//                            .requestMatchers("/api/contacts/public").permitAll())
                        requests.requestMatchers(RegexRequestMatcher.regexMatcher(".*public$")).permitAll())
                        .formLogin(flc -> flc.disable())//to disable form login use flc -> flc.disable()
                        .httpBasic(withDefaults())//To disable httpBasic use hbc -> hbc.disable()
                        .build();

    }
}
