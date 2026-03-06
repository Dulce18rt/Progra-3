/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Jornada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jorge Reyes
 */
public class JornadaDAO {
    // Consulta SQL para mostrar todos los cursos
    private static final String SQL_SELECT = "SELECT JorCodigo, JorNombre FROM cursos";
    // Consulta SQL para insertar un nuevo curso
    private static final String SQL_INSERT = "INSERT INTO CURSOS(JorCodigo, JorNombre) VALUES(?,?)";
    // Consulta SQL para actualizar los datos de un curso
    private static final String SQL_UPDATE = "UPDATE CURSOS SET JorNombre=? WHERE JorCodigo = ?";
    // Consulta SQL para eliminar un curso
    private static final String SQL_DELETE = "DELETE FROM CURSOS WHERE JorCodigo=?";
    // Consulta SQL para buscar un curso específico por su código
    private static final String SQL_QUERY = "SELECT JorCodigo, JorNombre FROM cursos WHERE JorCodigo = ?";
    
    public List<Jornada> select() { 
    // Método que consulta todos los cursos de la base de datos
    // Devuelve una lista de objetos de tipo Cursos

        Connection conn = null;
        // Variable que almacenará la conexión con la base de datos
        PreparedStatement stmt = null;
        // Objeto que permitirá ejecutar la consulta SQL preparada
        ResultSet rs = null;
        // Objeto que almacenará los resultados de la consulta
        Jornada jornada = null;
        // Objeto temporal donde se guardará cada registro obtenido
        List<Jornada> Jornadas = new ArrayList<Jornada>();
        // Lista donde se almacenarán todos los cursos obtenidos de la base de datos

        try {
            conn = Conexion.getConnection();    
            // Se obtiene la conexión con la base de datos
            stmt = conn.prepareStatement(SQL_SELECT);
            // Se prepara la consulta SQL definida en la variable SQL_SELECT
            rs = stmt.executeQuery();
            // Se ejecuta la consulta SELECT

            while (rs.next()) { 
            // Se recorren todos los registros obtenidos en el ResultSet

                int JorCodigo = rs.getInt("JorCodigo");
                // Se obtiene el código del curso desde la base de datos
                String JorNombre = rs.getString("JorNombre");
                // Se obtiene el nombre del curso
                jornada = new Jornada();
                // Se crea un nuevo objeto Cursos para almacenar los datos del registro
                jornada.setJorCodigo(JorCodigo);
                // Se asigna el código al objeto cursos
                jornada.setJorNombre(JorNombre);
                // Se asigna el nombre al objeto cursos
                Jornadas.add(jornada);
                // Se agrega el objeto cursos a la lista de cursos
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            // Si ocurre un error en la consulta se imprime en la consola

        } finally {
            Conexion.close(rs);
            // Se cierra el ResultSet
            Conexion.close(stmt);
            // Se cierra el PreparedStatement
            Conexion.close(conn);
            // Se cierra la conexión con la base de datos
        }

        return Jornadas;
        // Se devuelve la lista con todos los cursos encontrados
    }
   
    public int insert(Jornada jornada) {
        // Método que inserta un nuevo curso en la base de datos

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        // Variable que almacenará la cantidad de registros afectados

        try {
            conn = Conexion.getConnection();
            // Se obtiene la conexión con la base de datos

            stmt = conn.prepareStatement(SQL_INSERT);
            // Se prepara la consulta SQL de inserción
            stmt.setInt(1, jornada.getJorCodigo());
            // Se asigna el código del curso al primer parámetro de la consulta
            stmt.setString(2, jornada.getJorNombre());
            // Se asigna el nombre del curso al segundo parámetro         
            System.out.println("ejecutando query:" + SQL_INSERT);
            // Se muestra en consola la consulta que se ejecutará
            rows = stmt.executeUpdate();
            // Se ejecuta la inserción en la base de datos
            System.out.println("Registros afectados:" + rows);
            // Se muestra cuántos registros fueron insertados

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
        // Se devuelve el número de registros insertados
    }
    
    public int update(Jornada jornada) {
        // Método que actualiza los datos de un curso existente

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            // Se obtiene la conexión con la base de datos
            System.out.println("ejecutando query: " + SQL_UPDATE);
            // Se muestra la consulta de actualización
            stmt = conn.prepareStatement(SQL_UPDATE);
            // Se prepara la consulta SQL
            stmt.setInt(1, jornada.getJorCodigo());
            // Se asigna el código del curso al primer parámetro de la consulta
            stmt.setString(2, jornada.getJorNombre());
            // Se asigna el nombre del curso al segundo parámetro        
            rows = stmt.executeUpdate();
            // Se ejecuta la actualización en la base de datos
            System.out.println("Registros actualizado:" + rows);
            // Se muestra cuántos registros fueron modificados

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
        // Se devuelve la cantidad de registros actualizados
    }
    
public int delete(Jornada jornada) {
        // Método que elimina un curso de la base de datos

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            // Se obtiene la conexión con la base de datos
            System.out.println("Ejecutando query:" + SQL_DELETE);
            // Se muestra la consulta que eliminará el registro
            stmt = conn.prepareStatement(SQL_DELETE);
            // Se prepara la consulta SQL
            stmt.setInt(1, jornada.getJorCodigo());
            // Se establece el código del curso que se desea eliminar
            rows = stmt.executeUpdate();
            // Se ejecuta la eliminación
            System.out.println("Registros eliminados:" + rows);
            // Se muestra cuántos registros fueron eliminados

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
        // Se devuelve la cantidad de registros eliminados
    }
public Jornada query(Jornada jornada) {    
        // Método que busca un curso específico por su código

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
         List<Jornada> Jornadas = new ArrayList<Jornada>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            // Se obtiene la conexión con la base de datos
            System.out.println("Ejecutando query:" + SQL_QUERY);
            // Se muestra la consulta que se ejecutará
            stmt = conn.prepareStatement(SQL_QUERY);
            // Se prepara la consulta SQL
            stmt.setInt(1, jornada.getJorCodigo());
            // Se asigna el código del curso que se desea buscar
            rs = stmt.executeQuery();
            // Se ejecuta la consulta
            while (rs.next()) {
            // Si se encuentra el registro se obtienen sus datos
                String JorNombre = rs.getString("JorNombre");
                // Se obtiene el nombre del curso
                int JorCodigo = rs.getInt("JorCodigo");
                // Se obtiene el código del curso                         
                jornada = new Jornada();
                // Se crea un nuevo objeto Cursos
                jornada.setJorCodigo(JorCodigo);
                // Se asigna el código al objeto
                jornada.setJorNombre(JorNombre);
                // Se asigna el nombre al objeto          
                //empleados.add(empleado); 
                // Comentario dejado para cuando se utilice una lista
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return jornada;
        // Se devuelve el curso encontrado
    }
    
}
