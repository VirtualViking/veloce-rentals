package com.example.velocerentals.services.imp;

import com.example.velocerentals.domain.dtos.CreateVehicleDTO;
import com.example.velocerentals.domain.dtos.VehicleOutDTO;
import com.example.velocerentals.mappers.VehicleMapper;
import com.example.velocerentals.repositories.VehicleRepository;
import com.example.velocerentals.repositories.search_criteria.VehicleSearchCriteria;
import com.example.velocerentals.services.VehicleService;

import java.util.List;
import java.util.Optional;


/*Una implementación de la interfaz VehicleService, llamada VehicleServiceImp. Esta clase proporciona funcionalidades
con la gestión de vehículos, como guardar, buscar y recuperar información sobre vehículos.*/
public class VehicleServiceImp implements VehicleService {

  //Clase vehicleServiceImp implementa la interfaz VehicleService
  private VehicleRepository vehicleRepository;

  /*Se define un campo vehicleRepository, que es del tipo VehicleRepository. Este campo se utiliza para interactuar con
  la capa de persistencia para acceder y manipular datos de vehículos en la base de datos.*/

  public VehicleServiceImp(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;

    /*Se define un constructor que toma un parámetro VehicleRepository y lo utiliza para inicializar
    el campo vehicleRepository.*/
  }
  @Override
  public boolean save(CreateVehicleDTO vehicle) {
    return vehicleRepository.save(VehicleMapper.toEntity(vehicle));

    /*El método save(CreateVehicleDTO vehicle) de la interfaz VehicleService. Este método se utiliza para
    guardar un nuevo vehículo en la base de datos.*/

    /*Utiliza VehicleMapper.toEntity(vehicle) para convertir el DTO de creación de vehículo (CreateVehicleDTO) en una
    entidad de vehículo (Vehicle) que puede ser almacenada en la base de datos.*/

    /*Llama al método save() del repositorio de vehículos (vehicleRepository) para guardar la entidad de vehículo
    en la base de datos.*/
  }

  @Override
  public List<VehicleOutDTO> findAll() {
    return vehicleRepository
            .findAll()
            .stream()
            .map(VehicleMapper::toDTO)
            .toList();

    /*El método findAll() de la interfaz VehicleService. Este método se utiliza para recuperar todos los
    vehículos de la base de datos.*/

    /*Llama al método findAll() del repositorio de vehículos (vehicleRepository) para obtener una lista de
    todas las entidades de vehículos.*/

    /*Utiliza map(VehicleMapper::toDTO) para convertir cada entidad de vehículo en un DTO de salida de
    vehículo (VehicleOutDTO).*/

    /*Convierte el resultado en una lista llamando al método toList().*/
  }

  @Override
  public List<VehicleOutDTO> findByCriteria(VehicleSearchCriteria criteria) {
    return vehicleRepository
            .findByCriteria(criteria)
            .stream()
            .map(VehicleMapper::toDTO)
            .toList();
  }

  @Override
  public Optional<VehicleOutDTO> findById(Long id) {
    return vehicleRepository
            .findById(id)
            .map(VehicleMapper::toDTO);
  }
}
