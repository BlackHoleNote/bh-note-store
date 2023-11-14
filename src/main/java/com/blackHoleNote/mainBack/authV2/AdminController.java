package com.blackHoleNote.mainBack.authV2;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final TokenService tokenService;

    @GetMapping("/api/admin/token")
    public Token createToken() {
        return tokenService.generateToken(0L, UserRole.USER);
    }

    @GetMapping("/api/admin/token/refresh")
    public Token refreshToken(@RequestParam String refreshToken) {
        if (tokenService.verifyToken(refreshToken)) {
            return tokenService.generateToken(tokenService.getUserId(refreshToken), UserRole.USER);
        }
        throw new RuntimeException("refresh token is not valid");
    }

//    @GetMapping("/api/admin/token/local")
//    public Token localToken() {
//        return tokenService.generateToken(0L, UserRole.OP);
//    }
}
