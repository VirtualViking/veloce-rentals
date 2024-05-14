package com.example.velocerentals.domain.models;

import java.time.LocalDateTime;

public class Rental {
  private Long id;
  private User user;
  private Vehicle vehicle;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Double totalPrice;

}
