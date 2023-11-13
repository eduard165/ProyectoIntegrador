/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

/**
 *
 * @author eduar
 */
public class Sucursal{
    private Integer idSucursal;
    private String nombre;
    private String codigoPostal;
    private String colonia;
    private String telefono;
    private double latitud;
    private double longitud;
    private String nombreEncargado;
    private Integer empresa;
    private Integer direccion;

    public Sucursal() {
    }

    public Sucursal(Integer idSucursal, String nombre, String codigoPostal, String colonia, String telefono, double latitud, double longitud, String nombreEncargado, Integer empresa, Integer direccion) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombreEncargado = nombreEncargado;
        this.empresa = empresa;
        this.direccion = direccion;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public Integer getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }

    public Integer getDireccion() {
        return direccion;
    }

    public void setDireccion(Integer direccion) {
        this.direccion = direccion;
    }
public boolean todosAtributosLlenos() {
        return 
               nombre != null &&
               codigoPostal != null &&
               colonia != null &&
               telefono != null &&
               nombreEncargado != null &&
               empresa != null &&
               direccion != null;
    }
}
