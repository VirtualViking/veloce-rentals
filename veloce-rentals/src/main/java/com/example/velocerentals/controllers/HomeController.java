package com.example.velocerentals.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "homeController", value = "/home") /*Nombre del servlet y la URL
que responde (value)*/
public class HomeController extends HttpServlet { /*HomeController es una clase que puede
manejar solicitudes HTTP.La clase está configurada como un servlet mediante
la anotación @WebServlet*/
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("home.jsp").forward(req, resp);
  }
}


