package com.example.velocerentals;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

  /*La clase extiende HttpServlet, lo que significa que es un servlet que maneja solicitudes HTTP.*/
  private String message;

  public void init() {
    message = "Hello World!";
  }

  /*initi() Este método se llama cuando el servlet se inicializa por primera vez.*/

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");

    /*Este método se llama cuando el servlet recibe una solicitud HTTP GET*/

    // Hello
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>" + message + "</h1>");
    out.println("</body></html>");
  }

  public void destroy() { //Metodo definidio sin ninguna accion
  }
}