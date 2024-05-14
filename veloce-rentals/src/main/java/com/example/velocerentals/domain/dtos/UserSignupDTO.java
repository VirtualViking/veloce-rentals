package com.example.velocerentals.domain.dtos;
public record UserSignupDTO(
        String firstName,
        String lastName,
        String email,
        String password

) {
}
