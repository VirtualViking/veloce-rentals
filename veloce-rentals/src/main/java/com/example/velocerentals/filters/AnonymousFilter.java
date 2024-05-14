package com.example.velocerentals.filters;

import com.example.velocerentals.utils.CookieUtil;
import com.example.velocerentals.utils.SessionUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

/*Clase AnonymousFilter que implementa la interfaz Filter. Los filtros en Java EE se utilizan para interceptar y manipular
tanto las solicitudes entrantes como las respuestas salientes en una aplicación web
 */

@WebFilter(filterName = "anonymousFilter", urlPatterns = "/login")
public class AnonymousFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    /*Metodo doFilter que es el método principal utilizado para filtrar solicitudes y respuestas*/

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    /*Se realiza un casting de los parámetros request y response a HttpServletRequest y HttpServletResponse,
     respectivamente, para poder acceder a funcionalidades específicas de HTTP.*/

    Optional<String> username = SessionUtil.getUsername(httpRequest.getSession());

    /*Se llama al método getUsername(HttpSession session) del objeto SessionUtil para obtener el nombre de usuario
    almacenado en la sesión actual.*/

    /*Se utiliza Optional<String> para manejar el posible valor nulo devuelto
    por getUsername().*/

    if (username.isPresent()) {
      httpResponse.sendRedirect("home");

      /*Si hay un nombre de usuario en la sesion(isPresent) se redirige a URL home
      * utilizando sendRedirect("Home")*/
    } else {
      chain.doFilter(request, response);
    }
  }
}