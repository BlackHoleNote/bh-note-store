package com.blackHoleNote.mainBack.authV2;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserJPARepository userRepository;
    private final OAuth2SuccessHandler successHandler;
    private final OAuth2FailHandler failHandler;
    private final TokenService tokenService;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "v2/api-docs",
            "/swagger-resources",
            "swagger-resources",
            "/swagger-resources/**",
            "swagger-resources/**",
            "/configuration/ui",
            "configuration/ui",
            "/configuration/security",
            "configuration/security",
            "/swagger-ui.html",
            "swagger-ui.html",
            "webjars/**",
            // -- Swagger UI v3
            "/v3/api-docs/**",
            "v3/api-docs/**",
            "/swagger-ui/**",
            "swagger-ui/**",
            // CSA Controllers
            "/csa/api/token",
            // Actuators
            "/actuator/**",
            "/health/**",
            "/loggers/**",
            "/loggers",
            // other public endpoints of your API may be appended to this array
            "/api/admin/token",
            "/api/admin/token/*",
            // Login Page
            ""
    };

    @Bean
    public CustomOAuth2UserService getCustomOAuth2UserService() {
        return new CustomOAuth2UserService(userRepository);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable()
                .cors().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
            .authorizeHttpRequests()
                    .requestMatchers(AUTH_WHITELIST).permitAll()
                    .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                    .anyRequest().authenticated()	// 어떠한 요청이라도 인증필요
                    .and()
                // 인증만료 처리
//                .authorizeRequests()V
//                .antMatchers("/token/**").permitAll()
//                .anyRequest().authenticated()
            .oauth2Login(oauth2Configurer -> {
                        oauth2Configurer.userInfoEndpoint().userService(getCustomOAuth2UserService());
                        DefaultAuthorizationCodeTokenResponseClient tokenResponseClient = new DefaultAuthorizationCodeTokenResponseClient();
                        oauth2Configurer.tokenEndpoint().accessTokenResponseClient(tokenResponseClient);
                        oauth2Configurer.successHandler(successHandler);
                        oauth2Configurer.failureHandler(failHandler);
                    }
            )
            .addFilterBefore(new JwtAuthFilter(tokenService), UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}