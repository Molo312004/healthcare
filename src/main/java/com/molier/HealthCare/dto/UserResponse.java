package com.molier.HealthCare.dto;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String name,
        String email,
        String phone
) {}
