package com.example.velocerentals.mappers;

import com.example.velocerentals.domain.dtos.CreateVehicleDTO;
import com.example.velocerentals.domain.dtos.VehicleOutDTO;
import com.example.velocerentals.domain.models.Vehicle;

public class VehicleMapper {
  public static Vehicle toEntity(VehicleOutDTO vehicleOutDTO) {
        return new Vehicle(
                vehicleOutDTO.id(),
                vehicleOutDTO.brand(),
                vehicleOutDTO.urlImage(),
                vehicleOutDTO.model(),
                vehicleOutDTO.type(),
                vehicleOutDTO.rentalPrice()
        );
  }
  public static Vehicle toEntity(CreateVehicleDTO vehicleOutDTO) {
    return new Vehicle(
            null,
            vehicleOutDTO.brand(),
            vehicleOutDTO.urlImage(),
            vehicleOutDTO.model(),
            vehicleOutDTO.type(),
            vehicleOutDTO.rentalPrice()
    );
  }
    public static VehicleOutDTO toDTO(Vehicle vehicle) {
        return new VehicleOutDTO(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getUrlImage(),
                vehicle.getModel(),
                vehicle.getType(),
                vehicle.getRentalPrice()
        );
    }
}
