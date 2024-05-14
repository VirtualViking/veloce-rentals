package com.example.velocerentals.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
}
