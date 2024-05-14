package com.example.velocerentals.domain.dtos;

import com.example.velocerentals.domain.enums.Type;

public record CreateVehicleDTO( /*Clase record que define datos con valores
y que no podran ser cambiados (inmutables)*/
    String brand,
    String urlImage,
    String model,
    Type type,
    Double rentalPrice
) {
}
