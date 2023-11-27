/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import modelo.pojo.Empresa;

/**
 *
 * @author eduar
 */
public class Validaciones {
    
    public static Boolean validarEmpresa(Empresa empresa){    
        String expresionRegular = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
        return empresa.getNombre().isEmpty()
                && empresa.getRFC().isEmpty()
                && empresa.getEmail() != expresionRegular
                && empresa.getNombreComercial().isEmpty()
                &&empresa.getRepresentanteLegal().isEmpty()
                &&empresa.getTelefono().length() != 10;
                
    }
     public static Boolean ValidarCosas(){
         return false;
     }

}
