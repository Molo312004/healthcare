package com.molier.HealthCare.dto;

public record UserLoginRequest(
        String email,
        String password
) {}
