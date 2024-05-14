package com.example.velocerentals.repositories.imp;

import com.example.velocerentals.config.DatabaseConnection;
import com.example.velocerentals.domain.models.User;
import com.example.velocerentals.repositories.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepositoryJDBCImp implements UserRepository {
  // How?
  private Connection connection;
  public UserRepositoryJDBCImp() throws SQLException {
    this.connection = DatabaseConnection.getInstance();
  }
  @Override
  public boolean save(User user) {
    try(PreparedStatement preparedStatement =  connection.prepareStatement("INSERT INTO users (first_name, last_name, email, password) VALUES (?,?,?,?)")){
      preparedStatement.setString(1, user.getFirstName());
      preparedStatement.setString(2, user.getLastName());
      preparedStatement.setString(3, user.getEmail());
      preparedStatement.setString(4, user.getPassword());

      int result = preparedStatement.executeUpdate();
      return result > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

  }

  @Override
  public boolean update(User user) {
    try(PreparedStatement preparedStatement =  connection.prepareStatement("UPDATE users SET first_name = ?, last_name = ?, email = ?, password = ? WHERE id = ?")){
      preparedStatement.setString(1, user.getFirstName());
      preparedStatement.setString(2, user.getLastName());
      preparedStatement.setString(3, user.getEmail());
      preparedStatement.setString(4, user.getPassword());
      preparedStatement.setLong(5, user.getId());

      int result = preparedStatement.executeUpdate();
      return result > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public Optional<User> findByEmail(String email) {
    try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ?")){
      preparedStatement.setString(1, email);
      return Optional.ofNullable(mapResultSetToUser(preparedStatement.executeQuery()));
    } catch (SQLException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
    if(resultSet.next()){
      return new User(
        resultSet.getLong("id"),
        resultSet.getString("first_name"),
        resultSet.getString("last_name"),
        resultSet.getString("email"),
        resultSet.getString("password")
      );
    }
    return null;
  }
}
