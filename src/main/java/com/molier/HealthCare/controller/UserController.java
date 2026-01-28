package com.molier.HealthCare.controller;

import com.molier.HealthCare.dto.UserLoginRequest;
import com.molier.HealthCare.dto.UserRegisterRequest;
import com.molier.HealthCare.dto.UserResponse;
import com.molier.HealthCare.entities.User;
import com.molier.HealthCare.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //User registration
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(
            @RequestBody UserRegisterRequest request
    ) {

        User user = userService.createUser(
                request.name(),
                request.email(),
                request.phone(),
                request.password()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(user));
    }

    //Entity to DTO conversion
    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone()
        );
    }
}
