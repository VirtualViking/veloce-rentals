package com.example.velocerentals.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.Optional;

/*Este bloque de código define una clase utilitaria llamada CookieUtil que contiene métodos para interactuar
con cookies en una aplicación web Java. Las cookies son pequeños fragmentos de datos que un servidor envía al navegador
del usuario, que el navegador puede enviar de vuelta al servidor en solicitudes posteriores*/
public class CookieUtil {

  /*Metodo getCookieByName recupera el valor de una cookie específica por su nombre.
   */
  public static Optional<?> getCookieByName(String cookieName, HttpServletRequest request) {
    Cookie[] cookies = request.getCookies() != null ? request.getCookies() : new Cookie[0];
    return Arrays.stream(cookies)
            .filter(cookie -> cookie.getName().equals(cookieName))
            .findFirst()
            .map(Cookie::getValue);
  }


  /*Metodo deleteCookieByName elimina una cookie específica por su nombre.*/
  public static void deleteCookieByName(String cookieName, HttpServletResponse response) {
    Cookie cookie = new Cookie(cookieName, "");
    cookie.setMaxAge(0);
    response.addCookie(cookie);
  }
}
