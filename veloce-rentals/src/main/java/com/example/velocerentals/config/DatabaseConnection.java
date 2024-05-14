package com.example.velocerentals.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class                DatabaseConnection {
  private static String url = "jdbc:mysql://localhost:3306/veloce_rentals";
  private static String user = "root";
  private static String password = "";
  private static Connection connection; //singleton, objeto de conexion
  public static Connection getInstance() throws SQLException { /*Metodo estatico que retorna
  un objeto de conexion*/
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    if(connection==null){
      connection = DriverManager.getConnection(url,user,password);
    }
    return connection;
  }
}
