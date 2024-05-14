package com.example.velocerentals.domain.dtos;

import com.example.velocerentals.domain.enums.Type;

public record VehicleOutDTO(
    Long id,
    String brand,
    String urlImage,
    String model,
    Type type,
    Double rentalPrice

) {
}
