package com.blackHoleNote.mainBack.authV2;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.Arrays;

@RequiredArgsConstructor
public class JwtAuthFilter extends GenericFilterBean {
    private final TokenService tokenService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String bearerToken = ((HttpServletRequest)request).getHeader("Authorization");
        if (validateBearer(bearerToken)) {
            String token = extractToken(bearerToken);
            if (tokenService.verifyToken(token)) {
                Long userId = tokenService.getUserId(token);

                // DB연동을 안했으니 이메일 정보로 유저를 만들어주겠습니다
                SimpleUserDto userDto = new SimpleUserDto(userId);

                Authentication auth = getAuthentication(userDto);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        chain.doFilter(request, response);
    }

    private boolean validateBearer(String target) {
        return target != null && target.startsWith("Bearer ") && target.length() > "Bearer ".length();
    }

    private String extractToken(String authorizationHeader) {
        return authorizationHeader.substring("Bearer ".length());
    }
    public Authentication getAuthentication(SimpleUserDto user) {
        return new UsernamePasswordAuthenticationToken(user, "", Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}