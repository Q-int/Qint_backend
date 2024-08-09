package org.example.qint_backend.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.qint_backend.global.security.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import lombok.RequiredArgsConstructor;
import org.springframework.web.cors.CorsConfigurationSource;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity, CorsConfigurationSource corsConfigurationSource) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)

                .cors(cors -> cors.configurationSource(corsConfigurationSource))

                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))

                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers("/auth/**")
                        .permitAll()

                        .anyRequest()
                        .authenticated())

                .with(new FilterConfig(jwtTokenProvider, objectMapper), Customizer.withDefaults());

        return httpSecurity.build();
    }
}