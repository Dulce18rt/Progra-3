/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Empresa;
import Modelo.EmpresaDAO;

/**
 *
 * @author Soporte
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empresa empresa = new Empresa("Universidad Mariano Galvez");
        System.out.println(empresa.toString());
        EmpresaDAO empresadao = new EmpresaDAO();
        empresadao.insert(empresa);
        empresadao.query(empresa);
        
        empresa.setCodigoEmpresa(12);
      empresadao.delete(empresa); // borra  
     // empresa.setNombreEmpresa("Minecraft");// cambio de nombre para el update
     // empresadao.update(empresa); // actualiza 
        empresa=empresadao.query(empresa);
        System.out.println(empresa.toString());
        
    }
    
}
