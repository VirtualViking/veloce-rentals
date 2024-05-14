package com.example.velocerentals.controllers;

import com.example.velocerentals.services.AuthService;
import com.example.velocerentals.services.singleton.ServiceSingleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "loginController", value = "/login")
public class LoginController extends HttpServlet {
  private final AuthService authService = ServiceSingleton.getInstance().authService;
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String email = req.getParameter("email");
    String password = req.getParameter("password");

    if (authService.login(email, password)) {
      HttpSession session = req.getSession();
      session.setAttribute("username", email);

      resp.sendRedirect("home");
    } else {
      resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid email or password");
    }

  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect("login.jsp");
  }
}
