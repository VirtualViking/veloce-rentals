package com.example.velocerentals.services.imp;

import com.example.velocerentals.domain.dtos.UserSignupDTO;
import com.example.velocerentals.domain.models.User;
import com.example.velocerentals.mappers.UserMapper;
import com.example.velocerentals.repositories.UserRepository;
import com.example.velocerentals.services.AuthService;

import java.util.Optional;

/*Se muestra una implementación de la interfaz AuthService, llamada AuthServiceImp.
Esta clase proporciona funcionalidades con la autenticación de usuarios, como inicio de sesión y registro.*/

public class AuthServiceImp implements AuthService {

  private final UserRepository userRepository;

  /*Se define un campo userRepository, que es del tipo UserRepository. Este campo se utiliza para interactuar con la
  capa de persistencia para acceder y manipular datos de usuario en la base de datos*/

  public AuthServiceImp(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /*Se define un constructor que toma un parámetro UserRepository y lo utiliza para inicializar
  el campo userRepository.*/

  @Override
  public boolean login(String email, String password) {
    Optional<User> user = userRepository.findByEmail(email);
    return user.isPresent() && user.get().getPassword().equals(password);
  }

  /*El método login(String email, String password) de la interfaz AuthService. Este método verifica si un
  usuario con el correo electrónico dado y la contraseña correspondiente existe en la base de datos.*/

  /*Se llama al método findByEmail(email) del repositorio de usuarios (userRepository) para obtener un
  Optional que potencialmente contiene al usuario con el correo electrónico dado.*/

  @Override
  public boolean signUp(UserSignupDTO userSignupDTO) {

    /*El método signUp(UserSignupDTO userSignupDTO) de la interfaz AuthService.
    Este método se utiliza para registrar a un nuevo usuario en la aplicación.*/

    return userRepository.save(UserMapper.toDomain(userSignupDTO));

    /*Utiliza UserMapper.toDomain(userSignupDTO) para convertir el DTO de registro de usuario (UserSignupDTO)
    en un objeto de dominio de usuario (User). Llama al método save() del repositorio de usuarios (userRepository)
    para guardar al usuario en la base de datos.*/
  }
}

/*AuthServiceImp es una implementación de la interfaz AuthService que proporciona métodos para iniciar sesión y
registrarse en la aplicación utilizando un repositorio de usuarios (UserRepository)*/