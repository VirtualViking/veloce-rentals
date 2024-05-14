package com.example.velocerentals.utils;

import jakarta.servlet.http.HttpSession;

import java.util.Optional;

/*Se define una clase utilitaria llamada SessionUtil que contiene un
método estático para obtener el nombre de usuario almacenado en una sesión HTTP.*/
public class SessionUtil {

    /* Metodo getUserName recupera el nombre de usuario almacenado en una sesión HTTP, si está presente.*/
 public static Optional<String> getUsername(HttpSession session) {
   return Optional.ofNullable((String) session.getAttribute("username"));

   /*session.getAttribute("username") obtiene el atributo con el nombre "username" de la sesión.*/

   /*Devuelve un Optional<String> que contiene el nombre de usuario si está presente en la sesión*/
 }
}
