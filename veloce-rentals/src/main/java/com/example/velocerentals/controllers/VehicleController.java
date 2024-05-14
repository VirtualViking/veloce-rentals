package com.example.velocerentals.controllers;

import com.example.velocerentals.domain.dtos.CreateVehicleDTO;
import com.example.velocerentals.domain.dtos.VehicleOutDTO;
import com.example.velocerentals.domain.enums.Type;
import com.example.velocerentals.services.VehicleService;
import com.example.velocerentals.services.singleton.ServiceSingleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "vehicleController", value = "/vehicles")
public class VehicleController extends HttpServlet {
  private final VehicleService vehicleService = ServiceSingleton.getInstance().vehicleService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getParameter("id") != null) {
      Optional<VehicleOutDTO> vehicle =  vehicleService.findById(Long.valueOf(req.getParameter("id")));
      vehicle.ifPresent(v -> req.setAttribute("vehicle", v));
      req.getRequestDispatcher("vehicle-detail.jsp").forward(req, resp);
      return;
    }
    req.setAttribute("vehicles", vehicleService.findAll());
    req.getRequestDispatcher("vehicles.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String brand = req.getParameter("brand");
    String urlImage = req.getParameter("url_image");
    String model = req.getParameter("model");
    Type type = Type.valueOf(req.getParameter("type").toUpperCase());
    Double rentalPrice = Double.valueOf(req.getParameter("rental_price"));

    CreateVehicleDTO createVehicleDTO = new CreateVehicleDTO(brand, urlImage, model, type, rentalPrice);
    vehicleService.save(createVehicleDTO);
  }
}
