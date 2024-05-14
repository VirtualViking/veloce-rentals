package com.example.velocerentals.services;

import com.example.velocerentals.domain.dtos.UserSignupDTO;

/*Se define una interfaz llamada AuthService. Una interfaz en Java es un contrato que especifica
los métodos que una clase debe implementar. En este caso, AuthService especifica dos métodos relacionados con
la autenticación de usuarios.*/

public interface AuthService {

  /*: Este método se utiliza para autenticar a un usuario en el sistema*/
  boolean login(String email, String password);

  /*Este método se utiliza para registrar a un nuevo usuario en el sistema*/
  boolean signUp(UserSignupDTO userSignupDTO);
}
