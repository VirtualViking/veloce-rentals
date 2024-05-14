package com.example.velocerentals.domain.models;

import com.example.velocerentals.domain.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
  private Long id;
  private String brand;
  private String urlImage;
  private String model;
  private Type type;
  private Double rentalPrice;
}
