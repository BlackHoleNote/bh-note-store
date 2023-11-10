package com.blackHoleNote.mainBack.authV2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2FailHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
    }

    public String extractDebugInfo(HttpServletRequest request) {
        StringBuilder debugInfo = new StringBuilder();

        // Request Method and URI
        debugInfo.append("HTTP Method: ").append(request.getMethod()).append("\n");
        debugInfo.append("Request URI: ").append(request.getRequestURI()).append("\n");

        // Domain (or Host)
        debugInfo.append("Domain: ").append(request.getServerName()).append("\n");

        // Headers
        debugInfo.append("Headers:\n");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            debugInfo.append(headerName).append(": ").append(request.getHeader(headerName)).append("\n");
        }

        // Parameters
        debugInfo.append("Parameters:\n");
        request.getParameterMap().forEach((key, value) -> debugInfo.append(key).append(": ").append(String.join(",", value)).append("\n"));

        // Body (assuming character data in the body, not binary data)
        debugInfo.append("Body:\n");
        StringBuilder body = new StringBuilder();
        try {
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                body.append(line).append("\n");
            }
        } catch (Exception e) {
            body.append("Failed to read body: ").append(e.getMessage());
        }
        debugInfo.append(body);

        return debugInfo.toString();
    }
}
