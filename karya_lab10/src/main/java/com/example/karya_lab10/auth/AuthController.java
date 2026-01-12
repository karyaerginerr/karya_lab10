package com.example.karya_lab10.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("LOGIN OK");
    }
}
