package com.example.velocerentals.filters;

import com.example.velocerentals.utils.CookieUtil;
import com.example.velocerentals.utils.SessionUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Optional;

@WebFilter(filterName = "usernameFilter", urlPatterns = "/*")
public class UsernameFilter implements Filter {

  /*Se utiliza @WebFilter para configurar la clase UsernameFilter como un filtro de servlet.
  Esta anotación especifica el nombre del filtro (filterName) y los patrones de URL (urlPatterns) a los que se
  aplicará el filtro.El filtro se aplicará a todas las URL ("/*").*/
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    Optional<String> username = SessionUtil.getUsername(httpRequest.getSession());
    /*Se llama al método getUsername(HttpSession session) del objeto SessionUtil para obtener el nombre de usuario
    almacenado en la sesión actual.*/
    username.ifPresent(u -> httpRequest.setAttribute("username", u));
    chain.doFilter(request, response);
  }
}
