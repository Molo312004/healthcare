package com.molier.HealthCare.dto;

public record UserRegisterRequest(
        String name,
        String email,
        String phone,
        String password
) {}
