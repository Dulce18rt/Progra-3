/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Controlador.Cursos;

/**
  Clase CursosDAO
 
 Esta clase se encarga de gestionar las operaciones de acceso
 a datos (DAO - Data Access Object) para la entidad Cursos.
  
 Todas las operaciones se realizan mediante consultas SQL
 utilizando PreparedStatement para evitar errores y mejorar
 la seguridad de las consultas.
 
 * @author Jorge Reyes
 */
public class CursosDAO {
    // Consulta SQL para mostrar todos los cursos
    private static final String SQL_SELECT = "SELECT CurCodigo, CurNombre, CurEstatus FROM cursos";
    // Consulta SQL para insertar un nuevo curso
    private static final String SQL_INSERT = "INSERT INTO CURSOS(CurCodigo, CurNombre, CurEstatus) VALUES(?,?,?)";
    // Consulta SQL para actualizar los datos de un curso
    private static final String SQL_UPDATE = "UPDATE CURSOS SET CurNombre=?, CurEstatus=? WHERE CurCodigo = ?";
    // Consulta SQL para eliminar un curso
    private static final String SQL_DELETE = "DELETE FROM CURSOS WHERE CurCodigo=?";
    // Consulta SQL para buscar un curso específico por su código
    private static final String SQL_QUERY = "SELECT CurCodigo, CurNombre, CurEstatus FROM cursos WHERE CurCodigo = ?";

    
    public List<Cursos> select() { 
    // Método que consulta todos los cursos de la base de datos
    // Devuelve una lista de objetos de tipo Cursos

        Connection conn = null;
        // Variable que almacenará la conexión con la base de datos
        PreparedStatement stmt = null;
        // Objeto que permitirá ejecutar la consulta SQL preparada
        ResultSet rs = null;
        // Objeto que almacenará los resultados de la consulta
        Cursos cursos = null;
        // Objeto temporal donde se guardará cada registro obtenido
        List<Cursos> cursoss = new ArrayList<Cursos>();
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

                int CurCodigo = rs.getInt("CurCodigo");
                // Se obtiene el código del curso desde la base de datos
                String CurNombre = rs.getString("CurNombre");
                // Se obtiene el nombre del curso
                String CurEstatus = rs.getString("CurEstatus");
                // Se obtiene el estado del curso
                cursos = new Cursos();
                // Se crea un nuevo objeto Cursos para almacenar los datos del registro
                cursos.setCurCodigo(CurCodigo);
                // Se asigna el código al objeto cursos
                cursos.setCurNombre(CurNombre);
                // Se asigna el nombre al objeto cursos
                cursos.setCurEstatus(CurEstatus);
                // Se asigna el estado al objeto cursos
                cursoss.add(cursos);
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

        return cursoss;
        // Se devuelve la lista con todos los cursos encontrados
    }
    

    public int insert(Cursos cursos) {
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
            stmt.setInt(1, cursos.getCurCodigo());
            // Se asigna el código del curso al primer parámetro de la consulta
            stmt.setString(2, cursos.getCurNombre());
            // Se asigna el nombre del curso al segundo parámetro
            stmt.setString(3, cursos.getCurEstatus());
            // Se asigna el estado del curso al tercer parámetro           
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
    

    public int update(Cursos cursos) {
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
            stmt.setString(1, cursos.getCurNombre());
            // Se asigna el nuevo nombre del curso
            stmt.setString(2, cursos.getCurEstatus());
            // Se asigna el nuevo estado del curso
            stmt.setInt(3, cursos.getCurCodigo());
            // Se indica el código del curso que se actualizará            
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
    

    public int delete(Cursos cursos) {
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
            stmt.setInt(1, cursos.getCurCodigo());
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


    public Cursos query(Cursos cursos) {    
        // Método que busca un curso específico por su código

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cursos> cursoss = new ArrayList<Cursos>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            // Se obtiene la conexión con la base de datos
            System.out.println("Ejecutando query:" + SQL_QUERY);
            // Se muestra la consulta que se ejecutará
            stmt = conn.prepareStatement(SQL_QUERY);
            // Se prepara la consulta SQL
            stmt.setInt(1, cursos.getCurCodigo());
            // Se asigna el código del curso que se desea buscar
            rs = stmt.executeQuery();
            // Se ejecuta la consulta
            while (rs.next()) {
            // Si se encuentra el registro se obtienen sus datos
                String CurNombre = rs.getString("CurNombre");
                // Se obtiene el nombre del curso
                int CurCodigo = rs.getInt("CurCodigo");
                // Se obtiene el código del curso
                String CurEstatus = rs.getString("CurEstatus");
                // Se obtiene el estado del curso                                
                cursos = new Cursos();
                // Se crea un nuevo objeto Cursos
                cursos.setCurCodigo(CurCodigo);
                // Se asigna el código al objeto
                cursos.setCurNombre(CurNombre);
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

        return cursos;
        // Se devuelve el curso encontrado
    }
}