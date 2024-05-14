package com.example.velocerentals.repositories.search_criteria;

import com.example.velocerentals.domain.enums.Type;

import java.time.LocalDateTime;


public class VehicleSearchCriteria {
  public String brand;
  public String model;
  public Type type;
  public Double minRentalPrice;
  public Double maxRentalPrice;
  public LocalDateTime startDate;
  public LocalDateTime endDate;
}
