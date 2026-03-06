/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Jorge Reyes
 */
/*
  Clase Cursos
  
  Esta clase representa la entidad "Cursos" dentro del sistema.
  Se utiliza para almacenar y manejar la información relacionada
  con los cursos registrados en la base de datos.
  
  Contiene los atributos principales del curso, así como
  sus métodos getters y setters para acceder y modificar
  la información.
 */
public class Cursos {
    private int CurCodigo; // Atributo que almacena el código único del curso
    private String CurNombre;// Atributo que almacena el nombre del curso
    private String CurEstatus;// Atributo que almacena el estado del curso (Activo o Inactivo)

     /*
     Método toString
      
     Permite mostrar la información del objeto en forma de texto,
     lo cual es útil para imprimir los datos del curso en consola.
     */
    @Override
    public String toString() {
        return "Cursos{" + "CurCodigo=" + CurCodigo + ", CurNombre=" + CurNombre + ", CurEstatus=" + CurEstatus + '}';
    }

    public int getCurCodigo() { //Método getter para obtener el código del curso
        return CurCodigo;
    }

    public void setCurCodigo(int CurCodigo) { //Método setter para modificar el código del curso
        this.CurCodigo = CurCodigo;
    }

    public String getCurNombre() { //Método getter para obtener el nombre del curso
        return CurNombre;
    }

    public void setCurNombre(String CurNombre) { //Método setter para modificar el nombre del curso
        this.CurNombre = CurNombre;
    }

    public String getCurEstatus() { //Método getter para obtener el estado del curso
        return CurEstatus;
    }

    public void setCurEstatus(String CurEstatus) { //Método setter para modificar el estado del curso
        this.CurEstatus = CurEstatus;
    }
    
    /*
     Constructor con todos los parámetros
      
     Permite crear un objeto curso con todos sus datos
     (código, nombre y estatus).
     */
    public Cursos(int CurCodigo, String CurNombre, String CurEstatus) {
        this.CurCodigo = CurCodigo;
        this.CurNombre = CurNombre;
        this.CurEstatus = CurEstatus;
    }

    /*
     Constructor que recibe únicamente el código del curso
     
     Se utiliza generalmente para búsquedas o eliminaciones
     dentro de la base de datos.
     */
    public Cursos(int CurCodigo) {
        this.CurCodigo = CurCodigo;
    }

    /*
     Constructor vacío
      
     Permite crear un objeto curso sin inicializar
     los atributos, para luego asignar valores
     mediante los métodos setters.
     */
    public Cursos() {        
    }
    
}
