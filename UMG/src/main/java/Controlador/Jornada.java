/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Jorge Reyes
 */
public class Jornada {
    private int JorCodigo; // Atributo que almacena el código único del curso
    private String JorNombre;// Atributo que almacena el nombre del curso

    public int getJorCodigo() {
        return JorCodigo;
    }

    public void setJorCodigo(int JorCodigo) {
        this.JorCodigo = JorCodigo;
    }

    public String getJorNombre() {
        return JorNombre;
    }

    public void setJorNombre(String JorNombre) {
        this.JorNombre = JorNombre;
    }

    public Jornada(int JorCodigo, String JorNombre) {
        this.JorCodigo = JorCodigo;
        this.JorNombre = JorNombre;
    }
    public Jornada(int CurCodigo) {
        this.JorCodigo = JorCodigo;
    }

    /*
     Constructor vacío
      
     Permite crear un objeto curso sin inicializar
     los atributos, para luego asignar valores
     mediante los métodos setters.
     */
    public Jornada() {        
    }
}
