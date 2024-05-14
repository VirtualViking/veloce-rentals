package com.example.velocerentals.services.singleton;

import com.example.velocerentals.repositories.imp.UserRepositoryJDBCImp;
import com.example.velocerentals.repositories.imp.VehicleRepositoryJDBCImp;
import com.example.velocerentals.services.AuthService;
import com.example.velocerentals.services.VehicleService;
import com.example.velocerentals.services.imp.AuthServiceImp;
import com.example.velocerentals.services.imp.VehicleServiceImp;

import java.sql.SQLException;

/*Este singleton de servicio permite que los servicios solo se creen una vez, y los controladores
llaman al singleton para obtener la instancia de los servicios por medio del singleton*/
public class ServiceSingleton {
    private static ServiceSingleton instance = null;

    public AuthService authService;
    public VehicleService vehicleService;

    private ServiceSingleton()  {
      try{
        authService = new AuthServiceImp(new UserRepositoryJDBCImp());
        vehicleService = new VehicleServiceImp(new VehicleRepositoryJDBCImp());
      } catch (SQLException e) {
        throw new RuntimeException("Error initializing services", e);
      }
    }

    public static ServiceSingleton getInstance()  {
        if (instance == null) {
            instance = new ServiceSingleton();
        }
        return instance;
    }
}
