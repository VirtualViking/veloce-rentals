package com.example.velocerentals.repositories;

import com.example.velocerentals.domain.models.User;

import java.util.Optional;

/*Define una interfaz llamada UserRepository, que especifica los métodos que deben implementarse
para gestionar la persistencia de objetos User. En una aplicación, un repositorio actúa como una capa de
 abstracción entre la aplicación y la base de datos, proporcionando operaciones CRUD */
public interface UserRepository {

  /*La interfaz UserRepository define los métodos que cualquier clase que implemente esta interfaz debe proporcionar.
  Estos métodos están relacionados con la persistencia y recuperación de objetos User.*/
  boolean save (User user); /*Este método toma un objeto User como parámetro y devuelve un valor booleano.*/
  boolean update (User user);
  Optional<User> findByEmail (String email);

  /*Este método toma una cadena de texto (String) que representa el correo electrónico de un usuario y
  devuelve un Optional<User>. Este método es encontrar y recuperar un usuario de la base de datos utilizando
  su correo electrónico*/

}
