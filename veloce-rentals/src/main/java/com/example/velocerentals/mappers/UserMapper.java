package com.example.velocerentals.mappers;

import com.example.velocerentals.domain.dtos.UserSignupDTO;
import com.example.velocerentals.domain.models.User;

public class UserMapper {

  /*Define una clase UserMapper que tiene un método estático llamado toDomain(). El propósito de esta clase es
  convertir un objeto de transferencia de datos (DTO) de registro de usuario (UserSignupDTO)
  en un objeto de dominio de usuario (User).*/
  public static User toDomain(UserSignupDTO dto){

    /*Se define un método estático llamado toDomain(UserSignupDTO dto). Este método toma un objeto de transferencia
  de datos UserSignupDTO como parámetro y devuelve un objeto de dominio User.*/

    /*Dentro del método toDomain(), se crea un nuevo objeto User utilizando los datos del DTO*/
    return new User(null, dto.firstName(), dto.lastName(), dto.email(), dto.password());

    /*Se devuelve el objeto User creado.*/
  }
}
