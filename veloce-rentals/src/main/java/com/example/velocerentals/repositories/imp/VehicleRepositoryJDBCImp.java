package com.example.velocerentals.repositories.imp;

import com.example.velocerentals.config.DatabaseConnection;
import com.example.velocerentals.domain.enums.Type;
import com.example.velocerentals.domain.models.Vehicle;
import com.example.velocerentals.repositories.VehicleRepository;
import com.example.velocerentals.repositories.search_criteria.VehicleSearchCriteria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleRepositoryJDBCImp implements VehicleRepository {
  private Connection connection;
  public VehicleRepositoryJDBCImp() throws SQLException {
    this.connection = DatabaseConnection.getInstance();
  }
  @Override
  public boolean save(Vehicle vehicle) {
    try(PreparedStatement  statement = connection.prepareStatement("INSERT INTO vehicles (brand, url_image , model, type, rental_price) VALUES (?,?,?,?,?)")){
      statement.setString(1, vehicle.getBrand());
      statement.setString(2, vehicle.getUrlImage());
      statement.setString(3, vehicle.getModel());
      statement.setString(4, vehicle.getType().name());
      statement.setDouble(5, vehicle.getRentalPrice());
      int count = statement.executeUpdate();
      return count > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<Vehicle> findAll() {
    try(Statement statement = connection.createStatement()){
      ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicles");
      return mapResultSetToVehicleList(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Vehicle> findByCriteria(VehicleSearchCriteria criteria) {
    String query = getSearchCriteriaQuery(criteria);
    try(PreparedStatement statement = connection.prepareStatement(query)){
      int index = 1;
      if(criteria.brand != null){
        statement.setString(index++, criteria.brand);
      }
      if(criteria.model != null){
        statement.setString(index++, criteria.model);
      }
      if(criteria.type != null){
        statement.setString(index++, criteria.type.name());
      }
      if(criteria.minRentalPrice != null){
        statement.setDouble(index++, criteria.minRentalPrice);
      }
      if(criteria.maxRentalPrice != null){
        statement.setDouble(index++, criteria.maxRentalPrice);
      }
      if(criteria.startDate != null){
        statement.setTimestamp(index++, Timestamp.valueOf(criteria.startDate));
      }
      if(criteria.endDate != null){
        statement.setTimestamp(index++, Timestamp.valueOf(criteria.endDate));
      }
      ResultSet resultSet = statement.executeQuery();
      return mapResultSetToVehicleList(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Optional<Vehicle> findById(Long id) {
    try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM vehicles WHERE id = ?")){
      statement.setLong(1, id);
      ResultSet resultSet = statement.executeQuery();
      if(resultSet.next()){
        return Optional.of(mapResultSetToVehicle(resultSet));
      }
      return Optional.empty();
    } catch (SQLException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  private List<Vehicle> mapResultSetToVehicleList(ResultSet resultSet) throws SQLException {
    List<Vehicle> vehicles = new ArrayList<>();
    while (resultSet.next()) {
      Vehicle vehicle = mapResultSetToVehicle(resultSet);
      vehicles.add(vehicle);
    }
    return vehicles;
  }

  private Vehicle mapResultSetToVehicle(ResultSet resultSet) throws SQLException {
      return new Vehicle(
        resultSet.getLong("id"),
        resultSet.getString("brand"),
        resultSet.getString("url_image"),
        resultSet.getString("model"),
        Type.valueOf(resultSet.getString("type")),
        resultSet.getDouble("rental_price")
      );
  }
  private String getSearchCriteriaQuery(VehicleSearchCriteria criteria){
    StringBuilder query = new StringBuilder("SELECT * FROM vehicles  WHERE 1=1");

    if(criteria.brand != null){
      query.append(" AND brand = ?");
    }
    if(criteria.model != null){
      query.append(" AND model = ?");
    }
    if(criteria.type != null){
      query.append(" AND type = ?");
    }
    if(criteria.minRentalPrice != null){
      query.append(" AND rental_price >= ?");
    }
    if(criteria.maxRentalPrice != null){
      query.append(" AND rental_price <= ?");
    }
    if(criteria.startDate != null && criteria.endDate != null){
      query.append(" AND id NOT IN (SELECT vehicle_id FROM rentals WHERE (start_date BETWEEN ? AND ?) OR (end_date BETWEEN ? AND ?))");
    }
    return query.toString();
  }
}
