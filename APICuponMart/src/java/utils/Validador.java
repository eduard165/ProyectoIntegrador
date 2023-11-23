/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import modelo.pojo.Sucursal;

/**
 *
 * @author eduar
 */
public class Validador {
       public static boolean validarDatosSucursal(Sucursal sucu) {
      if( sucu.getEmpresaRFC() == null && sucu.getDireccionID() < 0 && sucu.getNombre() == null && sucu.getTelefono() == null && sucu.getNombreEncargado() == null)
          return false;
      else
             return true;
    }
}
