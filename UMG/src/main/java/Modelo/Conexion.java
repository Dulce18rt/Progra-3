/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
/**
  Clase Conexion
  
  Esta clase se encarga de gestionar la conexión entre 
  Java y la base de datos MySQL.
  
  Contiene los datos necesarios para establecer la conexión,
  Además, incluye métodos para cerrar correctamente los recursos
  utilizados en las consultas SQL como ResultSet, PreparedStatement
  y Connection, evitando así fugas de memoria o conexiones abiertas.
  
 * @author Jorge Reyes
 */
public class Conexion { // Declaración de la clase Conexion, que administra la conexión con la base de datos

    private static final String JDBC_URL = "jdbc:mysql://localhost/umg?useSSL=false&serverTimezone=UTC"; // Conexión a la base de datos MySQL
    private static final String JDBC_USER = "usuprueba"; // Variable constante que guarda el nombre de usuario para conectarse a la base de datos   
    private static final String JDBC_PASS = "123456"; // Variable constante que guarda la contraseña del usuario de la base de datos
   
    public static Connection getConnection() throws SQLException { // Método público y estático que devuelve un objeto Connection
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS); // Utiliza DriverManager para crear y devolver la conexión usando la URL, usuario y contraseña
    }
    
    public static void close(ResultSet rs){
    // Método para cerrar un objeto ResultSet
    // ResultSet contiene los resultados de una consulta SQL
        try {
            rs.close(); 
            // Cierra el ResultSet para liberar recursos
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            // Si ocurre un error al cerrar, se imprime en la consola
        }
    }
    
    public static void close(PreparedStatement stmt){
        // Método para cerrar un objeto PreparedStatement
    // PreparedStatement se usa para ejecutar consultas SQL preparadas
        try {
            stmt.close();
            // Cierra el PreparedStatement para liberar recursos
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            // Muestra el error en consola si ocurre una excepción
        }
    }
    
    public static void close(Connection conn){
        // Método para cerrar la conexión con la base de datos
        try {
            conn.close();
            // Cierra la conexión activa con la base de datos
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
           // Si ocurre un error al cerrar la conexión, se muestra en consola
        }
    }
}
