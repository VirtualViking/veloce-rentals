package com.example.velocerentals.services;

import com.example.velocerentals.domain.dtos.CreateVehicleDTO;
import com.example.velocerentals.domain.dtos.VehicleOutDTO;
import com.example.velocerentals.repositories.search_criteria.VehicleSearchCriteria;

import java.util.List;
import java.util.Optional;

/*Se define una interfaz llamada VehicleService. Una interfaz en Java es un contrato que
especifica los métodos que una clase debe implementar. En este caso, VehicleService especifica métodos
relacionados con la gestión de vehículos.*/
public interface VehicleService {
  boolean save(CreateVehicleDTO vehicle); // Este método se utiliza para guardar un vehículo en el sistema
    List<VehicleOutDTO> findAll(); // Este método se utiliza para recuperar todos los vehículos almacenados
  // en el sistema*/
    List<VehicleOutDTO> findByCriteria(VehicleSearchCriteria criteria);

    /*Este método se utiliza para encontrar un vehículo específico en el sistema según su ID.*/

    Optional<VehicleOutDTO> findById(Long id);

    /*Devuelve un Optional<VehicleOutDTO>, que es un contenedor que puede o no contener un valor no nulo*/
}
