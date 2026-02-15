/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Jorge Reyes
 */
public class Computador {

    public Computador(String software, String Hardware) {
        this.software = software;
        this.Hardware = Hardware;
    }

    public Computador(int memoria) {
        this.memoria = memoria;
    }
   private String software;
   private String Hardware;
   private int memoria;

    public Computador(){
        
    }


    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getHardware() {
        return Hardware;
    }

    public void setHardware(String Hardware) {
        this.Hardware = Hardware;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }
    
   
    
}

