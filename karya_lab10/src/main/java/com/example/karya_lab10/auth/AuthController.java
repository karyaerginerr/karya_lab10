package com.example.karya_lab10.auth;

import com.example.karya_lab10.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        String token = jwtService.generateToken("testuser");
        return ResponseEntity.ok(token);
    }
}
