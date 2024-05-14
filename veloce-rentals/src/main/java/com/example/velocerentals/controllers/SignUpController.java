package com.example.velocerentals.controllers;

import com.example.velocerentals.domain.dtos.UserSignupDTO;
import com.example.velocerentals.services.AuthService;
import com.example.velocerentals.services.singleton.ServiceSingleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "signupController", value = "/register")
public class SignUpController extends HttpServlet {
  private final AuthService authService = ServiceSingleton.getInstance().authService;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    String email = req.getParameter("email");
    String password = req.getParameter("password");

    boolean wasCreated = authService.signUp(new UserSignupDTO(firstName, lastName, email, password));

    if (wasCreated) {
      resp.sendRedirect("login");
    } else {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error creating user. Please try again.");
    }

  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect("signup.jsp");
  }
}
