package com.molier.HealthCare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        
        return ResponseEntity.ok(new LoginResponse("token", "user@example.com"));
    }

    public static class LoginRequest {
        public String email;
        public String password;
    }

    public static class LoginResponse {
        public String token;
        public String email;

        public LoginResponse(String token, String email) {
            this.token = token;
            this.email = email;
        }
    }
}
